package com.zelectec.gestioncentros.model;

public enum EstadoOrden {
    I("Ingresado"),
    D("Diagnosticado"),
    R("En reparación"),
    C("reparación completada"),
    E("Entregado");

    private final String descripcion;

    EstadoOrden(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}