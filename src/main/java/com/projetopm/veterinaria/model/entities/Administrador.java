package com.projetopm.veterinaria.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_administrador")
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(unique = true,nullable = false, length = 150)
    @NotNull
    private String email;

    @Column(nullable = false, length = 22)
    @NotNull
    private String senha;
    
    public Administrador(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador administrador = (Administrador) o;
        return Objects.equals(id, administrador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

