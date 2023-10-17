package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Assinatura;
import com.projetopm.veterinaria.model.entities.Imagem;
import com.projetopm.veterinaria.model.repositories.AssinaturaRepository;
import com.projetopm.veterinaria.model.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssinaturaService {
    @Autowired
    private AssinaturaRepository assinaturaRepositoryRepository;

    public Assinatura create(Assinatura image) {
        return assinaturaRepositoryRepository.save(image);
    }
    public List<Assinatura> viewAll() {
        return (List<Assinatura>) assinaturaRepositoryRepository.findAll();
    }
    public Assinatura viewById(Integer id) {
        return assinaturaRepositoryRepository.findById(id).get();
    }
}