package com.prueba.john_quiroga_2.controlador;

import com.prueba.john_quiroga_2.modelo.Asignatura;
import com.prueba.john_quiroga_2.servicio.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asigser;

    @GetMapping("/asi/listar")
    public ResponseEntity<List<Asignatura>> getAll() {
        try {
            return new ResponseEntity<>(asigser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/asi/search/{id}")
    public ResponseEntity<Asignatura> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(asigser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/asi/crear")
    public ResponseEntity<Asignatura> createReproducion(@RequestBody Asignatura asig){
        try {
            return new ResponseEntity<>(asigser.save(asig), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/asi/delete/{id}")
    public ResponseEntity<?> deleteReproduction(@PathVariable("id") Integer id) {
        try {
            asigser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar La asignatura");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/asi/update/{id}")
    public ResponseEntity<Asignatura> updateClient(@RequestBody Asignatura asignatura, @PathVariable("id") Integer id){
        Asignatura lista = asigser.findById(id);

        if(lista == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {

                lista.setCarrera(asignatura.getCarrera());
                lista.setDocente(asignatura.getDocente());
                lista.setHora_ini(asignatura.getHora_ini());
                lista.setHora_fin(asignatura.getHora_fin());

                return new ResponseEntity<>(asigser.save(asignatura), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
