package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.*;
import com.projetopm.veterinaria.model.exception.ExceptionConfig;
import com.projetopm.veterinaria.model.repositories.AssinaturaRepository;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import com.projetopm.veterinaria.model.repositories.ProntuarioRepository;
import com.projetopm.veterinaria.model.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProntuarioService {
    int flag = 0;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private ProntuarioRepository repositoryProntuario;

    @Autowired
    private PetRepository repositoryPet;

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private AssinaturaRepository assinaturaRepository;


    //GET
    public List<Prontuario> listarProntuario(Integer id) {
        List<Prontuario> prontuarioList = new ArrayList<>();
        List<Prontuario> aux = repositoryProntuario.findAll();
        System.out.println(aux.size());
        for(Prontuario prontuario : aux){
            if(prontuario.getPet().getId().equals(id)){
                prontuarioList.add(prontuario);
            }
        }
        return prontuarioList;
    }

    //POST
    public Prontuario cadastroProntuario(Prontuario prontuario, Integer id) {
        Pet pet = repositoryPet.findById(id).orElse(null);
        prontuario.setPet(pet);
        return repositoryProntuario.save(prontuario);
    }

}
