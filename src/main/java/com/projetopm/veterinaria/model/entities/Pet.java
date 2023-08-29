package com.projetopm.veterinaria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pet")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;
    @Column(nullable = false, length = 150)
    @NotNull
    private String nome;
    @Column(nullable = false, length = 150)
    @NotNull
    private String especie;
    @Column(nullable = false, length = 150)
    @NotNull
    private String sexo;
    @Column(nullable = false, length = 150)
    @NotNull
    private String raca;
    @Column(nullable = false, length = 150)
    @NotNull
    private Integer idade;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "pet")
    private List<Prontuario> prontuarioList = new ArrayList<>();

    public Pet(){

    }

    public Pet(Integer id, String nome, String especie, String sexo, String raca, Integer idade, LocalDate dataCadastro, Cliente cliente, List<Prontuario> prontuarioList) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.raca = raca;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
        this.cliente = cliente;
        this.prontuarioList = prontuarioList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Prontuario> getProntuarioList() {
        return prontuarioList;
    }

    public void setProntuarioList(List<Prontuario> prontuarioList) {
        this.prontuarioList = prontuarioList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id.equals(pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", sexo='" + sexo + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", dataCadastro=" + dataCadastro +
                ", cliente=" + cliente +
                '}';
    }

    @PrePersist
    public void prePersistencia(){
        setDataCadastro(LocalDate.now());
    }
}
