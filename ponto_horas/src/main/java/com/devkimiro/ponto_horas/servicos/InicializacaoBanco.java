package com.devkimiro.ponto_horas.servicos;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Calendario;
import com.devkimiro.ponto_horas.entidades.Cargo;
import com.devkimiro.ponto_horas.entidades.Setor;
import com.devkimiro.ponto_horas.repositorios.CalendarioRepositorio;
import com.devkimiro.ponto_horas.repositorios.CargoRepositorio;
import com.devkimiro.ponto_horas.repositorios.FuncionarioRepositorio;
import com.devkimiro.ponto_horas.repositorios.SetorRepositorio;
import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;

@Service
public class InicializacaoBanco {
    
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    private UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    @Autowired
    private CargoRepositorio cargoRepositorio;

    @Autowired
    private SetorRepositorio setorRepositorio;

    @Autowired
    private CalendarioRepositorio calendarioRepositorio;

    public void inicializador(){

    }

    public void inicializaEntidades(){

        Cargo cargo1 = new Cargo(1L, "Analista Junior", 1500, LocalTime.of(8, 0, 0));

        Cargo cargo2 = new Cargo(2L, "RH Administrativo", 1000, LocalTime.of(8, 0, 0));

        Cargo cargo3 = new Cargo(3L, "Técnico em Manutenção", 1600, LocalTime.of(8, 0, 0));

        Cargo cargo4 = new Cargo(4L, "Analista Senior", 5000, LocalTime.of(8, 0, 0));

        Cargo cargo5 = new Cargo(5L, "Engenheiro Civil", 3500, LocalTime.of(8, 0, 0));

        Cargo cargo6 = new Cargo(6L, "Operador de Máquina", 2600, LocalTime.of(8, 0, 0));

        Cargo cargo7 = new Cargo(6L, "Aprendiz", 1000, LocalTime.of(6, 0, 0));

        cargoRepositorio.save(cargo1);
        cargoRepositorio.save(cargo2);
        cargoRepositorio.save(cargo3);
        cargoRepositorio.save(cargo4);
        cargoRepositorio.save(cargo5);
        cargoRepositorio.save(cargo6);
        cargoRepositorio.save(cargo7);

        Setor setor1 = new Setor(1L, "TI", "Thiago Chefe");

        Setor setor2 = new Setor(2L, "Manutenção", "Pedro Chefe");

        Setor setor3 = new Setor(3L, "Engenharia", "Vitor Chefe");

        Setor setor4 = new Setor(4L, "RH", "Jose Aldo");

        Setor setor5 = new Setor(5L, "Producação", "Alfredo Neves");

        setorRepositorio.save(setor1);
        setorRepositorio.save(setor2);
        setorRepositorio.save(setor3);
        setorRepositorio.save(setor4);
        setorRepositorio.save(setor5);

        Calendario calendario1 = new Calendario(1L, LocalDateTime.of(2022, 10, 12, 7, 0, 0), LocalDateTime.of(2022, 10, 12, 15, 0, 0), "111111");

        Calendario calendario2 = new Calendario(2L, LocalDateTime.of(2022, 10, 12, 8, 0, 0), LocalDateTime.of(2022, 10, 12, 16, 0, 0), "222222");

        Calendario calendario3 = new Calendario(1L, LocalDateTime.of(2022, 10, 12, 9, 0, 0), LocalDateTime.of(2022, 10, 12, 16, 0, 0), "333333");

        Calendario calendario4 = new Calendario(1L, LocalDateTime.of(2022, 10, 12, 7, 0, 0), LocalDateTime.of(2022, 10, 12, 15, 0, 0), "444444");

        calendarioRepositorio.save(calendario1);
        calendarioRepositorio.save(calendario2);
        calendarioRepositorio.save(calendario3);
        calendarioRepositorio.save(calendario4);
    }
}
