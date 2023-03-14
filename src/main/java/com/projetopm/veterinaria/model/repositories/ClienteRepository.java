package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM veterinaria.tb_cliente WHERE email = :email", nativeQuery = true)
    Cliente findByEmail(String email);
}
