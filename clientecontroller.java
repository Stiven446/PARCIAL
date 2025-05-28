package com.biciapi.bici_api.controller;

import com.biciapi.bici_api.dto.ClienteDTO;
import com.biciapi.bici_api.model.Cliente;
import com.biciapi.bici_api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> registrar(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.registrarCliente(dto));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable int id) {
        Cliente c = clienteService.obtenerCliente(id);
        return (c != null) ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable int id, @RequestBody ClienteDTO dto) {
        Cliente c = clienteService.actualizarCliente(id, dto);
        return (c != null) ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        return clienteService.eliminarCliente(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
