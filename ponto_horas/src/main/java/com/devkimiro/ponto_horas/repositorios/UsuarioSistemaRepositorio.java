package com.devkimiro.ponto_horas.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;

@Repository
public interface UsuarioSistemaRepositorio extends JpaRepository<UsuarioSistema, Long> {
    
    @Query(value = "SELECT u FROM UsuarioSistema u WHERE login = :login")
    Optional<UsuarioSistema> findByLogin(@Param("login") String login);

    @Query(value = "SELECT u FROM UsuarioSistema u WHERE email = :email")
    Optional<UsuarioSistema> findByEmail(@Param("email") String email);
}
