package com.prueba.john_quiroga_2.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "asignatura")

public class Asignatura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer id_asignatura;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "hora_ini")
    private String hora_ini;

    @Column(name = "hora_fin")
    private String hora_fin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
    private Docente docente;

}
