package dev.ecr.graphqlqbe.Promocion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface PromocionRepository extends JpaRepository<Promocion, Integer>, QueryByExampleExecutor<Promocion> {
    List<Promocion> findByActiva(Boolean activa);
}
