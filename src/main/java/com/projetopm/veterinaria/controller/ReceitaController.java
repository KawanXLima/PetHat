package com.projetopm.veterinaria.controller;


import com.projetopm.veterinaria.model.entities.Receita;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    @Autowired
    ReceitaService service;


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Receita> buscarPorId(@PathVariable Integer id){
        Receita receita = service.encontrarPorId(id);
        return ResponseEntity.ok(receita);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Receita cadastrarReceita(@RequestBody Receita receita) throws ParseException {
        return service.cadastrarReceita(receita);
    }

}
