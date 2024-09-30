package com.zelectec.gestioncentros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zelectec.gestioncentros.model.DetalleOrden;
import com.zelectec.gestioncentros.service.DetalleOrdenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    @GetMapping
    public List<DetalleOrden> findAllDetallesOrden() {
        return detalleOrdenService.findAllDetallesOrden();
    }

    @GetMapping("/{id}")
    public DetalleOrden findById(@PathVariable Long id) {
        return detalleOrdenService.findById(id).orElse(null);
    }

    @PostMapping
    public DetalleOrden saveDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        return detalleOrdenService.saveDetalleOrden(detalleOrden);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleOrden(@PathVariable Long id) {
        detalleOrdenService.deleteDetalleOrden(id);
    }

    @PutMapping("/{id}")
    public DetalleOrden updateDetalleOrden(@PathVariable Long id,@RequestBody DetalleOrden detalleOrden) {
        detalleOrden.setIdDetalleOrden(id);
        return detalleOrdenService.saveDetalleOrden(detalleOrden);
    }
}
