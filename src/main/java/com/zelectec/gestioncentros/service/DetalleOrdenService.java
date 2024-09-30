package com.zelectec.gestioncentros.service;

import org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.model.DetalleOrden;
import com.zelectec.gestioncentros.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    public DetalleOrdenService(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    // Obtener todos los detalles de orden
    public List<DetalleOrden> findAllDetallesOrden() {
        return detalleOrdenRepository.findAll();
    }

    // Buscar detalle de orden por ID
    public Optional<DetalleOrden> findById(Long id) {
        return detalleOrdenRepository.findById(id);
    }

    // Guardar y actuaizar detalle de orden
    public DetalleOrden saveDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    // Eliminar detalle de orden
    public void deleteDetalleOrden(Long id) {
        detalleOrdenRepository.deleteById(id);
    }



}
