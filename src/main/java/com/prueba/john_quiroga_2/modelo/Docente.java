package com.prueba.john_quiroga_2.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class Docente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer id_docente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignatura;

}
