package com.devkimiro.ponto_horas.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.devkimiro.ponto_horas.data.DetalhaUsuarioData;
import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class JWTAutenticadorFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPERICAO = 600_000;
    public static final String TOKEN_SENHA = "d56d9912-473b-4901-a24d-d5acb81d3c2b";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticadorFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            UsuarioSistema usuarioSistema = new ObjectMapper().readValue(request.getInputStream(),UsuarioSistema.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuarioSistema.getLogin(),
                    usuarioSistema.getSenha(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuário", e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        DetalhaUsuarioData usuarioData = (DetalhaUsuarioData) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(usuarioData.getUsername()).
                withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPERICAO)).
                sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();

    }
}
