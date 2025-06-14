package dev.ecr.graphqlqbe.Autentificacion;

import dev.ecr.graphqlqbe.Auth.Config.JwtUtil;
import dev.ecr.graphqlqbe.Utilities.PasswordEncryptor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsuarioResolver {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncryptor passwordEncryptor;

    private final JwtUtil jwtUtil;

    public UsuarioResolver(UsuarioRepository usuarioRepository, PasswordEncryptor passwordEncryptor, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncryptor = passwordEncryptor;
        this.jwtUtil = jwtUtil;
    }


    @QueryMapping
    public List<Usuario> usuarios() {
        return usuarioRepository.findAll();
    }

    @QueryMapping
    public Usuario usuario(@Argument Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @QueryMapping
    public List<Usuario> usuariosPorRol(@Argument String rol) {
        return usuarioRepository.findByRol(rol);
    }

    @QueryMapping
    public List<Usuario> usuariosPorEstado(@Argument String estado) {
        return usuarioRepository.findByEstado(estado);
    }

    public record UsuarioInput(String nombreUsuario, String contrasena, String rol, String estado) {}

    @MutationMapping(name = "insertarUsuario")
    public Usuario insertarUsuario(@Argument UsuarioInput input) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(input.nombreUsuario());
        usuario.setContrasena(passwordEncryptor.encrypt(input.contrasena()));
        usuario.setRol(input.rol());
        usuario.setEstado(input.estado());
        usuario.setFechaCreacion(java.time.LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    @MutationMapping(name = "updateUsuario")
    public Usuario updateUsuario(@Argument Long id, @Argument UsuarioInput input) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombreUsuario(input.nombreUsuario());
        usuario.setContrasena(passwordEncryptor.encrypt(input.contrasena()));
        usuario.setRol(input.rol());
        usuario.setEstado(input.estado());
        return usuarioRepository.save(usuario);
    }

    @MutationMapping(name = "deleteUsuario")
    public Boolean deleteUsuario(@Argument Long id) {
        usuarioRepository.deleteById(id);
        return true;
    }

    @MutationMapping(name = "loginUsuario")
    public String loginUsuario(@Argument String nombreUsuario, @Argument String contrasena) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncryptor.matches(contrasena, usuario.getContrasena())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generateToken(usuario.getNombreUsuario(), usuario.getRol());
    }

}