package dev.ecr.graphqlqbe.Promocion;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@Controller
public class PromocionResolver {

    private final PromocionRepository promocionRepository;

    public PromocionResolver(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    // ✅ Visible para todos los usuarios autenticados (ADMIN o USUARIO)
    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public List<Promocion> promociones() {
        return promocionRepository.findAllWithProductos(); // <-- Carga productos automáticamente
    }

    // ✅ Solo visible para ADMIN
    @QueryMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Promocion> promocionesdasboard(@Argument Boolean activa) {
        if (activa != null) {
            return promocionRepository.findByActiva(activa);
        }
        return promocionRepository.findAll();
    }

    // ✅ Visible para ADMIN o USUARIO
    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public Promocion obtenerPromocionPorId(@Argument Integer id) {
        return promocionRepository.findById(id).orElse(null);
    }

    // ✅ Visible para ADMIN o USUARIO
    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public List<Promocion> promocionesCategoria(@Argument String categoria) {
        return promocionRepository.findByCategoria(categoria);
    }
}
