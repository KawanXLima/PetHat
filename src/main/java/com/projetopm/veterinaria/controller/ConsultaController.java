package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Consulta;
import com.projetopm.veterinaria.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/{id}/{email}")
    public Consulta agendar(@RequestBody Consulta consulta, @PathVariable Integer id, @PathVariable String email){
        return service.save(consulta, id, email);
    }
}
