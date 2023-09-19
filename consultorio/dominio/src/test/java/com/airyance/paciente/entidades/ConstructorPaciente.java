package com.airyance.paciente.entidades;

import com.airyance.paciente.modelo.Paciente;

import java.time.LocalDate;

public class ConstructorPaciente {

    private String nombre;
    private String apellidos;
    private String direccion;
    private LocalDate fechaNacimiento;
    private long identificacion;
    private long telefono;

    public ConstructorPaciente() {
        this.nombre = "nombre";
        this.apellidos = "apellidos";
        this.direccion = "direccion";
        this.fechaNacimiento = LocalDate.now();
        this.identificacion = 123456789l;
        this.telefono = 3333333l;
    }

    public ConstructorPaciente conFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
    public Paciente construir(){
        return new Paciente(nombre,apellidos,direccion,fechaNacimiento,identificacion,telefono);
    }

}
