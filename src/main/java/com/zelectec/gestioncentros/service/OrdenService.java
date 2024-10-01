package com.zelectec.gestioncentros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.model.Orden;
import com.zelectec.gestioncentros.repository.OrdenRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import  com.zelectec.gestioncentros.repository.DetalleOrdenRepository;
import org.springframework.transaction.annotation.Transactional;
import com.zelectec.gestioncentros.model.DetalleOrden;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;


    @Autowired
    public OrdenService(OrdenRepository ordenRepository, DetalleOrdenRepository detalleOrdenRepository) {
        this.ordenRepository = ordenRepository;
        this.detalleOrdenRepository = detalleOrdenRepository;

    }

    // Obtener todas las ordenes
    public List<Orden> findAllOrdenes() {
        return ordenRepository.findAll();
    }

    // Buscar orden por ID
    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    // Guardar y actualizar orden con detalle, usando transacción
    @Transactional
    public Orden saveOrden(Orden orden, List<DetalleOrden> detalles) {

        // Guardar la orden
        Orden ordenGuardada = ordenRepository.save(orden); // Esto genera el idOrden
        // Guardar los detalles relacionados con la orden
        for (DetalleOrden detalle : detalles) {
            detalle.setOrden(ordenGuardada);  // Asociar el detalle a la orden
            detalleOrdenRepository.save(detalle);
        }

        return ordenGuardada;
    }

    // Eliminar orden
    public void deleteOrden(Long id) {
        ordenRepository.deleteById(id);
    }

    // Buscar orden por fecha
    public List<Orden> findByFecha(LocalDate fecha) {
        return ordenRepository.findByFecha(fecha);
    }

}
