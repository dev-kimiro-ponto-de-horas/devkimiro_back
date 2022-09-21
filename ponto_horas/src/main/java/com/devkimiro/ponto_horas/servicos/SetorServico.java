package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Setor;
import com.devkimiro.ponto_horas.repositorios.SetorRepositorio;

@Service
public class SetorServico {
    
    @Autowired
    private SetorRepositorio setorRepositorio;

    public List<Setor> listarTodosSetores(){
        return setorRepositorio.findAll();
    }

    public Setor criarSetor(Setor setor){
        return setorRepositorio.save(setor);
    }

    public Setor buscarSetorPorId(Long id){
         Optional<Setor> setor = setorRepositorio.findById(id);
         if(setor.isEmpty()){
            throw new RuntimeException("O setor não pode ser encontrado pelo Id!");
         }
         return setor.get();
    }

    public Setor buscarSetorPorNome(String nomeSetor){
        Optional<Setor> setorEncontrado = setorRepositorio.findByNomeSetor(nomeSetor);
        if(setorEncontrado.isEmpty()){
            throw new RuntimeException("O setor não pode ser encontrado pelo nome!");
        }
        return setorEncontrado.get();
    }

    public Setor atualizarSetor(Setor setor, Long id){
        Setor setorAntigo = buscarSetorPorId(id);
        setor.setId(setorAntigo.getId());
        return setorRepositorio.save(setor);
    }

    public void deletarSetor (Long id){
        setorRepositorio.deleteById(id);
    }
}
