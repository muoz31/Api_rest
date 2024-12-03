package com.onesystem.pruebatecnica.prueba.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Profesor extends Persona implements Universidad{

    //se crea nueva variable para identificar al Profesor
    private Long id;
    private double salario;
    private String dependencia;
    private String materia;


    public Profesor(String nombreCompleto, String identificacion, String telefono, String email, String direccion, String genero,
                  long id, double salario, String dependencia, String materia) {
        super(nombreCompleto, identificacion, telefono, email, direccion, genero);
        this.id = id;
        this.salario = salario;
        this.dependencia = dependencia;
        this.materia = materia;
    }

    public void calificar(){
        System.out.println("El profesor " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra calificando.");
    }

    public void prepararClase(){
        System.out.println("El profesor " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra preparando la clase.");
    }

    //Metodos abstractos de la clase "persona"

    @Override
    public void comer() {
        System.out.println("El Profesor " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra comiendo.");
    }

    @Override
    public void descansar() {
        System.out.println("El Profesror" + getNombreCompleto() + " con la id (" + getId() + ") se encuentra descansando.");
    }

    //Metodos de la interfaz "Universidad"
    @Override
    public void obtenerHorario() {
        System.out.println("El profesor" + getNombreCompleto() + " con la id (" + getId() + ") ya posee su horario.");
    }

    @Override
    public void irAClase() {
        System.out.println("El profesor" + getNombreCompleto() + " con la id (" + getId() + ") se encuentra en camino a clase.");
    }

    @Override
    public void obtenerPrograma() {
        System.out.println("El profesor " + getNombreCompleto() + " con la id (" + getId() + ") ya obtuvo su programa.");
    }

    @Override
    public void obtenerPaseParqueadero() {
        System.out.println("El profesor " + getNombreCompleto() + " con la id (" + getId() + ") posee su pase del parqueadero.");
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", salario=" + salario +
                ", dependencia='" + dependencia + '\'' +
                ", materia='" + materia + '\'' +
                '}';
    }

}
