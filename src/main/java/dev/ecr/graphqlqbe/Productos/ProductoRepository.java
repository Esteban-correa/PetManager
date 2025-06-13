package dev.ecr.graphqlqbe.Productos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByProductoIdIn(List<Integer> ids);
}
