package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Consulta;
import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.model.entities.enumerator.StatusConsulta;
import com.projetopm.veterinaria.model.repositories.ConsultaRepository;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import com.projetopm.veterinaria.model.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private PetRepository petRepository;

    public Consulta save(Consulta aux, Integer id, String email){
            List<Consulta> consultaList = consultaRepository.findAll();

            for (Consulta consult : consultaList) {
                if (horaIndisponivel(consult, aux) && diaIndisponivel(consult, aux)) {
                    throw new RuntimeException("Horário Indisponível");
                }
            }

            Optional<Pet> petOptional = petRepository.findById(id);
            Veterinario veterinario = veterinarioRepository.findByEmail(email);

            aux.setPet(petOptional.orElseThrow(() -> new RuntimeException("Pet não encontrado")));
            aux.setVeterinario(veterinario);
            aux.setStatusConsulta(StatusConsulta.PENDENTE);
            return consultaRepository.save(aux);
        }


    public List<Consulta> findAll(String email) {
        List<Consulta> consultaList = new ArrayList<>();
        List<Consulta> aux = consultaRepository.findAll();
        System.out.println(aux.size());
        for(Consulta consulta : aux){
            if(consulta.getPet().getCliente().getEmail().equals(email) || consulta.getVeterinario().getEmail().equals(email)){
                consultaList.add(consulta);
            }
        }
        return consultaList;
    }

    public void deletarPorId(Integer id) {
        consultaRepository.deleteById(id);
    }

    private boolean horaIndisponivel(Consulta consulta, Consulta aux){
        if(consulta.getHora().equals(aux.getHora())){
            return true;
        } else{
            return false;
        }
    }

    private boolean diaIndisponivel(Consulta consulta, Consulta aux){
        if(consulta.getDataConsulta().equals(aux.getDataConsulta())){
            return true;
        } else{
            return false;
        }
    }

    public Consulta encontrarPorId(Integer id) {
        return consultaRepository.findById(id).get();
    }

    public Consulta concluirConsulta(Integer id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        consulta.get().setStatusConsulta(StatusConsulta.CONCLUIDO);
        return consultaRepository.save(consulta.get());
    }
}
