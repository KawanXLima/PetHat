package com.projetopm.veterinaria.controller;


import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinario")
public class VeterinarioController {

    @Autowired
    VeterinarioService service;

    @GetMapping("/login/{email}/{senha}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> login(@PathVariable String email, @PathVariable String senha){
        int flag = service.validacaoLogin(email, senha);
        if(flag == 0){
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Integer id){
        Veterinario veterinario = service.encontrarPorId(id);
        return ResponseEntity.ok(veterinario);
    }


    @GetMapping("/perfil/id/{email}")
    public ResponseEntity<Integer> buscarid(@PathVariable String email){
        Veterinario veterinario = service.buscarPorEmail(email);
        return ResponseEntity.ok(veterinario.getId());
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> buscarPorEspecialidade(@RequestParam String especialidade){

        List<Veterinario> listVet = service.encontrarPorEspecialidade(especialidade.toLowerCase());
        return ResponseEntity.ok().body(listVet);
    }
}
