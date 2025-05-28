package com.biciapi.bici_api.model;

public class Bicicleta {
    private int idBicicleta;
    private String marca;
    private String modelo;
    private EstadoBicicleta estado;
    private float costo;

    public int getIdBicicleta() { return idBicicleta; }
    public void setIdBicicleta(int idBicicleta) { this.idBicicleta = idBicicleta; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public EstadoBicicleta getEstado() { return estado; }
    public void setEstado(EstadoBicicleta estado) { this.estado = estado; }

    public float getCosto() { return costo; }
    public void setCosto(float costo) { this.costo = costo; }
}
