package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Calendario;
import com.devkimiro.ponto_horas.repositorios.CalendarioRepositorio;

@Service
public class CalendarioServico {

    @Autowired
    private CalendarioRepositorio calendarioRepositorio;

    public List<Calendario> listarTodosCalendarios() {
        return calendarioRepositorio.findAll();
    }

    public Calendario criarCalendario(Calendario calendario) {
        return calendarioRepositorio.save(calendario);
    }

    public Calendario buscarCalendario(Long id) {
        Optional<Calendario> calendario = calendarioRepositorio.findById(id);
        if(calendario.isEmpty()){
            throw new RuntimeException("Calendário não encontrado!");
        }
        return calendario.get();
    }

    public Calendario buscarCalendarioPorCracha (String cracha){
        List<Calendario> calendarioLista = calendarioRepositorio.findByCracha(cracha);
        if(calendarioLista.isEmpty()){
            throw new RuntimeException("Não foi possível encontrar este crachá no calendário!");
        }
        int ultimoElemento = calendarioLista.size() -1;
        Calendario calendario = calendarioLista.get(ultimoElemento);
        return calendario;
    }

    public Calendario atualizarCalendario(Calendario calendario, Long id) {
        Calendario calendarioAntigo = buscarCalendario(id);
        calendario.setId(calendarioAntigo.getId());
        return calendarioRepositorio.save(calendario);
    }

    public void deletarCalendario(Long id) {
        calendarioRepositorio.deleteById(id);
    }
}
