package com.biciapi.bici_api.service;

import com.biciapi.bici_api.dto.AlquilerDTO;
import com.biciapi.bici_api.model.Alquiler;
import org.springframework.stereotype.Service;
import java.util.*;

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
