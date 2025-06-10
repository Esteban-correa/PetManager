package dev.ecr.graphqlqbe.Autentificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;
import java.util.Optional;

@GraphQlRepository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, QueryByExampleExecutor<Usuario> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);  // coincide con nombre del atributo

    List<Usuario> findByRol(String rol);

    List<Usuario> findByEstado(String estado);
}