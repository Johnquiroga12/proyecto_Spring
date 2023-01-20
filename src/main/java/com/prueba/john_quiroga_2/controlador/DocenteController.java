package com.prueba.john_quiroga_2.controlador;

import com.prueba.john_quiroga_2.modelo.Docente;
import com.prueba.john_quiroga_2.servicio.docenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class DocenteController {
    @Autowired
    private docenteService doser;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Docente>> getAll() {
        try {
            return new ResponseEntity<>(doser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Docente> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(doser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/do/crear")
    public ResponseEntity<Docente> createReproducion(@RequestBody Docente cancion){
        try {
            return new ResponseEntity<>(doser.save(cancion), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            doser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al docente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Docente> updateClient(@RequestBody Docente doc, @PathVariable("id") Integer id){
        Docente ca =doser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre(doc.getNombre());
                ca.setApellido(doc.getApellido());
                ca.setAsignatura(doc.getAsignatura());
                ca.setEmail(doc.getEmail());

                return new ResponseEntity<>(doser.save(doc), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
