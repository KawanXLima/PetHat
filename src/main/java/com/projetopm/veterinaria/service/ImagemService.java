package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Imagem;
import com.projetopm.veterinaria.model.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImagemService  {
    @Autowired
    private ImagemRepository imageRepository;

    public Imagem create(Imagem image) {
        return imageRepository.save(image);
    }
    public List<Imagem> viewAll() {
        return (List<Imagem>) imageRepository.findAll();
    }
    public Imagem viewById(Integer id) {
        return imageRepository.findById(id).get();
    }
}