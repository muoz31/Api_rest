package com.onesystem.pruebatecnica.prueba.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Persona {
    private String nombreCompleto;
    private String identificacion;
    private String telefono;
    private String email;
    private String direccion;
    private String genero;

    public Persona(String nombreCompleto,String identificacion,String telefono,String email,String direccion,String genero) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.genero = genero;
    }



    public abstract void comer();
    public abstract void descansar();

    @Override
    public String toString() {
        return "Persona{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
