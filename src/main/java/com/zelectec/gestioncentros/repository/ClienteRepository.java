package com.zelectec.gestioncentros.repository;

import com.zelectec.gestioncentros.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);
    List<Cliente> findByEstado(String estado);

   @Query("SELECT c FROM Cliente c WHERE " +
           "LOWER(c.nombre) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
           "LOWER(c.apellidoPaterno) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
           "LOWER(c.apellidoMaterno) LIKE LOWER(CONCAT('%', :filtro, '%'))")
   Page<Cliente> buscarClientesPorFiltro(@Param("filtro") String filtro, Pageable pageable);

}
