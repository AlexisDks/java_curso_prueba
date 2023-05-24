package pe.spring.curso.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        var pasword = "123456";
        System.out.println("password: " + pasword);
        System.out.println("password encriptado: " + encriptarPassword(pasword));
    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
