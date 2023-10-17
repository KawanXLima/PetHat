package com.projetopm.veterinaria.model.repositories;

import com.projetopm.veterinaria.model.entities.Assinatura;
import com.projetopm.veterinaria.model.entities.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Integer> {

}