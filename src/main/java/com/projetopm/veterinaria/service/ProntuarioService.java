package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.model.entities.Prontuario;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import com.projetopm.veterinaria.model.repositories.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {
    int flag = 0;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private ProntuarioRepository repositoryProntuario;

    @Autowired
    private PetRepository repositoryPet;


    //GET
    public List<Prontuario> listarProntuario(Integer id) {
        return repositoryProntuario.findAllById(id);
    }

    //POST
    public Prontuario cadastroProntuario(Prontuario prontuario, Integer id) {
        Pet pet = repositoryPet.findById(id).orElse(null);
        prontuario.setPet(pet);
        return repositoryProntuario.save(prontuario);
    }

}
