package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
