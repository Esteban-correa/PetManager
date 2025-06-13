package dev.ecr.graphqlqbe.Promocion;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface PromocionRepository extends JpaRepository<Promocion, Integer>, QueryByExampleExecutor<Promocion> {

    @EntityGraph(attributePaths = {"productos"})
    @Query("SELECT p FROM Promocion p JOIN FETCH p.productos")
    List<Promocion> findAllWithProductos();

    List<Promocion> findByActiva(Boolean activa);

    List<Promocion> findByCategoria(String categoria);

    // O si quieres ignorar mayúsculas/minúsculas
    // List<Promocion> findByCategoriaIgnoreCase(String categoria);
}
