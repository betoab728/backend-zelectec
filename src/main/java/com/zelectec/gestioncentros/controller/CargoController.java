package com.zelectec.gestioncentros.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zelectec.gestioncentros.model.Cargo;
import com.zelectec.gestioncentros.service.CargoService;

import java.util.List;


@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<Cargo> findAllCargos() {
        return cargoService.findAllCargos();
    }

    @GetMapping("/{id}")
    public Cargo findById(@PathVariable Long id) {
        return cargoService.findById(id);
    }

    @PostMapping
    public Cargo saveCargo(@RequestBody Cargo cargo) {
        return cargoService.saveCargo(cargo);
    }

    @PutMapping("/{id}")
    public Cargo updateCargo(@PathVariable Long id, @RequestBody Cargo cargo) {
        cargo.setId(id); // Asegurar que el ID del Cargo se establece en el objeto
        return cargoService.saveCargo(cargo);
    }


    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
    }


}
