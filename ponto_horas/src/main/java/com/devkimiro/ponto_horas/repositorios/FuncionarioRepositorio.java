package com.devkimiro.ponto_horas.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.Funcionario;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
    
    @Query(value = "SELECT u FROM Funcionario u WHERE cracha = :cracha")
    Optional<Funcionario> findByCracha(@Param("cracha") String cracha);

    @Query(value = "SELECT u FROM Funcionario u WHERE email = :email")
    Optional<Funcionario> findByEmail(@Param("email") String email);
}
