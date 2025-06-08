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

    @QueryMapping
    public List<Promocion> promociones() {
        return promocionRepository.findAll();
    }

    @QueryMapping
    public List<Promocion> promocionesdasboard(@Argument Boolean activa) {
        if (activa != null) {
            return promocionRepository.findByActiva(activa);
        }
        return promocionRepository.findAll();
    }

    @QueryMapping
    public Promocion obtenerPromocionPorId(@Argument Integer id) {
        return promocionRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Promocion> promocionesCategoria(@Argument String categoria) {
        return promocionRepository.findByCategoria(categoria);
    }
}
