package dev.ecr.graphqlqbe;

import dev.ecr.graphqlqbe.Autentificacion.Usuario;
import dev.ecr.graphqlqbe.Autentificacion.UsuarioRepository;
import dev.ecr.graphqlqbe.Productos.Producto;
import dev.ecr.graphqlqbe.Productos.ProductoRepository;
import dev.ecr.graphqlqbe.Promocion.Promocion;
import dev.ecr.graphqlqbe.Promocion.PromocionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalDate;
import java.util.Collections;


@Component
public class DataLoader implements CommandLineRunner {
    private final PromocionRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public DataLoader(PromocionRepository repository,ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        List<Producto> productos = List.of(
                new Producto("Teclado Mecánico RGB", 250_000.0),
                new Producto("Mouse Gamer", 150_000.0),
                new Producto("Monitor 144Hz", 950_000.0),
                new Producto("Audífonos Inalámbricos", 180_000.0)
        );
        productoRepository.saveAll(productos);

        List<Promocion> promociones = List.of(
                new Promocion(
                        "Descuento de Verano",
                        "30% de descuento en productos seleccionados",
                        LocalDate.now(),
                        LocalDate.now().plusDays(10),
                        30.0,
                        true,
                        Collections.emptyList()
                ),
                new Promocion(
                        "2x1 en Accesorios",
                        "Compra uno y llévate otro gratis en todos los accesorios",
                        LocalDate.now().plusDays(1),
                        LocalDate.now().plusDays(5),
                        50.0,  // Simula como si fuese 50% por 2x1
                        true,
                        Collections.emptyList()
                ),
                new Promocion(
                        "Fin de Temporada",
                        "Descuentos hasta del 60% por cierre de temporada",
                        LocalDate.now().minusDays(2),
                        LocalDate.now().plusDays(3),
                        60.0,
                        true,
                        Collections.emptyList()
                ),
                new Promocion(
                        "Promoción Expirada",
                        "Esta promoción ya terminó",
                        LocalDate.now().minusDays(10),
                        LocalDate.now().minusDays(1),
                        25.0,
                        false,
                        Collections.emptyList()
                )
        );
//Guardar todos
        repository.saveAll(promociones);





    }
}
