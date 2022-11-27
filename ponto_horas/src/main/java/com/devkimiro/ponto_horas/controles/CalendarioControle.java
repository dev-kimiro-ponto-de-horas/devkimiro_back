package com.devkimiro.ponto_horas.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devkimiro.ponto_horas.entidades.Calendario;
import com.devkimiro.ponto_horas.servicos.CalendarioServico;

@RestController
@RequestMapping("/calendario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalendarioControle {
    
    @Autowired
    private CalendarioServico calendarioServico;

    @GetMapping("{cracha}")
    public ResponseEntity<List<Calendario>> listarTodosCalendariosPorCracha (@PathVariable String cracha){
        List<Calendario> calendario = calendarioServico.buscarTodosCalendariosPorCracha(cracha);
        return ResponseEntity.ok(calendario);
    }

    @GetMapping
    public ResponseEntity<List<Calendario>> listarTodosOsCalendarios (){
        List<Calendario> calendario = calendarioServico.listarTodosCalendarios();
        return ResponseEntity.ok(calendario);
    }
}
