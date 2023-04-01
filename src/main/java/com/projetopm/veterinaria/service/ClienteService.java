package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ClienteService {

    int flag = 0;

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastroCliente(Cliente cliente){
       return repository.save(cliente);
    }

    public Cliente encontrarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteAtualizado){

        Cliente cliente = repository.findById(id).orElse(null);

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setSenha(clienteAtualizado.getSenha());

        return repository.save(cliente);

    }

    public void deletarCliente(Integer id) {
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public int validacaoLogin(String email, String senha){
        Cliente cliente = repository.findByEmailAndSenha(email, senha);

        if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)){
            flag = 1;
            System.out.println(flag);
            return flag;
        } else {
            System.out.println(flag);
            return flag;
        }

    }

    public Cliente buscarPorEmail(String email){
        return repository.findByEmail(email);
    }

}
