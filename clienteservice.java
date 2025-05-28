package com.biciapi.bici_api.service;

import com.biciapi.bici_api.dto.ClienteDTO;
import com.biciapi.bici_api.model.Cliente;
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
