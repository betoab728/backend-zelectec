package com.zelectec.gestioncentros.service;

import com.zelectec.gestioncentros.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.zelectec.gestioncentros.model.Cliente;
import java.util.List;
import java.util.Optional;
import  org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> findAllClientes() {
        return clienteRepository.findByEstado("a");
    }

    // Buscar cliente por ID
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    // Guardar  y actualizar  cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    //eliminacion logica de cliente

    // Eliminar cliente (lógica)
    public void deleteClienteLogico(Long id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setEstado("i"); // Cambiar estado a inactivo
            clienteRepository.save(cliente); // Guardar cliente actualizado
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
    }

    // Buscar cliente por nombre
    public List<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }


}
