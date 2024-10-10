package com.zelectec.gestioncentros.service;

import org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.model.DetalleOrden;
import com.zelectec.gestioncentros.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.zelectec.gestioncentros.dto.DetalleOrdenDTO;


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

    // Buscar detalle de orden por idOrden
    public List<DetalleOrdenDTO> findByOrdenId(Long idOrden) {
        List<DetalleOrden> detalles =    detalleOrdenRepository.findByOrden_IdOrden(idOrden);

        // Convertir la lista de DetalleOrden a una lista de DetalleOrdenDTO
        List<DetalleOrdenDTO> detallesDTO = detalles.stream()
                .map(this::convertToDTO) // Convertir cada DetalleOrden a DetalleOrdenDTO
                .collect(Collectors.toList()); // Recoger los resultados en una lista

        return detallesDTO;
    }

    private DetalleOrdenDTO convertToDTO(DetalleOrden detalle) {
        DetalleOrdenDTO dto = new DetalleOrdenDTO();
        dto.setIdDetalleOrden(detalle.getIdDetalleOrden());
        dto.setDescripcion(detalle.getDescripcion());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());
        dto.setCreatedAt(detalle.getCreatedAt());
        dto.setUpdatedAt(detalle.getUpdatedAt());
        return dto;
    }

}
