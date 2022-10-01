package com.devkimiro.ponto_horas.controles;

import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Listar todos os Usuários")
    @ApiResponse(code = 200, message = "Todos os Usuários listados com sucesso!")
    public ResponseEntity<List<UsuarioSistema>> listarTodosUsuarios (){
        return ResponseEntity.ok(usuarioSistemaServico.listarTodosUsuarios());
    }

    @PostMapping
    @ApiOperation("Criar um Usuário")
    @ApiResponse(code = 200,message = "Usuário criado com Sucesso!")
    public ResponseEntity<UsuarioSistema> criarUsuario (@Valid @RequestBody UsuarioSistema usuario){
        return ResponseEntity.ok(usuarioSistemaServico.criarUsuario(usuario));
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um Usuário por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Usuário não encontrado!")
    })
    public ResponseEntity<UsuarioSistema> buscarUsuarioPorId (@PathVariable Long id){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.buscarUsuarioPorId(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login/{login}")
    @ApiOperation("Buscar Usuário por Login")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Login de Usuário encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Login de Usuário não encontrado!")
    })
    public ResponseEntity<UsuarioSistema> buscarUsuarioPorLogin (@PathVariable String login){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.buscarUsuarioPorLogin(login));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    @ApiOperation("Buscar Usuário por E-mail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "E-mail do Usuário encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "E-mail não encontrado!")
    })
    public ResponseEntity<UsuarioSistema> buscarUsuarioPorEmail (@PathVariable String email){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.buscarUsuarioPorEmail(email));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @ApiOperation("Atualizar Usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso!") ,
            @ApiResponse(code = 404, message = "Usuário não encontrado!")
    })
    public ResponseEntity<UsuarioSistema> atualizarUsuario (@Valid @RequestBody UsuarioSistema usuario, @PathVariable Long id){
        try{
        return ResponseEntity.ok(usuarioSistemaServico.atualizarUsuario(usuario, id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar Usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário deletado com sucesso!") ,
            @ApiResponse(code = 404, message = "Usuário não encontrado!")
    })
    public ResponseEntity<?> deletarUsuario (@PathVariable Long id){
        try{
        usuarioSistemaServico.deletarUsuario(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
