package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmail(String email);
    Cliente findBycpf (String cpf);
}
