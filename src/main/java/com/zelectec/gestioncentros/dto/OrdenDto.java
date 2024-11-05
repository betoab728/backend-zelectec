package com.zelectec.gestioncentros.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.zelectec.gestioncentros.model.EstadoOrden;

public class OrdenDto {

    private Long idOrden;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoOrden estadoOrden; // Cambiado a EstadoOrden
    private Double total;

    public OrdenDto(Long idOrden, LocalDate fecha, LocalTime hora, EstadoOrden estadoOrden, Double total) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoOrden = estadoOrden;
        this.total = total;
    }

    // Getters y Setters


    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}