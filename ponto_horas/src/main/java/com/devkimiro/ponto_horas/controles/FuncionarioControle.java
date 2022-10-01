package com.devkimiro.ponto_horas.controles;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
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

import com.devkimiro.ponto_horas.dto.request.FuncionarioRequestDto;
import com.devkimiro.ponto_horas.dto.request.FuncionarioRequestUpdateDto;
import com.devkimiro.ponto_horas.dto.response.FuncionarioResponseDto;
import com.devkimiro.ponto_horas.entidades.Funcionario;
import com.devkimiro.ponto_horas.mapeamento.MapeamentoFuncionario;
import com.devkimiro.ponto_horas.servicos.FuncionarioServico;

@RestController
@RequestMapping("/funcionario")
@Api("Controle de Funcionário")
public class FuncionarioControle {
    
    @Autowired
    private FuncionarioServico funcionarioServico;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ApiOperation("Listar todos os Funcionários")
    @ApiResponse(code = 200, message = "Todos os funcionários listados com sucesso!")
    public ResponseEntity<List<FuncionarioResponseDto>> listarTodosFuncionarios (){
        List<Funcionario> funcionarioLista = funcionarioServico.listarTodosFuncionarios();
        List<FuncionarioResponseDto> lista = new ArrayList<>();
        for(Funcionario funcionario : funcionarioLista ){
            FuncionarioResponseDto map = mapper.map(funcionario, FuncionarioResponseDto.class);
            lista.add(map);
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ApiOperation("Criar um Funcionário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Funcionário criado com sucesso!") ,
            @ApiResponse(code = 204, message = "Funcionário sem conteúdo!")
    })
    public ResponseEntity<FuncionarioResponseDto> criarFuncionario (@Valid @RequestBody FuncionarioRequestDto funcionarioDto){
        try{
        Funcionario funcionarioCriado = funcionarioServico.criarFuncionario(funcionarioDto);
        return ResponseEntity.ok(MapeamentoFuncionario.deFuncionarioParaResponse(funcionarioCriado));
        }catch(RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um Funcionário por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Funcionário encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Funcionário não encontrado!")
    })
    public ResponseEntity<FuncionarioResponseDto> buscarFuncionarioPorId (@PathVariable Long id){
        try{
        Funcionario funcionarioEncontrado = funcionarioServico.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(MapeamentoFuncionario.deFuncionarioParaResponse(funcionarioEncontrado));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cracha/{cracha}")
    @ApiOperation("Buscar um Funcionário por Crachá")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Crachá do Funcionário encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Crachá não encontrado!")
    })
    public ResponseEntity<FuncionarioResponseDto> buscarFuncionarioPorCracha (@PathVariable String cracha){
        try{
            Funcionario funcionarioEncontrado = funcionarioServico.buscarFuncionarioPorCracha(cracha);
            return ResponseEntity.ok(MapeamentoFuncionario.deFuncionarioParaResponse(funcionarioEncontrado));
            }catch(RuntimeException e){
                return ResponseEntity.notFound().build();
            }
    }

    @GetMapping("/email/{email}")
    @ApiOperation("Buscar um Funcionário por E-mail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "E-mail do Funcionário encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "E-mail não encontrado!")
    })
    public ResponseEntity<FuncionarioResponseDto> buscarFuncionarioPorEmail (@PathVariable String email){
        try{
            Funcionario funcionarioEncontrado = funcionarioServico.buscarFuncionarioPorEmail(email);
            return ResponseEntity.ok(MapeamentoFuncionario.deFuncionarioParaResponse(funcionarioEncontrado));
            }catch(RuntimeException e){
                return ResponseEntity.notFound().build();
            }
    }

    @PutMapping("{cracha}")
    @ApiOperation("Atualizar um Funcionário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Funcionário atualizado com sucesso!") ,
            @ApiResponse(code = 404, message = "Funcionário não encontrado!")
    })
    public ResponseEntity<FuncionarioResponseDto> atualizarFuncionario (@Valid @RequestBody FuncionarioRequestUpdateDto funcionario, @PathVariable String cracha){
        try{
        Funcionario funcionarioAtualizado = funcionarioServico.atualizarFuncionario(funcionario, cracha);
        return ResponseEntity.ok(MapeamentoFuncionario.deFuncionarioParaResponse(funcionarioAtualizado));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/admin/{cracha}")
    @ApiOperation("Atualizar um Funcionário Administrador")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Administrador atualizado com sucesso!") ,
            @ApiResponse(code = 404, message = "Administrador não encontrado!")
    })
    public ResponseEntity<FuncionarioResponseDto> atualizarFuncionarioAdmin (@Valid FuncionarioRequestDto funcionario,@PathVariable String cracha){
        try{
            Funcionario funcionarioAtualizado = funcionarioServico.atualizarFuncionarioAdmin(funcionario, cracha);
            return ResponseEntity.ok(MapeamentoFuncionario.deFuncionarioParaResponse(funcionarioAtualizado));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar um Funcionário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Funcionário deletado com sucesso!") ,
            @ApiResponse(code = 404, message = "Funcionário não encontrado!")
    })
    public ResponseEntity<?> deletarFuncionario (@PathVariable Long id){
        try{
        funcionarioServico.deletarFuncionario(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
