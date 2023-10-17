package com.projetopm.veterinaria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "image_table")
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private Blob image;
    private Date date = new Date();

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public long getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Blob getImage() {
        return image;
    }
    public void setImage(Blob image) {
        this.image = image;
    }
    public Date getDate() {
        return date;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @PrePersist
    public void prePersistencia(){
        setDataCadastro(LocalDate.now());
    }
}