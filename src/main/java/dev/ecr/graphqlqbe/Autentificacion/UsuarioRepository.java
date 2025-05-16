package dev.ecr.graphqlqbe.Autentificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
    List<Usuario> findByRol(String rol);
    List<Usuario> findByEstado(String estado);
}