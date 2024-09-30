package com.zelectec.gestioncentros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zelectec.gestioncentros.model.DetalleOrden;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {

}
