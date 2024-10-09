package com.zelectec.gestioncentros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.zelectec.gestioncentros.model.Usuario;
import com.zelectec.gestioncentros.service.UsuarioService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
//importar usuarioservice
import com.zelectec.gestioncentros.service.UsuarioService;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return usuarioService.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    //actualizar
    @PutMapping("/{id}")
    public Usuario updateUsuario (@PathVariable Integer id, @RequestBody Usuario usuario) {
        // Buscar el usuario por id
        Optional<Usuario> usuarioExistenteOpt = usuarioService.findById(id);

        // Verificar si el usuario existe
        if (!usuarioExistenteOpt.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        Usuario usuarioExistente = usuarioExistenteOpt.get();

        // Actualizar solo los campos proporcionados
        if (usuario.getNombre() != null) {
            usuarioExistente.setNombre(usuario.getNombre());
        }
        if (usuario.getEstado() != null) {
            usuarioExistente.setEstado(usuario.getEstado());
        }


        // Guardar el usuario actualizado
        return usuarioService.saveUsuario(usuarioExistente);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
    }
}
