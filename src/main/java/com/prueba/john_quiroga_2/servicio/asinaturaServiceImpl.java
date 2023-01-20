package com.prueba.john_quiroga_2.servicio;
import com.prueba.john_quiroga_2.modelo.Asignatura;
import com.prueba.john_quiroga_2.repositoryo.asignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class asinaturaServiceImpl extends GenericServiceImpl<Asignatura, Integer> implements AsignaturaService {
    @Autowired
    private asignaturaRepository asigRepository;

    @Override
    public CrudRepository<Asignatura, Integer> getDao() {
        return asigRepository;
    }
}
