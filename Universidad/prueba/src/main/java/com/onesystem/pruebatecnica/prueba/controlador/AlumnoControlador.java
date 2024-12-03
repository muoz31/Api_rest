package com.onesystem.pruebatecnica.prueba.controlador;

import com.onesystem.pruebatecnica.prueba.modelo.Alumno;
import com.onesystem.pruebatecnica.prueba.servicios.AlumnoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/alumnos")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AlumnoControlador {
    @Autowired
    private AlumnoServicio alumnoServicio;

    //Obtener total alumnos
    @GetMapping
    public ResponseEntity<List<Alumno>> obtenerTotalAlumnos(){
        List<Alumno> alumnos = alumnoServicio.obtenerTodos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    //Obtener alumno por su Id
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable("id") Long id) {
        Alumno alumno = alumnoServicio.obtenerAlumnoId(id);
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }
    //Registro alumno
    @PostMapping
    public ResponseEntity<Alumno> registrarAlumno(@RequestBody Alumno alumno) {
        System.out.println("Alumno recibido: " + alumno);
        Alumno nuevoAlumno = alumnoServicio.registro(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    //eliminar un alumno

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") Long id) {
        alumnoServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable("id") Long id, @RequestBody Alumno alumno) {
        Alumno alumnoActualizado = alumnoServicio.actualizar(id, alumno);
        return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
    }





}

