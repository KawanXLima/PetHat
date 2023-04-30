package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
