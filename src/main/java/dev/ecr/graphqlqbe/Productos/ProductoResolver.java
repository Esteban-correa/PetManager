package dev.ecr.graphqlqbe.Productos;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductoResolver {

    private final ProductoRepository productoRepository;

    public ProductoResolver(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @QueryMapping
    public List<Producto> productos() {
        return productoRepository.findAll();
    }

    @QueryMapping
    public Producto obtenerProductoPorId(@Argument Integer id) {
        return productoRepository.findById(id).orElse(null);
    }
}
