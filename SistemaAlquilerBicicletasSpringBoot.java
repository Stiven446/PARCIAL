/*
 * Proyecto: API REST para sistema de alquiler de bicicletas
 * Framework: Spring Boot
 * Capas: Controller, Service, DTO, Model (Entity)
 */

// ---------------------------------------------
// MODELO (ENTIDADES)
// ---------------------------------------------
package com.biciapi.model;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    // Getters y Setters
}

public class EstadoBicicleta {
    private int idEstado;
    private String nombreEstado;
    // Getters y Setters
}

public class Bicicleta {
    private int idBicicleta;
    private String marca;
    private String modelo;
    private EstadoBicicleta estado;
    private float costo;
    // Getters y Setters
}

public class BicicletaMontaña extends Bicicleta {
    private String tipoSuspension;
    // Getters y Setters
}

public class BicicletaRuta extends Bicicleta {
    private float peso;
    // Getters y Setters
}

public class Alquiler {
    private int idAlquiler;
    private int idCliente;
    private int idBicicleta;
    private Date fechaInicio;
    private Date fechaFin;
    // Getters y Setters
}

// ---------------------------------------------
// DTOs
// ---------------------------------------------
package com.biciapi.dto;

public class ClienteDTO {
    private String nombre;
    private String telefono;
    private String correo;
    // Getters y Setters
}

public class BicicletaDTO {
    private String marca;
    private String modelo;
    private float costo;
    private String tipo;
    private Map<String, String> atributosEspecificos;
    // Getters y Setters
}

public class AlquilerDTO {
    private int idCliente;
    private int idBicicleta;
    private Date fechaInicio;
    private Date fechaFin;
    // Getters y Setters
}

// ---------------------------------------------
// SERVICIOS
// ---------------------------------------------
package com.biciapi.service;

import com.biciapi.dto.*;
import com.biciapi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {
    private Map<Integer, Cliente> clientes = new HashMap<>();
    private int idCounter = 1;

    public Cliente registrarCliente(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setIdCliente(idCounter++);
        c.setNombre(dto.getNombre());
        c.setTelefono(dto.getTelefono());
        c.setCorreo(dto.getCorreo());
        clientes.put(c.getIdCliente(), c);
        return c;
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }

    public Cliente obtenerCliente(int id) {
        return clientes.get(id);
    }

    public Cliente actualizarCliente(int id, ClienteDTO dto) {
        Cliente c = clientes.get(id);
        if (c != null) {
            c.setNombre(dto.getNombre());
            c.setTelefono(dto.getTelefono());
            c.setCorreo(dto.getCorreo());
        }
        return c;
    }

    public boolean eliminarCliente(int id) {
        return clientes.remove(id) != null;
    }
}

@Service
public class BicicletaService {
    private Map<Integer, Bicicleta> bicicletas = new HashMap<>();
    private int idCounter = 1;

    public Bicicleta registrarBicicleta(BicicletaDTO dto) {
        Bicicleta bici = switch (dto.getTipo()) {
            case "montaña" -> {
                BicicletaMontaña bm = new BicicletaMontaña();
                bm.setTipoSuspension(dto.getAtributosEspecificos().get("suspension"));
                yield bm;
            }
            case "ruta" -> {
                BicicletaRuta br = new BicicletaRuta();
                br.setPeso(Float.parseFloat(dto.getAtributosEspecificos().get("peso")));
                yield br;
            }
            default -> new Bicicleta();
        };
        bici.setIdBicicleta(idCounter++);
        bici.setMarca(dto.getMarca());
        bici.setModelo(dto.getModelo());
        bici.setCosto(dto.getCosto());
        bici.setEstado(new EstadoBicicleta());
        bicicletas.put(bici.getIdBicicleta(), bici);
        return bici;
    }

    public List<Bicicleta> listarBicicletas() {
        return new ArrayList<>(bicicletas.values());
    }

    public Bicicleta obtenerBicicleta(int id) {
        return bicicletas.get(id);
    }

    public Bicicleta actualizarBicicleta(int id, BicicletaDTO dto) {
        Bicicleta bici = bicicletas.get(id);
        if (bici != null) {
            bici.setMarca(dto.getMarca());
            bici.setModelo(dto.getModelo());
            bici.setCosto(dto.getCosto());
        }
        return bici;
    }

    public boolean eliminarBicicleta(int id) {
        return bicicletas.remove(id) != null;
    }
}

@Service
public class AlquilerService {
    private Map<Integer, Alquiler> alquileres = new HashMap<>();
    private int idCounter = 1;

    public Alquiler iniciarAlquiler(AlquilerDTO dto) {
        Alquiler a = new Alquiler();
        a.setIdAlquiler(idCounter++);
        a.setIdCliente(dto.getIdCliente());
        a.setIdBicicleta(dto.getIdBicicleta());
        a.setFechaInicio(dto.getFechaInicio());
        a.setFechaFin(dto.getFechaFin());
        alquileres.put(a.getIdAlquiler(), a);
        return a;
    }

    public List<Alquiler> listarAlquileres() {
        return new ArrayList<>(alquileres.values());
    }

    public Alquiler consultarAlquiler(int id) {
        return alquileres.get(id);
    }

    public boolean eliminarAlquiler(int id) {
        return alquileres.remove(id) != null;
    }
}

// ---------------------------------------------
// CONTROLADORES
// ---------------------------------------------
package com.biciapi.controller;

import com.biciapi.dto.*;
import com.biciapi.model.*;
import com.biciapi.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    public ClienteController(ClienteService service) { this.clienteService = service; }

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

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
    private final BicicletaService bicicletaService;
    public BicicletaController(BicicletaService service) { this.bicicletaService = service; }

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

@RestController
@RequestMapping("/alquileres")
public class AlquilerController {
    private final AlquilerService alquilerService;
    public AlquilerController(AlquilerService service) { this.alquilerService = service; }

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
