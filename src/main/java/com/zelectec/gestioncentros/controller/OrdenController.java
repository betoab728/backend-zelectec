package com.zelectec.gestioncentros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.zelectec.gestioncentros.model.Orden;
import com.zelectec.gestioncentros.service.OrdenService;
import com.zelectec.gestioncentros.dto.OrdenConDetallesDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> findAllOrdenes() {
        return ordenService.findAllOrdenes();
    }

    @GetMapping("/{id}")
    public Orden findById(@PathVariable Long id) {
        return ordenService.findById(id).orElse(null);
    }

    //Guardar una orden con sus detalles
    @PostMapping
    public Orden saveOrden(@RequestBody OrdenConDetallesDTO ordenConDetalles) {
        return ordenService.saveOrden(ordenConDetalles.getOrden(), ordenConDetalles.getDetalles());
    }

    //actualizar  una orden con sus detalles
    @PutMapping("/{id}")
    public Orden updateOrden (@PathVariable Long id, @RequestBody OrdenConDetallesDTO ordenConDetalles) {
        Orden orden = ordenConDetalles.getOrden();
        orden.setIdOrden(id); // Asegurar que el ID de la Orden se establece en el objeto
        return ordenService.saveOrden(orden, ordenConDetalles.getDetalles());
    }

    @DeleteMapping("/{id}")
    public void deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Orden> findByFecha(@PathVariable LocalDate fecha) {
        return ordenService.findByFecha(fecha);
    }


}
