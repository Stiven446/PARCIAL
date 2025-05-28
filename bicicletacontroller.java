package com.biciapi.bici_api.controller;

import com.biciapi.bici_api.dto.BicicletaDTO;
import com.biciapi.bici_api.model.Bicicleta;
import com.biciapi.bici_api.service.BicicletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
    private final BicicletaService bicicletaService;

    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @PostMapping
    public ResponseEntity<Bicicleta> registrar(@RequestBody BicicletaDTO dto) {
        return ResponseEntity.ok(bicicletaService.registrarBicicleta(dto));
    }

    @GetMapping
    public ResponseEntity<List<Bicicleta>> listar() {
        return ResponseEntity.ok(bicicletaService.listarBicicletas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> obtener(@PathVariable int id) {
        Bicicleta b = bicicletaService.obtenerBicicleta(id);
        return (b != null) ? ResponseEntity.ok(b) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicleta> actualizar(@PathVariable int id, @RequestBody BicicletaDTO dto) {
        Bicicleta b = bicicletaService.actualizarBicicleta(id, dto);
        return (b != null) ? ResponseEntity.ok(b) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return bicicletaService.eliminarBicicleta(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
