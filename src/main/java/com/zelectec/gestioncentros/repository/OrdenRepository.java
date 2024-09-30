package com.zelectec.gestioncentros.repository;

import com.zelectec.gestioncentros.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    List<Orden> findByFecha(LocalDate fecha);

}
