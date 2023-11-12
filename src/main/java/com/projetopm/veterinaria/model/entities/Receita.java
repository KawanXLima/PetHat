package com.projetopm.veterinaria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "tb_receita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 300)
    @NotNull
    private String medicamentos;

    @Column(nullable = false, length = 300)
    @NotNull
    private String dosagem;

    @Column(nullable = false, length = 11)
    @JsonFormat(pattern = "dd/MM/yyyy" , timezone = "GMT-3")
    @NotNull
    private String dataEmissao;

    @Column(nullable = false, length = 11)
    @JsonFormat(pattern = "dd/MM/yyyy" , timezone = "GMT-3")
    @NotNull
    private String dataValidade;

    public Receita() {
    }

    public Receita(Integer id, String medicamentos, String dosagem, String dataEmissao, String dataValidade) {
        this.id = id;
        this.medicamentos = medicamentos;
        this.dosagem = dosagem;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return id.equals(receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
