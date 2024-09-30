package com.zelectec.gestioncentros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zelectec.gestioncentros.model.Orden;
import com.zelectec.gestioncentros.service.OrdenService;

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

    @PostMapping
    public Orden saveOrden(@RequestBody Orden orden) {
        return ordenService.saveOrden(orden);
    }

    //actualizar
    @PutMapping("/{id}")
    public Orden updateOrden (@PathVariable Long id, @RequestBody Orden orden) {
        orden.setIdOrden(id); // Asegurar que el ID de la Orden se establece en el objeto
        return ordenService.saveOrden(orden);
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
