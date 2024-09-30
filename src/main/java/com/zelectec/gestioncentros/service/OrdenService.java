package com.zelectec.gestioncentros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.model.Orden;
import com.zelectec.gestioncentros.repository.OrdenRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    // Obtener todas las ordenes
    public List<Orden> findAllOrdenes() {
        return ordenRepository.findAll();
    }

    // Buscar orden por ID
    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    // Guardar y actualizar orden
    public Orden saveOrden(Orden orden) {
        return ordenRepository.save(orden);
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
