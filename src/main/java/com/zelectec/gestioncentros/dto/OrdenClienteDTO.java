package com.zelectec.gestioncentros.dto;

import com.zelectec.gestioncentros.model.EstadoOrden;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenClienteDTO {
    private Long idOrden;
    private LocalDate fecha;
    private LocalTime hora;
    private String nombreCompletoCliente;
    private EstadoOrden estadoOrden;

    public OrdenClienteDTO(Long idOrden, LocalDate fecha, LocalTime hora, String nombreCompletoCliente, EstadoOrden estadoOrden) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreCompletoCliente = nombreCompletoCliente;
        this.estadoOrden = estadoOrden;
    }

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

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
}
