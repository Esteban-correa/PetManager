package dev.ecr.graphqlqbe.Productos;

public class ProductoInput {
    private String nombre;
    private Double precio;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
}
