package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Docente {

    @Column(name="id_docente")
    private Integer id;
    private  String especialidad;

    //creando relacion (1 a muchos)
    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;


    public Docente() {
    }

    public Docente(Integer id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
