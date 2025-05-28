package com.biciapi.bici_api.dto;

import java.util.Map;

public class BicicletaDTO {
    private String marca;
    private String modelo;
    private float costo;
    private String tipo;
    private Map<String, String> atributosEspecificos;

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public float getCosto() { return costo; }
    public void setCosto(float costo) { this.costo = costo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Map<String, String> getAtributosEspecificos() { return atributosEspecificos; }
    public void setAtributosEspecificos(Map<String, String> atributosEspecificos) { this.atributosEspecificos = atributosEspecificos; }
}
