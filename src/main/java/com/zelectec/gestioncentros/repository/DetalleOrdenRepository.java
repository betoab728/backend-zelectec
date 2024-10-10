package com.zelectec.gestioncentros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zelectec.gestioncentros.model.DetalleOrden;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
    // Buscar el detalle de la orden por su idOrden
    List<DetalleOrden> findByOrden_IdOrden(Long idOrden);
}
