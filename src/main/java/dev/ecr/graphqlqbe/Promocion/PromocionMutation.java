package dev.ecr.graphqlqbe.promotions;

import dev.ecr.graphqlqbe.Promocion.Promocion;
import dev.ecr.graphqlqbe.Promocion.PromocionInput;
import dev.ecr.graphqlqbe.Promocion.PromocionRepository;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;

import java.time.LocalDate;

@Controller
public class PromocionMutation {

    private final PromocionRepository promocionRepository;

    public PromocionMutation(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    // Eliminar promoción
    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Boolean deletePromocion(@Argument Integer id) {
        if (promocionRepository.existsById(id)) {
            try {
                promocionRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                System.err.println("Error al borrar promoción: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    // Crear promoción
    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Promocion crearPromocion(@Argument("input") PromocionInput input) {
        Promocion promocion = new Promocion();
        promocion.setTitulo(input.getTitulo());
        promocion.setDescripcion(input.getDescripcion());
        promocion.setFechaInicio(LocalDate.parse(input.getFechaInicio()));
        promocion.setFechaFin(LocalDate.parse(input.getFechaFin()));
        promocion.setPorcentajeDescuento(input.getPorcentajeDescuento());
        promocion.setActiva(input.getActiva() != null ? input.getActiva() : true);
        promocion.setCategoria(input.getCategoria());
        promocion.setProductos(null);

        return promocionRepository.save(promocion);
    }

    // Actualizar promoción
    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Promocion actualizarPromocion(@Argument Integer id, @Argument("input") PromocionInput input) {
        return promocionRepository.findById(id).map(promocion -> {
            if (input.getTitulo() != null) promocion.setTitulo(input.getTitulo());
            if (input.getDescripcion() != null) promocion.setDescripcion(input.getDescripcion());
            if (input.getFechaInicio() != null) promocion.setFechaInicio(LocalDate.parse(input.getFechaInicio()));
            if (input.getFechaFin() != null) promocion.setFechaFin(LocalDate.parse(input.getFechaFin()));
            if (input.getPorcentajeDescuento() != null) promocion.setPorcentajeDescuento(input.getPorcentajeDescuento());
            if (input.getActiva() != null) promocion.setActiva(input.getActiva());
            if (input.getCategoria() != null) promocion.setCategoria(input.getCategoria());
            return promocionRepository.save(promocion);
        }).orElse(null);
    }
}