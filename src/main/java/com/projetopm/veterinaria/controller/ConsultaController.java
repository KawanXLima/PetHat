package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Consulta;
import com.projetopm.veterinaria.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/{id}/{email}")
    public Consulta agendar(@RequestBody Consulta consulta, @PathVariable Integer id, @PathVariable String email){
        return service.save(consulta, id, email);
    }

    @GetMapping("/agendada")
    public ResponseEntity<List<Consulta>> agendamentos(@RequestParam("email") String email){
        List<Consulta> consultaList = service.findAll(email);
        return ResponseEntity.ok().body(consultaList);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelarConsulta(@PathVariable Integer id){
        service.deletarPorId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Integer id){
        Consulta consulta = service.encontrarPorId(id);
        return ResponseEntity.ok(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> concluirConsulta(@PathVariable Integer id){
        Consulta consulta = service.concluirConsulta(id);
        return ResponseEntity.ok(consulta);
    }
}
