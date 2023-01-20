package com.prueba.john_quiroga_2.repositoryo;

import com.prueba.john_quiroga_2.modelo.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface docenteRepository extends JpaRepository<Docente, Integer> {
}
