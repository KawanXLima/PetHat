package com.projetopm.veterinaria.controller;


import com.projetopm.veterinaria.model.entities.Administrador;
import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adm")
public class AdministradorController {

    @Autowired
    AdministradorService service;


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Integer id){
        Veterinario vet = service.encontrarPorId(id);
        return ResponseEntity.ok(vet);
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> findAll(){
        List<Veterinario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Veterinario cadastroVeterinario(@RequestBody Veterinario veterinario){
        return service.cadastroVeterinario(veterinario);
    }


    @PutMapping("/perfil/alterar/{id}")
    public ResponseEntity<Veterinario> atualizarVeterinario(@PathVariable Integer id, @RequestBody Veterinario veterinarioAtualizado){
        Veterinario veterinario = service.atualizarVeterinario(id, veterinarioAtualizado);
        return ResponseEntity.ok(veterinario);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarVeterinario(@PathVariable Integer id){
        service.deletarVeterinario(id);
    }


    @GetMapping("/login/{email}/{senha}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> login(@PathVariable String email, @PathVariable String senha){
        int flag = service.validacaoLogin(email, senha);
        if(flag == 0){
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);

    }

}
