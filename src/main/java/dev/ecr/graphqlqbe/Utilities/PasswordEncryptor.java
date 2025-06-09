package dev.ecr.graphqlqbe.Utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptor {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncryptor() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encrypt(String contrasena) {
        return passwordEncoder.encode(contrasena);
    }

    public boolean matches(String contrasena, String hash) {
        return passwordEncoder.matches(contrasena, hash);
    }
}
