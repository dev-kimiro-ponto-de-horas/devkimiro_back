package com.devkimiro.ponto_horas.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.Funcionario;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
    
    @Query(value = "SELECT u FROM BaseUser u WHERE cracha = :cracha")
    Optional<Funcionario> findByCracha(String cracha);
}
