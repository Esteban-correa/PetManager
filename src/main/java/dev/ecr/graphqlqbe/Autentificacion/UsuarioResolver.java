package dev.ecr.graphqlqbe.Autentificacion;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsuarioResolver {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResolver(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @QueryMapping
    public List<Usuario> usuarios() {
        return usuarioRepository.findAll(); // o filtra por estado si lo deseas
    }

    @QueryMapping
    public Usuario usuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    @QueryMapping
    public List<Usuario> usuariosPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }
}
