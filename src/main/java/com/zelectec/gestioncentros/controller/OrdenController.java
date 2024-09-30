package com.zelectec.gestioncentros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zelectec.gestioncentros.model.Orden;
import com.zelectec.gestioncentros.service.OrdenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @DeleteMapping("/{id}")
    public void deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Orden> findByFecha(@PathVariable LocalDate fecha) {
        return ordenService.findByFecha(fecha);
    }


}
