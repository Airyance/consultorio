package com.airyance.paciente.entidades;

import com.airyance.paciente.modelo.DtoPaciente;

import java.time.LocalDate;

public class ConstructorDtoPaciente {

    private int id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private LocalDate fechaNacimiento;
    private long identificacion;
    private long telefono;

    public ConstructorDtoPaciente() {
        this.id = 1;
        this.nombre = "Usuario";
        this.apellidos = "apellidos";
        this.direccion = "direccion";
        this.fechaNacimiento = LocalDate.of(2023,10,4);
        this.identificacion = 123456789l;
        this.telefono = 3333333333l;
    }

    public ConstructorDtoPaciente conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public DtoPaciente construir(){
        return new DtoPaciente(id,nombre,apellidos,direccion,fechaNacimiento,identificacion,telefono);
    }

}
