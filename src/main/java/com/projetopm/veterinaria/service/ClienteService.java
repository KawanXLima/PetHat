package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastroCliente(Cliente cliente){
       return repository.save(cliente);
    }

    public Cliente encontrarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteAtualizado){
        return repository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setSenha(clienteAtualizado.getSenha());
            return repository.save(cliente);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarCliente(Integer id) {
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
