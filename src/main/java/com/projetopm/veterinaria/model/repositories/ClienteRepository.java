package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    Cliente findByEmail(String email);

    Cliente findByEmailAndSenha(String email, String senha);
}
