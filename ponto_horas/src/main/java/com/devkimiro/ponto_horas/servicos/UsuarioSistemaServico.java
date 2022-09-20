package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;

@Service
public class UsuarioSistemaServico {

    @Autowired
    private UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    public List<UsuarioSistema> listarTodosUsuarios (){
        return usuarioSistemaRepositorio.findAll();
    }

    public UsuarioSistema criarUsuario (UsuarioSistema usuario){
        return usuarioSistemaRepositorio.save(usuario);
    }

    public UsuarioSistema buscarUsuario (Long id){
        Optional<UsuarioSistema> usuario = usuarioSistemaRepositorio.findById(id);
        return usuario.get();
    }

    public UsuarioSistema  atualizarUsuario (UsuarioSistema usuario, Long id){
        UsuarioSistema usuarioAntigo = buscarUsuario(id);
        usuario.setId(usuarioAntigo.getId());
        return criarUsuario(usuario);
    }

    public void deletarUsuario (Long id){
        usuarioSistemaRepositorio.deleteById(id);
    }
    
}
