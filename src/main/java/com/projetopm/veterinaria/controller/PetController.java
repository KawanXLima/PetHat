package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService service;

    @PostMapping("/cadastro/{email}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pet cadastroPet(@RequestBody Pet pet, @PathVariable String email){
       return service.cadastroPet(pet, email);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> buscarTodos(){
        List<Pet> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Integer id){
        Pet pet = service.encontrarPorId(id);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarPet(@PathVariable Integer id){
        service.deletarPet(id);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Pet> atualizarPet(@PathVariable Integer id, @RequestBody Pet petAtualizado){
        Pet pet = service.atualizarPet(id, petAtualizado);
        return ResponseEntity.ok(pet);
    }

}
