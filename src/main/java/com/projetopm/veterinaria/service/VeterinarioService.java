package com.projetopm.veterinaria.service;


import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.model.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeterinarioService {

    int flag = 0;

    @Autowired
    VeterinarioRepository repository;

    public int validacaoLogin(String email, String senha) {
        Veterinario cliente = repository.findByEmailAndSenha(email, senha);

        if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)){
            flag = 1;
            System.out.println(flag);
            return flag;
        } else {
            System.out.println(flag);
            return flag;
        }
    }

    public Veterinario buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public Veterinario encontrarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
