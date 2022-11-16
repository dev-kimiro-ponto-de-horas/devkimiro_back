package com.devkimiro.ponto_horas.servicos;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Calendario;
import com.devkimiro.ponto_horas.entidades.Cargo;
import com.devkimiro.ponto_horas.entidades.Funcionario;
import com.devkimiro.ponto_horas.entidades.Setor;
import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.repositorios.CalendarioRepositorio;
import com.devkimiro.ponto_horas.repositorios.CargoRepositorio;
import com.devkimiro.ponto_horas.repositorios.FuncionarioRepositorio;
import com.devkimiro.ponto_horas.repositorios.SetorRepositorio;
import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;

@Service
public class InicializacaoBanco implements CommandLineRunner {
    
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

    @Override
    public void run(String... args) throws Exception {
        inicializaCargos();
        inicializaSetores();
        inicializaFuncionariosECalendarios();
        inicializaUsuarioSistema();
    }

    private void inicializaCargos(){

        Cargo cargo1 = new Cargo(1L, "Analista Junior", 1500, Time.valueOf("8:00:00"));

        Cargo cargo2 = new Cargo(2L, "RH Administrativo", 1000, Time.valueOf("8:00:00"));

        Cargo cargo3 = new Cargo(3L, "Técnico em Manutenção", 1600, Time.valueOf("8:00:00"));

        Cargo cargo4 = new Cargo(4L, "Analista Senior", 5000, Time.valueOf("8:00:00"));

        Cargo cargo5 = new Cargo(5L, "Engenheiro Civil", 3500, Time.valueOf("8:00:00"));

        Cargo cargo6 = new Cargo(6L, "Operador de Máquina", 2600, Time.valueOf("8:00:00"));

        Cargo cargo7 = new Cargo(7L, "Aprendiz", 1000, Time.valueOf("8:00:00"));

        cargoRepositorio.save(cargo1);
        cargoRepositorio.save(cargo2);
        cargoRepositorio.save(cargo3);
        cargoRepositorio.save(cargo4);
        cargoRepositorio.save(cargo5);
        cargoRepositorio.save(cargo6);
        cargoRepositorio.save(cargo7);
    }

    private void inicializaSetores(){

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
    }

    private void inicializaFuncionariosECalendarios(){

        Calendario calendario1 = new Calendario(1L, LocalDateTime.of(2022, 10, 12, 7, 0, 0), LocalDateTime.of(2022, 10, 12, 15, 0, 0), "111111");

        Calendario calendario2 = new Calendario(2L, LocalDateTime.of(2022, 10, 12, 8, 0, 0), LocalDateTime.of(2022, 10, 12, 16, 0, 0), "222222");

        Calendario calendario3 = new Calendario(3L, LocalDateTime.of(2022, 10, 12, 9, 0, 0), LocalDateTime.of(2022, 10, 12, 16, 0, 0), "333333");

        Calendario calendario4 = new Calendario(4L, LocalDateTime.of(2022, 10, 12, 7, 0, 0), LocalDateTime.of(2022, 10, 12, 15, 0, 0), "111111");

        calendarioRepositorio.save(calendario1);
        calendarioRepositorio.save(calendario2);
        calendarioRepositorio.save(calendario3);
        calendarioRepositorio.save(calendario4);

        List<Calendario> lista1 = new ArrayList<>();
        lista1.add(calendario1);
        lista1.add(calendario4);

        Funcionario funcionario1 = new Funcionario(1L, "Thiago Funcionário", "thiago.funcionario@hotmail.com", cargoRepositorio.findById(4L).get(), setorRepositorio.findById(1L).get(), "111111", "123", lista1);

        List<Calendario> lista2 = new ArrayList<>();
        lista2.add(calendario2);
        
        Funcionario funcionario2 = new Funcionario(2L, "Vitor Funcionário", "vitor.funcionario@hotmail.com", cargoRepositorio.findById(3L).get(), setorRepositorio.findById(2L).get(), "222222", "321", lista2);

        List<Calendario> lista3 = new ArrayList<>();
        lista3.add(calendario3);
        
        Funcionario funcionario3 = new Funcionario(3L, "José Funcionário", "jose.funcionario@hotmail.com", cargoRepositorio.findById(5L).get(), setorRepositorio.findById(3L).get(), "333333", "890", lista3);

        funcionarioRepositorio.save(funcionario1);
        funcionarioRepositorio.save(funcionario2);
        funcionarioRepositorio.save(funcionario3);
    }

    private void inicializaUsuarioSistema(){

        UsuarioSistema usuario1 = new UsuarioSistema(1L, "Thiago Usuário", "thiago.usuario@hotmail.com", "thirbt", "123");

        UsuarioSistema usuario2 = new UsuarioSistema(2L, "Vitor Usuário", "vitor.usuario@hotmail.com", "vitor_mota", "321");

        usuarioSistemaRepositorio.save(usuario1);
        usuarioSistemaRepositorio.save(usuario2);
    } 
}
