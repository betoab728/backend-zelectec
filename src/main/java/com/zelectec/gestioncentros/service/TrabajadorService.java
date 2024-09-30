package com.zelectec.gestioncentros.service;

import org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.repository.TrabajadorRepository;
import com.zelectec.gestioncentros.model.Trabajador;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public List<Trabajador> findAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Trabajador saveTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public void deleteTrabajador(Long id) {
        trabajadorRepository.deleteById(id);
    }

    public Trabajador updateTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Optional <Trabajador> findById(Long id) {
        return trabajadorRepository.findById(id);
    }
}
