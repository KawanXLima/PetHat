package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.model.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeterinarioService {

    int flag = 0;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    VeterinarioRepository repository;

    public int validacaoLogin(String email, String senha) {
        Veterinario veterinario = repository.findByEmail(email);
        if(veterinario.getEmail().equals(email) && verificarSenha(veterinario, senha)){
            int flag = 1;
            return flag;
        }
        System.out.println(flag);
        return flag;

    }

    public Veterinario buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public Veterinario encontrarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private boolean verificarSenha(Veterinario veterinario, String senha){
        Boolean criptografia = this.passwordEncoder.matches(senha,veterinario.getSenha());
        System.out.println(criptografia);
        if(criptografia){
            return true;
        } else{
            return false;
        }
    }

}
