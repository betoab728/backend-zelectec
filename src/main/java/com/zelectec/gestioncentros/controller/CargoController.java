package com.zelectec.gestioncentros.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zelectec.gestioncentros.model.Cargo;
import com.zelectec.gestioncentros.service.CargoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;


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

    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
    }

    //para actualizar
    @PostMapping("/{id}")
    public Cargo updateCargo(@PathVariable Long id, @RequestBody Cargo cargo) {
        return cargoService.updateCargo(id, cargo);
    }

}
