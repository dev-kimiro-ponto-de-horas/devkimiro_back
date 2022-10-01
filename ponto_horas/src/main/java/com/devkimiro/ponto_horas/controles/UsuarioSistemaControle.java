package com.devkimiro.ponto_horas.controles;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.servicos.UsuarioSistemaServico;

@RestController
@RequestMapping("/usuario")
public class UsuarioSistemaControle {

    @Autowired
    private UsuarioSistemaServico usuarioSistemaServico;

    @Autowired
    private UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    private final PasswordEncoder encoder;

    public UsuarioSistemaControle(UsuarioSistemaRepositorio usuarioSistemaRepositorio, PasswordEncoder encoder) {
        this.usuarioSistemaRepositorio = usuarioSistemaRepositorio;
        this.encoder = encoder;
    }

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

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String senha) {

        Optional<UsuarioSistema> optUsuario = usuarioSistemaRepositorio.findByLogin(login);

        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        UsuarioSistema usuario = optUsuario.get();
        boolean valid = encoder.matches(senha,usuario.getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);

    }

}
