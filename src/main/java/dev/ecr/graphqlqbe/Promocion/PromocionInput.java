package dev.ecr.graphqlqbe.Promocion;

public class PromocionInput {
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private Double porcentajeDescuento;
    private Boolean activa;
    private String categoria; // ← NUEVO

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public Boolean getActiva() {
        return activa;
    }

    public String getCategoria() { // ← NUEVO
        return categoria;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public void setCategoria(String categoria) { // ← NUEVO
        this.categoria = categoria;
    }
}
