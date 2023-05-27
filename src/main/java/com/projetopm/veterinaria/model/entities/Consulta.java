package com.projetopm.veterinaria.model.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "tb_consulta")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;

    @Column(nullable = false, length = 11)
    @JsonFormat(timezone = "GMT-3")
    private Calendar data;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Consulta(){}

    public Consulta(Integer id, Calendar data, Veterinario veterinario, Pet pet) {
        this.id = id;
        this.data = data;
        this.veterinario = veterinario;
        this.pet = pet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

//    public Time getHora() {
//        return hora;
//    }

//    public void setHora(Time hora) {
//        this.hora = hora;
//    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return id.equals(consulta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
