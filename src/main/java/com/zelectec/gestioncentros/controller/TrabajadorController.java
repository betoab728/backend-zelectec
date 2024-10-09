package com.zelectec.gestioncentros.controller;

import org.springframework.web.bind.annotation.*;

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
        //log para mostrar datos recibidos desde el frontend
        System.out.println(trabajador);
        return trabajadorService.saveTrabajador(trabajador);
    }

    //actualizar
    @PutMapping("/{id}")
    public Trabajador updateTrabajador(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        trabajador.setIdTrabajador(id); // Asegurar que el ID del Trabajador se establece en el objeto
        return trabajadorService.saveTrabajador(trabajador);
    }

    @DeleteMapping("/{id}")
    public void deleteTrabajador(@PathVariable Long id) {
        trabajadorService.deleteTrabajadorLogico(id);
    }



}
