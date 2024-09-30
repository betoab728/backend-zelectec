package com.zelectec.gestioncentros.service;
import  org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.repository.CargoRepository;
import com.zelectec.gestioncentros.model.Cargo;
import java.util.List;

@Service
public class CargoService {

    private  final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> findAllCargos() {
        return cargoRepository.findAll();
    }

    public Cargo saveCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(Long id) {
        cargoRepository.deleteById(id);
    }

    public Cargo updateCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo findById(Long id) {
        return cargoRepository.findById(id)
                .orElse(null);
    }

}
