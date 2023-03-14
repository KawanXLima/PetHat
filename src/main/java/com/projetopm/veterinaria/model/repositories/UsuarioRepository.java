package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
