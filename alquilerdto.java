package com.biciapi.bici_api.dto;

import java.util.Date;

public class AlquilerDTO {
    private int idCliente;
    private int idBicicleta;
    private Date fechaInicio;
    private Date fechaFin;

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdBicicleta() { return idBicicleta; }
    public void setIdBicicleta(int idBicicleta) { this.idBicicleta = idBicicleta; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
}
