package dev.ecr.graphqlqbe.Productos;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class ProductoMutation {

    private final ProductoRepository productoRepository;

    public ProductoMutation(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Producto crearProducto(@Argument("input") ProductoInput input) {
        Producto producto = new Producto();
        producto.setNombre(input.getNombre());
        producto.setPrecio(input.getPrecio());
        return productoRepository.save(producto);
    }
}
