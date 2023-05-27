package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
    Veterinario findByEmail(String email);

    List<Veterinario> findByEspecialidade(String especialidade);
}
