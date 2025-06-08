package dev.ecr.graphqlqbe.Promocion;

import dev.ecr.graphqlqbe.Productos.Producto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "promociones")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promocion_id")
    private Integer promocionId;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "porcentaje_descuento", nullable = false, precision = 5)
    private double porcentajeDescuento;

    @Column(nullable = false)
    private Boolean activa = true;

    @Column(length = 100)
    private String categoria;

    // Relación muchos a muchos con productos
    @ManyToMany
    @JoinTable(
            name = "promocion_producto",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    // Constructors

    public Promocion() {}

    public Promocion(String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
                     Double porcentajeDescuento, Boolean activa, String categoria, List<Producto> productos) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.porcentajeDescuento = porcentajeDescuento;
        this.activa = activa;
        this.categoria = categoria;  // ahora sí, correcto
        this.productos = productos;
    }


    // Getters and Setters

    public Integer getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Integer promocionId) {
        this.promocionId = promocionId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
