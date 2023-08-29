package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProntuarioRepository  extends JpaRepository<Prontuario, Integer> {

    List<Prontuario> findAllById(Integer idPet);
}
