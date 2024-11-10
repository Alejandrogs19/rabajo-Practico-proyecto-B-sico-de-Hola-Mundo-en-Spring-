// Archivo: src/main/java/com/example/crudapp/service/MensajeService.java
package com.example.crudapp.service;

import com.example.crudapp.model.Mensaje;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {
    private List<Mensaje> mensajes = new ArrayList<>();
    private Integer nextId = 1;

    public MensajeService() {
        mensajes.add(new Mensaje(nextId++, "Alejo", "hola", LocalDateTime.now()));
        mensajes.add(new Mensaje(nextId++, "Daniela", "Hola", LocalDateTime.now()));
    }

    public List<Mensaje> getAllMensajes() { return mensajes; }

    public Optional<Mensaje> getMensajeById(Integer id) {
        return mensajes.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public Mensaje addMensaje(Mensaje mensaje) {
        mensaje.setId(nextId++);
        mensaje.setFechaCreacion(LocalDateTime.now());
        mensajes.add(mensaje);
        return mensaje;
    }

    public Mensaje updateMensaje(Integer id, Mensaje updatedMensaje) {
        Optional<Mensaje> optionalMensaje = getMensajeById(id);
        if (optionalMensaje.isPresent()) {
            Mensaje mensaje = optionalMensaje.get();
            mensaje.setUser(updatedMensaje.getUser());
            mensaje.setMensaje(updatedMensaje.getMensaje());
            return mensaje;
        }
        return null;
    }

    public boolean deleteMensaje(Integer id) {
        return mensajes.removeIf(m -> m.getId().equals(id));
    }
}
