package com.airyance.paciente.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DtoPaciente {

    private int id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private LocalDate fechaNacimiento;
    private long identificacion;
    private long telefono;

    public DtoPaciente(int id, String nombre, String apellidos, String direccion, LocalDate fechaNacimiento, long identificacion, long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

}
