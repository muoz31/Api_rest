package com.onesystem.pruebatecnica.prueba.servicios;

import com.onesystem.pruebatecnica.prueba.modelo.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServicio {

    private List<Alumno> alumnos = new ArrayList<>();
    private long idcounter = 0;

    //Obtener lista completa de alumnos
    public List<Alumno> obtenerTodos() {
        return new ArrayList<>(alumnos);
    }

    //Busqueda de alumno
    public Alumno obtenerAlumnoId (Long id) {
        Optional<Alumno> alumno = alumnos.stream().filter(a -> a.getId().equals(id)).findFirst();
        return alumno.orElse(null);
    }

    //Registro de un alumno
    public Alumno registro(Alumno alumno) {
        alumno.setId(++idcounter);
        alumnos.add(alumno);
        return alumno;
    }

    //Eliminar a un alumno por su id
    public void eliminar(Long id){
        alumnos.removeIf(a ->a.getId().equals(id));
    }

    //Actualizar datos de un alumno
    public Alumno actualizar(Long id,Alumno alumnoActualizado) {
        Alumno alumnoExistente = obtenerAlumnoId(id);
        if(alumnoExistente != null){
            alumnoExistente.setNombreCompleto(alumnoActualizado.getNombreCompleto());
            alumnoExistente.setIdentificacion(alumnoActualizado.getIdentificacion());
            alumnoExistente.setTelefono(alumnoActualizado.getTelefono());
            alumnoExistente.setEmail(alumnoActualizado.getEmail());
            alumnoExistente.setDireccion(alumnoActualizado.getDireccion());
            alumnoExistente.setGenero(alumnoActualizado.getGenero());
            alumnoExistente.setNumeroMatricula(alumnoActualizado.getNumeroMatricula());
            alumnoExistente.setPrograma(alumnoActualizado.getPrograma());
            alumnoExistente.setNotaPromedio(alumnoActualizado.getNotaPromedio());
            return alumnoExistente;
        }
        return null;
    }

}
