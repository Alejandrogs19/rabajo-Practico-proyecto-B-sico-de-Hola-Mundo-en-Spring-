// Archivo: src/main/java/com/example/crudapp/controller/MensajeController.java
package com.example.crudapp.controller;

import com.example.crudapp.model.Mensaje;
import com.example.crudapp.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    @GetMapping
    public List<Mensaje> getAllMensajes() {
        return mensajeService.getAllMensajes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> getMensajeById(@PathVariable Integer id) {
        Optional<Mensaje> mensaje = mensajeService.getMensajeById(id);
        return mensaje.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mensaje> addMensaje(@RequestBody Mensaje mensaje) {
        Mensaje newMensaje = mensajeService.addMensaje(mensaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMensaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> updateMensaje(@PathVariable Integer id, @RequestBody Mensaje updatedMensaje) {
        Mensaje mensaje = mensajeService.updateMensaje(id, updatedMensaje);
        return mensaje != null ? ResponseEntity.ok(mensaje) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMensaje(@PathVariable Integer id) {
        return mensajeService.deleteMensaje(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
