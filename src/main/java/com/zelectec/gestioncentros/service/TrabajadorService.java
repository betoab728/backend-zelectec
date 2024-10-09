package com.zelectec.gestioncentros.service;

import org.springframework.stereotype.Service;
import com.zelectec.gestioncentros.repository.TrabajadorRepository;
import com.zelectec.gestioncentros.model.Trabajador;
import java.util.List;
import java.util.Optional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public List<Trabajador> findAllTrabajadores() {
        return trabajadorRepository.findByEstado("a");
    }

    public Trabajador saveTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public void deleteTrabajador(Long id) {
        trabajadorRepository.deleteById(id);
    }

    //eliminacion logica de trabajador
    public void deleteTrabajadorLogico(Long id) {
        Optional<Trabajador> trabajadorOpt = trabajadorRepository.findById(id);
        if (trabajadorOpt.isPresent()) {
            Trabajador trabajador = trabajadorOpt.get();
            trabajador.setEstado("i"); // Cambiar estado a inactivo
            trabajadorRepository.save(trabajador); // Guardar trabajador actualizado
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabajador no encontrado");
        }
    }



    public Optional <Trabajador> findById(Long id) {
        return trabajadorRepository.findById(id);
    }
}
