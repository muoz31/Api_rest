package com.onesystem.pruebatecnica.prueba.servicios;

import com.onesystem.pruebatecnica.prueba.modelo.Profesor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@Service
public class ProfesorServicio {
    private List<Profesor> profesores = new ArrayList<>();
    private long idcounter = 0;

    //Obtener lista completa de profesores
    public List<Profesor> obtenerTodos() {
        return new ArrayList<>(profesores);
    }

    //Busqueda de profesor
    public Profesor obtenerProfesorId (Long id) {
        Optional<Profesor> profesor = profesores.stream().filter(a -> a.getId().equals(id)).findFirst();
        return profesor.orElse(null);
    }

    //Registro de un profesor
    public Profesor registro(Profesor profesor) {
        profesor.setId(++idcounter);
        profesores.add(profesor);
        return profesor;
    }

    //Eliminar a un profesor por su id
    public void eliminar(Long id){
        profesores.removeIf(a ->a.getId().equals(id));
    }

    //Actualizar datos de un alumno
    public Profesor actualizar(Long id,Profesor profesorActualizado) {
        Profesor profesorExistente = obtenerProfesorId(id);
        if(profesorExistente != null){
            profesorExistente.setNombreCompleto(profesorActualizado.getNombreCompleto());
            profesorExistente.setIdentificacion(profesorActualizado.getIdentificacion());
            profesorExistente.setTelefono(profesorExistente.getTelefono());
            profesorExistente.setEmail(profesorExistente.getEmail());
            profesorExistente.setDireccion(profesorExistente.getDireccion());
            profesorExistente.setGenero(profesorExistente.getGenero());
            profesorExistente.setSalario(profesorExistente.getSalario());
            profesorExistente.setDependencia(profesorActualizado.getDependencia());
            profesorExistente.setMateria(profesorExistente.getMateria());
            return profesorExistente;
        }
        return null;
    }

}
