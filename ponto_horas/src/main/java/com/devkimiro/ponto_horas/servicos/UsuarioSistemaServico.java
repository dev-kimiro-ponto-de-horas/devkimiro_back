package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UsuarioSistemaServico {

    @Autowired
    private UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    private final PasswordEncoder encoder;

    public UsuarioSistemaServico(PasswordEncoder encoder) {
        this.encoder = encoder;
    }


    public List<UsuarioSistema> listarTodosUsuarios (){
        return usuarioSistemaRepositorio.findAll();
    }

    public UsuarioSistema criarUsuario (UsuarioSistema usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
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

    public UsuarioSistema  atualizarUsuario (UsuarioSistema usuario, Long id){
        UsuarioSistema usuarioAntigo = buscarUsuarioPorId(id);
        usuario.setId(usuarioAntigo.getId());
        return criarUsuario(usuario);
    }

    public void deletarUsuario (Long id){
        usuarioSistemaRepositorio.deleteById(id);
    }


}
