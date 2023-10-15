package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Prontuario;
import com.projetopm.veterinaria.model.entities.Receita;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import com.projetopm.veterinaria.model.repositories.ProntuarioRepository;
import com.projetopm.veterinaria.model.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private ReceitaRepository repositoryReceita;


    public Receita encontrarPorId(Integer id) {
        return repositoryReceita.findById(id).orElse(null);
    }


    public Receita cadastrarReceita(Receita receita) {
        return repositoryReceita.save(receita);
    }

}
