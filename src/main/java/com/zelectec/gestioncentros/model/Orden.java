package com.zelectec.gestioncentros.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import  java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;


import java.util.Date;

@Entity
@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador; // Relación con Trabajador

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; // Relación con Cliente

    @Column(name = "fechaEntrega", nullable = false)
    private LocalDate fechaEntrega;

    @Enumerated(EnumType.STRING)  // Indica que almacenaremos el valor del Enum como String en la BD
    private EstadoOrden estadoOrden;

    @Column(name = "estado", nullable = false)
    private String estado; // "efectuado", "anulado", etc.

    //campo sobservaciones de tipo string para almacenar las observaciones de la orden
    @Column(name = "observaciones", nullable = false)
    private String observacion;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    // Constructor sin parámetros
    public Orden() {
    }

    // Constructor con parámetros

    public Orden(LocalDate fecha, LocalTime hora, Trabajador trabajador, Cliente cliente, LocalDate fechaEntrega, EstadoOrden estadoOrden, String estado, String observacion) {
        this.fecha = fecha;
        this.hora = hora;
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.fechaEntrega = fechaEntrega;
        this.estadoOrden = estadoOrden;
        this.estado = estado;
        this.observacion = observacion;
    }

    // Getters y setters


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

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
