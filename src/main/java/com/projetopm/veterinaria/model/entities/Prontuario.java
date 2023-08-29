package com.projetopm.veterinaria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 11)
    @JsonFormat(pattern = "dd/MM/yyyy" , timezone = "GMT-3")
    @NotNull
    private String data;

    @Column(nullable = false, length = 11)
    @NotNull
    private String horario;

    @Column(nullable = false, length = 50)
    @NotNull
    private String imunizacao;

    @Column(nullable = false, length = 150)
    @NotNull
    private String sinaisClinicos;

    @Column(nullable = false, length = 150)
    @NotNull
    private String exames;

    @Column(nullable = false, length = 400)
    @NotNull
    private String prescricao;

    @Column(nullable = false, length = 300)
    @NotNull
    private String diagnostico;

    @Column(nullable = false, length = 300)
    @NotNull
    private String observacao;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Optional<Pet> pet;

    public Prontuario(){}

    public Prontuario(Integer id, String data, String horario, String imunizacao, String sinaisClinicos, String exames, String prescricao, String diagnostico, String observacao, Pet pet) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.imunizacao = imunizacao;
        this.sinaisClinicos = sinaisClinicos;
        this.exames = exames;
        this.prescricao = prescricao;
        this.diagnostico = diagnostico;
        this.observacao = observacao;
        this.pet = pet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getImunizacao() {
        return imunizacao;
    }

    public void setImunizacao(String imunizacao) {
        this.imunizacao = imunizacao;
    }

    public String getSinaisClinicos() {
        return sinaisClinicos;
    }

    public void setSinaisClinicos(String sinaisClinicos) {
        this.sinaisClinicos = sinaisClinicos;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Optional<Pet> getPet() {
        return pet;
    }

    public void setPet(Optional<Pet> pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario prontuario = (Prontuario) o;
        return id.equals(prontuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
