package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.dto.request.UsuarioSistemaRequestDto;
import com.devkimiro.ponto_horas.dto.request.UsuarioSistemaUpdateDto;
import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;

@Service
public class UsuarioSistemaServico {

    @Autowired
    private UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    public List<UsuarioSistema> listarTodosUsuarios (){
        return usuarioSistemaRepositorio.findAll();
    }

    public UsuarioSistema criarUsuario (UsuarioSistemaRequestDto usuarioDto){
        Optional<UsuarioSistema> usuarioCracha = usuarioSistemaRepositorio.findByLogin(usuarioDto.getLogin());
        if(usuarioCracha.isPresent()){
            throw new RuntimeException("Já existe um usuário com o Login: " + usuarioDto.getLogin());
        }
        UsuarioSistema usuario = new UsuarioSistema(null, usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getLogin(), usuarioDto.getSenha());
        return usuarioSistemaRepositorio.save(usuario);
    }

    public UsuarioSistema buscarUsuarioPorId (Long id){
        Optional<UsuarioSistema> usuario = usuarioSistemaRepositorio.findById(id);
        if(usuario.isEmpty()){
            throw new RuntimeException("O usuário não foi encontrado pelo Id!");
        }
        return usuario.get();
    }

    public UsuarioSistema buscarUsuarioPorLogin (String login){
        Optional<UsuarioSistema> usuario = usuarioSistemaRepositorio.findByLogin(login);
        if(usuario.isEmpty()){
            throw new RuntimeException("O usuário não foi encontrado pelo login!");
        }
        return usuario.get();
    }

    public UsuarioSistema buscarUsuarioPorEmail (String email){
        Optional<UsuarioSistema> usuario = usuarioSistemaRepositorio.findByEmail(email);
        if(usuario.isEmpty()){
            throw new RuntimeException("O usuário não foi encontrado pelo e-mail!");
        }
        return usuario.get();
    }

    public UsuarioSistema  atualizarUsuario (UsuarioSistemaUpdateDto usuarioDto, String login){
        UsuarioSistema usuario = buscarUsuarioPorLogin(login);
        usuario.setSenha(usuarioDto.getSenha());
        return usuarioSistemaRepositorio.save(usuario);
    }

    public void deletarUsuario (Long id){
        usuarioSistemaRepositorio.deleteById(id);
    }

    public String loginUsuarioSistema(String login, String senha){
        Optional<UsuarioSistema> usuarioEncontrado = usuarioSistemaRepositorio.findByLogin(login);
        if(usuarioEncontrado.isEmpty())
            throw new RuntimeException("Login não encontrado!");
        UsuarioSistema usuario = usuarioEncontrado.get();
        return usuario.getLogin();
    }
    
}
