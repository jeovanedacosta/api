package com.example.api2.controller;

import com.example.api2.modelo.Usuario;
import com.example.api2.service.UsuarioService;
import com.example.api2.spec.UsuarioSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody UsuarioSpec usuarioSpec) {
        Usuario usuario = usuarioService.criar(usuarioSpec);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping(path = "/{id}")
    public Usuario byId(@PathVariable Long id) {
        return usuarioService.byId(id);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = usuarioService.atualizar(usuario, id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}