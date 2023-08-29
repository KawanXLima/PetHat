package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Pet;
import com.projetopm.veterinaria.model.entities.Prontuario;
import com.projetopm.veterinaria.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prontuario")
public class ProntuarioController {
    @Autowired
    ProntuarioService service;


    @PostMapping("/idPet/{idPet}")
    public Prontuario cadastroProntuario(@RequestBody Prontuario prontuario, @PathVariable Integer idPet){
        return service.cadastroProntuario(prontuario, idPet);
    }

    @GetMapping("/prontuarios/{idPet}")
    public List<Prontuario> listarProntuarios(@PathVariable Integer idPet){
        return service.listarProntuario(idPet);
    }


}
