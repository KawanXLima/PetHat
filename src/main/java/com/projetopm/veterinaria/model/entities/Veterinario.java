package com.projetopm.veterinaria.model.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_veterinario")
public class Veterinario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotNull
    private String nome;

    @Column(unique = true,nullable = false, length = 150)
    @NotNull
    private String email;

    @Column(nullable = false, length = 22)
    @NotNull
    private String senha;

    @Column(nullable = false, length = 11)
    @NotNull
    private String telefone;

    @Column(unique = true, nullable = false, length = 9)
    @NotNull
    private String crmvce;

    @Column(nullable = false, length = 6)
    @NotNull
    private String dataPortariaHabilitacao;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;


    public Veterinario(){

    }

    public Veterinario(Integer id, String nome, String email, String senha, String telefone, String crmvce, String dataPortariaHabilitacao, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.crmvce = crmvce;
        this.dataPortariaHabilitacao = dataPortariaHabilitacao;
        this.dataCadastro = dataCadastro;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrmvce() {
        return crmvce;
    }

    public void setCrmvce(String crmvce) {
        this.crmvce = crmvce;
    }

    public String getDataPortariaHabilitacao() {
        return dataPortariaHabilitacao;
    }

    public void setDataPortariaHabilitacao(String dataPortariaHabilitacao) {
        this.dataPortariaHabilitacao = dataPortariaHabilitacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinario that = (Veterinario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", crmvce='" + crmvce + '\'' +
                ", dataPortariaHabilitacao='" + dataPortariaHabilitacao + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

    @PrePersist
    public void prePersistencia(){
        setDataCadastro(LocalDate.now());
    }

}
