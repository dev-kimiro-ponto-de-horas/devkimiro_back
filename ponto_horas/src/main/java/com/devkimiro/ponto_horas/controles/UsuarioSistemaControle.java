package com.devkimiro.ponto_horas.controles;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devkimiro.ponto_horas.dto.request.UsuarioSistemaRequestDto;
import com.devkimiro.ponto_horas.dto.request.UsuarioSistemaUpdateDto;
import com.devkimiro.ponto_horas.dto.response.UsuarioSistemaResponseDto;
import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.mapeamento.MapeamentoUsuarioSistema;
import com.devkimiro.ponto_horas.servicos.UsuarioSistemaServico;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioSistemaControle {

    @Autowired
    private UsuarioSistemaServico usuarioSistemaServico;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioSistemaResponseDto>> listarTodosUsuarios() {
        List<UsuarioSistema> usuarioLista = usuarioSistemaServico.listarTodosUsuarios();
        List<UsuarioSistemaResponseDto> lista = new ArrayList<>();
        for (UsuarioSistema usuario : usuarioLista) {
            UsuarioSistemaResponseDto map = mapper.map(usuario, UsuarioSistemaResponseDto.class);
            lista.add(map);
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<UsuarioSistemaResponseDto> criarUsuario(
            @Valid @RequestBody UsuarioSistemaRequestDto usuarioDto) {
        try {
            UsuarioSistema usuarioCriado = usuarioSistemaServico.criarUsuario(usuarioDto);
            return ResponseEntity.ok(MapeamentoUsuarioSistema.deUsuarioParaResponse(usuarioCriado));
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioSistemaResponseDto> buscarUsuarioPorId(@PathVariable Long id) {
        try {
            UsuarioSistema usuarioEncontrado = usuarioSistemaServico.buscarUsuarioPorId(id);
            return ResponseEntity.ok(MapeamentoUsuarioSistema.deUsuarioParaResponse(usuarioEncontrado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UsuarioSistemaResponseDto> buscarUsuarioPorLogin(@PathVariable String login) {
        try {
            UsuarioSistema usuarioEncontrado = usuarioSistemaServico.buscarUsuarioPorLogin(login);
            return ResponseEntity.ok(MapeamentoUsuarioSistema.deUsuarioParaResponse(usuarioEncontrado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioSistemaResponseDto> buscarUsuarioPorEmail(@PathVariable String email) {
        try {
            UsuarioSistema usuarioEncontrado = usuarioSistemaServico.buscarUsuarioPorEmail(email);
            return ResponseEntity.ok(MapeamentoUsuarioSistema.deUsuarioParaResponse(usuarioEncontrado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{login}")
    public ResponseEntity<UsuarioSistemaResponseDto> atualizarUsuario(
            @Valid @RequestBody UsuarioSistemaUpdateDto usuarioDto, @PathVariable String login) {
        try {
            UsuarioSistema usuarioAtualizado = usuarioSistemaServico.atualizarUsuario(usuarioDto, login);
            return ResponseEntity.ok(MapeamentoUsuarioSistema.deUsuarioParaResponse(usuarioAtualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioSistemaServico.deletarUsuario(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login/{login}/{senha}")
    public ResponseEntity<String> logarUsuario (@PathVariable String login, String senha){
        String usuario = usuarioSistemaServico.loginUsuarioSistema(login, senha);
        return ResponseEntity.ok(usuario);
    }
}
