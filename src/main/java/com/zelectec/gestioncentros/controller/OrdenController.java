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
import com.zelectec.gestioncentros.dto.OrdenClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.Map;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

   /*  @GetMapping
   public List<Orden> findAllOrdenes() {
        return ordenService.findAllOrdenes();
    }*/
   @GetMapping
    public List<OrdenClienteDTO> getOrdenesWithClienteDetails() {
        return ordenService.getOrdenesWithClienteDetails();
    }

    @GetMapping("/{id}")
    public Orden findById(@PathVariable Long id) {
        return ordenService.findById(id).orElse(null);
    }

    //Guardar una orden con sus detalles
    @PostMapping
    public Orden saveOrden(@RequestBody OrdenConDetallesDTO ordenConDetalles) {
        System.out.println(ordenConDetalles);
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

    //actualizar estado del trabajo de la orden
    @PatchMapping("/{id}/estadoOrden")
    public ResponseEntity<Void> updateEstadoOrden(@PathVariable Long id,  @RequestBody Map<String, String> body) {

        String estadoOrden = body.get("estadoOrden");
        System.out.println(estadoOrden);
        ordenService.updateEstadoOrden(estadoOrden, id);
        return ResponseEntity.noContent().build();
    }

    //actualizar estado de anulacion la orden
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> updateEstado(@PathVariable Long id, @RequestBody String estado) {
        ordenService.updateEstado(estado, id);
        return ResponseEntity.noContent().build();
    }


}
