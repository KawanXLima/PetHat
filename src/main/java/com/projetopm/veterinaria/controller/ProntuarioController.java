package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prontuario")
public class ProntuarioController {
    @Autowired
    ProntuarioService service;
}
