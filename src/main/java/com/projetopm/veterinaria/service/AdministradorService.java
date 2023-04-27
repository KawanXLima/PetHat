package com.projetopm.veterinaria.service;


import com.projetopm.veterinaria.model.entities.Administrador;
import com.projetopm.veterinaria.model.entities.Veterinario;
import com.projetopm.veterinaria.model.repositories.AdministradorRepository;
import com.projetopm.veterinaria.model.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;

@Service
public class AdministradorService {

    int flag = 0;

    @Autowired
    AdministradorRepository repository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    VeterinarioRepository vet_repository;



    public Veterinario encontrarPorId(Integer id){
        return vet_repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public int validacaoLogin(String email, String senha){
        Administrador adm = repository.findByEmailAndSenha(email, senha);

        if(adm.getEmail().equals(email) && adm.getSenha().equals(senha)){
            flag = 1;
            System.out.println(flag);
            return flag;
        } else {
            System.out.println(flag);
            return flag;
        }

    }

    public List<Veterinario> findAll() {
        return vet_repository.findAll();
    }

    public Veterinario cadastroVeterinario(Veterinario veterinario) throws ParseException {
        String encoder = this.passwordEncoder.encode(veterinario.getSenha());
        veterinario.setSenha(encoder);
        return vet_repository.save(veterinario);
    }

    public void deletarVeterinario(Integer id) {
        vet_repository.findById(id).map(veterinario -> {
            vet_repository.delete(veterinario);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Veterinario atualizarVeterinario(Integer id, Veterinario veterinarioAtualizado) {
        Veterinario veterinario = vet_repository.findById(id).orElse(null);

        String encoder = this.passwordEncoder.encode(veterinarioAtualizado.getSenha());

        veterinario.setNome(veterinarioAtualizado.getNome());
        veterinario.setEmail(veterinarioAtualizado.getEmail());
        veterinario.setTelefone(veterinarioAtualizado.getTelefone());
        veterinario.setSenha(encoder);

        return vet_repository.save(veterinario);
    }
}
