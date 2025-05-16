package dev.ecr.graphqlqbe.Autentificacion;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(request.getNombreUsuario());

        if (usuario == null) {
            return "Usuario no encontrado";
        }

        if (!Objects.equals(usuario.getContrasenaHash(), request.getContrasena())) {
            return "Contraseña incorrecta";
        }

        if (!usuario.getEstado().equalsIgnoreCase("activo")) {
            return "Usuario inactivo";
        }

        return "Inicio de sesión exitoso para: " + usuario.getNombreUsuario();
    }
}