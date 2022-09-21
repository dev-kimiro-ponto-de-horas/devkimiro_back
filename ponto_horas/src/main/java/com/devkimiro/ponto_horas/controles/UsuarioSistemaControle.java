package com.devkimiro.ponto_horas.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.servicos.UsuarioSistemaServico;

@RestController
@RequestMapping("/usuario")
public class UsuarioSistemaControle {

    @Autowired
    private UsuarioSistemaServico usuarioSistemaServico;

    @GetMapping
    public ResponseEntity<List<UsuarioSistema>> listarTodosUsuarios (){
        return ResponseEntity.ok(usuarioSistemaServico.listarTodosUsuarios());
    }

    @PostMapping
    public ResponseEntity<UsuarioSistema> criarUsuario (@Valid @RequestBody UsuarioSistema usuario){
        return ResponseEntity.ok(usuarioSistemaServico.criarUsuario(usuario));
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioSistema> buscarUsuarioPorId (@PathVariable Long id){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.buscarUsuarioPorId(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UsuarioSistema> buscarUsuarioPorLogin (@PathVariable String login){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.buscarUsuarioPorLogin(login));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioSistema> buscarUsuarioPorEmail (@PathVariable String email){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.buscarUsuarioPorEmail(email));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioSistema> atualizarUsuario (@Valid @RequestBody UsuarioSistema usuario, @PathVariable Long id){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.atualizarUsuario(usuario, id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarUsuario (@PathVariable Long id){
        try{
        usuarioSistemaServico.deletarUsuario(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
