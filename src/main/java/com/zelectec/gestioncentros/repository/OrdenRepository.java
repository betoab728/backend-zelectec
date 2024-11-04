package com.zelectec.gestioncentros.repository;

import com.zelectec.gestioncentros.model.EstadoOrden;
import com.zelectec.gestioncentros.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zelectec.gestioncentros.dto.OrdenClienteDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import com.zelectec.gestioncentros.dto.IngresoPorMesDto;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    List<Orden> findByFecha(LocalDate fecha);
    List<Orden> findByEstado(String estado);

    @Query("SELECT new com.zelectec.gestioncentros.dto.OrdenClienteDTO(o.idOrden, o.fecha, o.hora, CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno), o.estadoOrden) " +
            "FROM Orden o " +
            "JOIN o.cliente c where o.estado = 'a'")
    List<OrdenClienteDTO> fetchOrdenesWithClienteDetails();

    @Transactional
    @Modifying
    @Query("UPDATE Orden o SET o.estadoOrden = ?1 WHERE o.idOrden = ?2")
    void updateEstadoOrden(EstadoOrden estadoOrden, Long idOrden);

    @Transactional
    @Modifying
    @Query("UPDATE Orden o SET o.estado = ?1 WHERE o.idOrden = ?2")
    void updateEstado(String estado, Long idOrden);
    //consultas para el dashboard
    //Total de órdenes:
    @Query("SELECT COUNT(o) FROM Orden o")
    long countTotalOrdenes();

    //Órdenes en reparación:
    @Query("SELECT COUNT(o) FROM Orden o WHERE o.estado = 'R'")
    long countOrdenesEnReparacion();

    //Órdenes completadas:
    @Query("SELECT COUNT(o) FROM Orden o WHERE o.estado = 'C'")
    long countOrdenesCompletadas();

    //Ingresos del mes:
    @Query("SELECT SUM(o.total) FROM Orden o WHERE AND MONTH(o.fechaEntrega) = MONTH(CURRENT_DATE) AND YEAR(o.fechaEntrega) = YEAR(CURRENT_DATE)")
    Double ingresosDelMes();

    //Gráfico de Ingresos por Mes
    @Query("SELECT new com.zelectec.gestioncentros.dto.IngresoPorMesDto(MONTH(o.fechaEntrega), YEAR(o.fechaEntrega), SUM(o.total)) " +
            "FROM Orden o WHERE o.estado = 'completada' " +
            "GROUP BY YEAR(o.fechaEntrega), MONTH(o.fechaEntrega) " +
            "ORDER BY YEAR(o.fechaEntrega), MONTH(o.fechaEntrega)")
    List<IngresoPorMesDto> ingresosPorMes();


}
