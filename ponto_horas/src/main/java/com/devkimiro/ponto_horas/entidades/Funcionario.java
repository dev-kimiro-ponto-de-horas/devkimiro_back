package com.devkimiro.ponto_horas.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends BaseUser {
    
    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    private Setor setor;

    @Column(unique = true)
    @NotBlank(message = "O crachá do funcionário não pode ser enviado em branco!")
    @NotNull(message = "O crachá do funcionário não pode ser vazio!")
    private String cracha;

    @NotBlank(message = "A senha do funcionário não pode ser enviado em branco!")
    @NotNull(message = "A senha do funcionário não pode ser vazia!")
    private String senha;

    @OneToMany
    private List<Calendario> calendario;

    public Funcionario(Long id, @NotNull(message = "O nome não pode ser nulo!") String nome,
            @NotNull(message = "O e-mail não pode estar vazio!") String email, Cargo cargo, Setor setor,
            @NotBlank(message = "O crachá do funcionário não ser enviado em branco!") @NotNull(message = "O crachá do funcionário não pode ser vazio!") String cracha,
            @NotBlank(message = "A senha do funcionário não pode ser enviado em branco!") @NotNull(message = "A senha do funcionário não pode ser vazia!") String senha) {
        super(id, nome, email);
        this.cargo = cargo;
        this.setor = setor;
        this.cracha = cracha;
        this.senha = senha;
    }

    public Funcionario(Long id, @NotNull(message = "O nome não pode ser nulo!") String nome,
            @NotNull(message = "O e-mail não pode estar vazio!") String email, Cargo cargo, Setor setor,
            @NotBlank(message = "O crachá do funcionário não pode ser enviado em branco!") @NotNull(message = "O crachá do funcionário não pode ser vazio!") String cracha,
            @NotBlank(message = "A senha do funcionário não pode ser enviado em branco!") @NotNull(message = "A senha do funcionário não pode ser vazia!") String senha,
            List<Calendario> calendario) {
        super(id, nome, email);
        this.cargo = cargo;
        this.setor = setor;
        this.cracha = cracha;
        this.senha = senha;
        this.calendario = calendario;
    }
}
