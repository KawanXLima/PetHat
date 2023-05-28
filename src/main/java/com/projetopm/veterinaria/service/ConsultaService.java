package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Consulta;
import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.model.repositories.ConsultaRepository;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import com.projetopm.veterinaria.model.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private PetRepository petRepository;

    public Consulta save(Consulta consulta, Integer id, String email){
        Optional<Pet> petOptional = petRepository.findById(id);
        Veterinario veterinario = veterinarioRepository.findByEmail(email);

        consulta.setPet(petOptional.get());
        consulta.setVeterinario(veterinario);

        return consultaRepository.save(consulta);
    }
}
