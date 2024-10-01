package com.zelectec.gestioncentros.dto;
import com.zelectec.gestioncentros.model.DetalleOrden;
import com.zelectec.gestioncentros.model.Orden;
import java.util.List;

public class OrdenConDetallesDTO {

    private Orden orden;
    private List<DetalleOrden> detalles;

    // Constructor sin parámetros
    public OrdenConDetallesDTO() {
    }

    // Constructor con parámetros
    public OrdenConDetallesDTO(Orden orden, List<DetalleOrden> detalles) {
        this.orden = orden;
        this.detalles = detalles;
    }

    // Getters y Setters


    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public List<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrden> detalles) {
        this.detalles = detalles;
    }
}
