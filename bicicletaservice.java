package com.biciapi.bici_api.service;

import com.biciapi.bici_api.dto.BicicletaDTO;
import com.biciapi.bici_api.model.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BicicletaService {
    private Map<Integer, Bicicleta> bicicletas = new HashMap<>();
    private int idCounter = 1;

    public Bicicleta registrarBicicleta(BicicletaDTO dto) {
        Bicicleta bici;
        switch (dto.getTipo()) {
            case "montaña" -> {
                BicicletaMontana bm = new BicicletaMontana();
                bm.setTipoSuspension(dto.getAtributosEspecificos().get("suspension"));
                bici = bm;
            }
            case "ruta" -> {
                BicicletaRuta br = new BicicletaRuta();
                br.setPeso(Float.parseFloat(dto.getAtributosEspecificos().get("peso")));
                bici = br;
            }
            default -> bici = new Bicicleta();
        }
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
