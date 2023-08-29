package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository  extends JpaRepository<Prontuario, Integer> {
}
