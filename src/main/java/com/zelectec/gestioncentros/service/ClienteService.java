package com.zelectec.gestioncentros.service;

import com.zelectec.gestioncentros.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.zelectec.gestioncentros.model.Cliente;
import java.util.List;
import java.util.Optional;
import  org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    // Guardar cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Buscar cliente por nombre
    public List<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    //actualizar cliente
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
