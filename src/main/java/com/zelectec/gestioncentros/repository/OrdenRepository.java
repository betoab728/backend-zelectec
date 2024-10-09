package com.zelectec.gestioncentros.repository;

import com.zelectec.gestioncentros.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zelectec.gestioncentros.dto.OrdenClienteDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    List<Orden> findByFecha(LocalDate fecha);

    @Query("SELECT new com.zelectec.gestioncentros.dto.OrdenClienteDTO(o.idOrden, o.fecha, o.hora, CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno), o.estadoOrden) " +
            "FROM Orden o " +
            "JOIN o.cliente c")
    List<OrdenClienteDTO> fetchOrdenesWithClienteDetails();

    @Transactional
    @Modifying
    @Query("UPDATE Orden o SET o.estadoOrden = ?1 WHERE o.idOrden = ?2")
    void updateEstadoOrden(String estadoOrden, Long idOrden);

    @Transactional
    @Modifying
    @Query("UPDATE Orden o SET o.estado = ?1 WHERE o.idOrden = ?2")
    void updateEstado(String estado, Long idOrden);

}
