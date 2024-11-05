package com.zelectec.gestioncentros.dto;

import java.util.List;

public class DashboardDto {
    private long totalOrdenes;
    private long ordenesEnReparacion;
    private long ordenesCompletadas;
    private Double ingresosDelMes;
    private List<IngresoPorMesDto> ingresosPorMes;
    private  List<OrdenDto>  ultimasOrdenes;


    // Getters y Setters
    public long getTotalOrdenes() {
        return totalOrdenes;
    }

    public void setTotalOrdenes(long totalOrdenes) {
        this.totalOrdenes = totalOrdenes;
    }

    public long getOrdenesEnReparacion() {
        return ordenesEnReparacion;
    }

    public void setOrdenesEnReparacion(long ordenesEnReparacion) {
        this.ordenesEnReparacion = ordenesEnReparacion;
    }

    public long getOrdenesCompletadas() {
        return ordenesCompletadas;
    }

    public void setOrdenesCompletadas(long ordenesCompletadas) {
        this.ordenesCompletadas = ordenesCompletadas;
    }

    public Double getIngresosDelMes() {
        return ingresosDelMes;
    }

    public void setIngresosDelMes(Double ingresosDelMes) {
        this.ingresosDelMes = ingresosDelMes;
    }

    public List<IngresoPorMesDto> getIngresosPorMes() {
        return ingresosPorMes;
    }

    public void setIngresosPorMes(List<IngresoPorMesDto> ingresosPorMes) {
        this.ingresosPorMes = ingresosPorMes;
    }

    public List<OrdenDto>  getUltimasOrdenes() {
        return  ultimasOrdenes;
    }

    public void setUltimasOrdenes( List<OrdenDto>  ultimasOrdenes) {
        this.ultimasOrdenes = ultimasOrdenes;
    }
}