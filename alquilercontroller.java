package com.biciapi.bici_api.controller;

import com.biciapi.bici_api.dto.AlquilerDTO;
import com.biciapi.bici_api.model.Alquiler;
import com.biciapi.bici_api.service.AlquilerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alquileres")
public class AlquilerController {
    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @PostMapping
    public ResponseEntity<Alquiler> iniciar(@RequestBody AlquilerDTO dto) {
        return ResponseEntity.ok(alquilerService.iniciarAlquiler(dto));
    }

    @GetMapping
    public ResponseEntity<List<Alquiler>> listar() {
        return ResponseEntity.ok(alquilerService.listarAlquileres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alquiler> obtener(@PathVariable int id) {
        Alquiler a = alquilerService.consultarAlquiler(id);
        return (a != null) ? ResponseEntity.ok(a) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return alquilerService.eliminarAlquiler(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
