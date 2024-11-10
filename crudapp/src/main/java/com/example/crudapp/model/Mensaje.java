// Archivo: src/main/java/com/example/crudapp/model/Mensaje.java
package com.example.crudapp.model;

import java.time.LocalDateTime;

public class Mensaje {
    private Integer id;
    private String user;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    public Mensaje(Integer id, String user, String mensaje, LocalDateTime fechaCreacion) {
        this.id = id;
        this.user = user;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    @Override
    public String toString() {
        return "Mensaje [id=" + id + ", user=" + user + ", mensaje=" + mensaje + ", fechaCreacion=" + fechaCreacion + "]";
    }
}
