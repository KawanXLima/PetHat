package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    Cliente findByEmail(String email);

}
