package com.onesystem.pruebatecnica.prueba.controlador;

import com.onesystem.pruebatecnica.prueba.modelo.Alumno;
import com.onesystem.pruebatecnica.prueba.modelo.Profesor;
import com.onesystem.pruebatecnica.prueba.servicios.AlumnoServicio;
import com.onesystem.pruebatecnica.prueba.servicios.ProfesorServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/profesores")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProfesorControlador {
    @Autowired
    private ProfesorServicio profesorServicio;

    //Obtener total profesores

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTotalProfesores() {
        List<Profesor> profesores = profesorServicio.obtenerTodos();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    //Obtenerprofesor por su Id

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable("id") Long id) {
        Profesor profesor = profesorServicio.obtenerProfesorId(id);
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    //Registro profesor

    @PostMapping
    public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorServicio.registro(profesor);
        return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
    }

    //eliminar un profesor

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable("id") Long id) {
        profesorServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //actualizar a el profesor por su id
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable("id") Long id, @RequestBody Profesor profesor) {
        Profesor profesorActualizado = profesorServicio.actualizar(id, profesor);
        return new ResponseEntity<>(profesorActualizado, HttpStatus.OK);
    }

}
