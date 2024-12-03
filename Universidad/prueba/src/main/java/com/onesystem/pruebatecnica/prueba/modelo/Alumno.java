package com.onesystem.pruebatecnica.prueba.modelo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Alumno extends Persona implements Universidad {

    //se crea nueva variable para identificar al alumno
    private Long id;
    private String numeroMatricula;
    private String programa;
    private Double notaPromedio;




    public Alumno(String nombreCompleto, String identificacion, String telefono, String email, String direccion, String genero,
                  long id, String numeroMatricula, String programa, double notaPromedio) {
        super(nombreCompleto, identificacion, telefono, email, direccion, genero);
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.programa = programa;
        this.notaPromedio = notaPromedio;
    }

    public void estudiar(){
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra estudiando.");
    }

    // Métodos abstractos para un "alumno"
    @Override
    public void comer() {
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra comiendo.");
    }

    @Override
    public void descansar() {
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra descansando.");
    }

    //Metodos de la interfaz "Universidad"

    @Override
    public void obtenerHorario() {
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") ya posee su horario.");
    }

    @Override
    public void irAClase() {
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") se encuentra en camino a clase.");
    }

    @Override
    public void obtenerPrograma() {
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") ya obtuvo su programa.");
    }

    @Override
    public void obtenerPaseParqueadero() {
        System.out.println("El alumno " + getNombreCompleto() + " con la id (" + getId() + ") posee su pase del parqueadero.");
    }

    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", programa='" + programa + '\'' +
                ", notaPromedio=" + notaPromedio +
                '}';
    }

}
