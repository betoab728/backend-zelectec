package com.zelectec.gestioncentros.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.zelectec.gestioncentros.model.Trabajador;
import com.zelectec.gestioncentros.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> findAllTrabajadores() {
        return trabajadorService.findAllTrabajadores();
    }

    @GetMapping("/{id}")
    public Trabajador findById(@PathVariable Long id) {
        return trabajadorService.findById(id).orElse(null);
    }

    @PostMapping
    public Trabajador saveTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorService.saveTrabajador(trabajador);
    }

    //actualizar
    @PostMapping("/{id}")
    public Trabajador updateTrabajador(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        trabajador.setIdTrabajador(id); // Asegurar que el ID del Trabajador se establece en el objeto
        return trabajadorService.saveTrabajador(trabajador);
    }

    @DeleteMapping("/{id}")
    public void deleteTrabajador(@PathVariable Long id) {
        trabajadorService.deleteTrabajador(id);
    }



}
