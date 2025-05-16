package dev.ecr.graphqlqbe.Promocion;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PromocionResolver {

    private final PromocionRepository promocionRepository;

    public PromocionResolver(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    // Resolver para la query 'promociones'
    @QueryMapping
    public List<Promocion> promociones() {
        return promocionRepository.findAll();
    }

    // Resolver para la query 'promocionesdasboard'
    @QueryMapping
    public List<Promocion> promocionesdasboard(@Argument Boolean activa) {
        if (activa != null) {
            return promocionRepository.findByActiva(activa);
        }
        return promocionRepository.findAll();
    }

    // Resolver para obtener promoción por ID
    @QueryMapping
    public Promocion obtenerPromocionPorId(@Argument Integer id) {
        return promocionRepository.findById(id).orElse(null);
    }
}
