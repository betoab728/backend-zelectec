package com.zelectec.gestioncentros.dto;

public class IngresoPorMesDto {
    //mes, año y total
    private int mes;
    private int anio;
    private double total;

    // Constructor sin parámetros
    public IngresoPorMesDto() {
    }

    // Constructor con parámetros
    public IngresoPorMesDto(int mes, int anio, double total) {
        this.mes = mes;
        this.anio = anio;
        this.total = total;
    }

    // Getters y Setters


    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
