package com.airyance.paciente.modelo;

import java.time.LocalDate;

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

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public long getTelefono() {
        return telefono;
    }
}
