package pe.spring.curso.config;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public void filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/", "/errors/error403").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/agregar", "/editar/**", "/eliminar", "/guardar").hasRole("ADMIN").and()
                .formLogin(login -> login
                        .loginPage("/login").permitAll().defaultSuccessUrl("/").permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login").permitAll())
                .exceptionHandling(handling -> handling.accessDeniedPage("/errors/error403"));
    }
}
