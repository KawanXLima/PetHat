package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Consulta;
import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.model.repositories.ConsultaRepository;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import com.projetopm.veterinaria.model.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VeterinarioRepository vetRepository;
    public Consulta solicitarConsulta(Consulta consulta, Integer id, String email){
        Optional<Pet> pet = petRepository.findById(id);
        Veterinario vet = vetRepository.findByEmail(email);

        consulta.setPet(pet.get());
        consulta.setVeterinario(vet);

        return repository.save(consulta);
    }
}
