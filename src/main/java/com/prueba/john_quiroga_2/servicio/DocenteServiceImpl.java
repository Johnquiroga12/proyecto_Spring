package com.prueba.john_quiroga_2.servicio;

import com.prueba.john_quiroga_2.modelo.Docente;
import com.prueba.john_quiroga_2.repositoryo.docenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl extends GenericServiceImpl<Docente, Integer> implements docenteService {
    @Autowired
    private docenteRepository docenRepository;

    @Override
    public CrudRepository<Docente, Integer> getDao() {
        return docenRepository;
    }
}
