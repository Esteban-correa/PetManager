package dev.ecr.graphqlqbe.Autentificacion;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autentificacion")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "contrasena_hash")
    private String contrasena;

    private String rol;

    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Constructor vacío
    public Usuario() {}

    // Constructor completo
    public Usuario(String nombreUsuario, String contrasena, String rol, String estado, LocalDateTime fechaCreacion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", rol='" + rol + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}