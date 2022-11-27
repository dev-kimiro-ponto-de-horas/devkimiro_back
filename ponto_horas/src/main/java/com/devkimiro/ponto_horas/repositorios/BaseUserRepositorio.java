package com.devkimiro.ponto_horas.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.BaseUser;

@Repository
public interface BaseUserRepositorio extends JpaRepository<BaseUser, Long> {
    
    @Query(value = "SELECT u FROM BaseUser u WHERE nome = :nome")
    Optional<BaseUser> findByNome(@Param("nome") String nome);

    @Query(value = "SELECT u FROM BaseUser u WHERE email = :email")
    Optional<BaseUser> findByEmail(@Param("email") String email);
}
