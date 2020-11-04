package com.example.api2.service;

import com.example.api2.modelo.Usuario;
import com.example.api2.repository.UsuarioRepository;
import com.example.api2.spec.UsuarioSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(UsuarioSpec usuarioSpec) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioSpec.getNome());
        usuario.setEmail(usuarioSpec.getEmail());
        usuario.setIdade(usuarioSpec.getIdade());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Usuario usuario, Long id) {
        Usuario usuarioParaAtualizar = usuarioRepository.findById(id).get();
        usuarioParaAtualizar.setNome(usuario.getNome());
        usuarioParaAtualizar.setEmail(usuario.getEmail());
        usuarioParaAtualizar.setIdade(usuario.getIdade());
        return usuarioRepository.save(usuarioParaAtualizar);
    }

    public Usuario byId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
