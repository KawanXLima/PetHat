package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
    Veterinario findByEmail(String email);
    Veterinario findByEmailAndSenha(String email, String senha);
}
