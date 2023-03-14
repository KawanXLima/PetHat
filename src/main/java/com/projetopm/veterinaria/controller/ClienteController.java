package com.projetopm.veterinaria.controller;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente cadastroCliente(@RequestBody Cliente cliente){
        return service.cadastroCliente(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
        Cliente cliente = service.encontrarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/perfil/alterar/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        Cliente cliente = service.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/perfil/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(@PathVariable Integer id){
        service.deletarCliente(id);
    }

    @GetMapping("/login/{email}/{senha}")
    @ResponseStatus(HttpStatus.OK)
    public boolean login(@PathVariable String email, @PathVariable String senha){
        int flag = service.validacaoLogin(email, senha);
        if(flag == 0){
            return false;
        }
        return true;
    }
    @GetMapping("/perfil/{email}")
    public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email){
        Cliente cliente = service.buscarPorEmail(email);
        return ResponseEntity.ok(cliente);
    }
}
