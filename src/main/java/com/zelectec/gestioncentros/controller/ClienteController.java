package com.zelectec.gestioncentros.controller;
//aca se implementa la clase ClienteController

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.zelectec.gestioncentros.model.Cliente;
import com.zelectec.gestioncentros.service.ClienteService;
 import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAllClientes() {
        return clienteService.findAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteService.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping("/nombre/{nombre}")
    public  List<Cliente> findByNombre(@PathVariable String nombre) {
        return clienteService.findByNombre(nombre);
    }

    //para actualizar cliente
    @PutMapping
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return clienteService.updateCliente(cliente);
    }

}
