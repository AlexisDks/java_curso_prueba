package pe.spring.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.spring.curso.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
