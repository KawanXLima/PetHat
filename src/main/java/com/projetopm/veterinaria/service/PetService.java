package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.model.repositories.ClienteRepository;
import com.projetopm.veterinaria.model.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repositoryPet;

    @Autowired
    private ClienteRepository repositoryCliente;

    public Pet cadastroPet(Pet pet, String email) {
        Cliente cliente = repositoryCliente.findByEmail(email);
        pet.setCliente(cliente);
        return repositoryPet.save(pet);
    }

    public List<Pet> findAll() {
        return repositoryPet.findAll();
    }

    public Pet encontrarPorId(Integer id) {
        return repositoryPet.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarPet(Integer id) {
        repositoryPet.findById(id).map(pet -> {
            repositoryPet.delete(pet);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Pet atualizarPet(Integer id, Pet petAtualizado){

        Pet pet = repositoryPet.findById(id).orElse(null);

        pet.setNome(petAtualizado.getNome());
        pet.setEspecie(petAtualizado.getEspecie());
        pet.setRaca(petAtualizado.getRaca());
        pet.setIdade(petAtualizado.getIdade());
        pet.setSexo(petAtualizado.getSexo());

        return repositoryPet.save(pet);

    }

}
