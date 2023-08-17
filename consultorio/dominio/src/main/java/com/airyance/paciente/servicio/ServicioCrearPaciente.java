package com.airyance.paciente.servicio;

import com.airyance.paciente.modelo.Paciente;
import com.airyance.paciente.puerto.RepositorioPaciente;

public class ServicioCrearPaciente {
    private RepositorioPaciente repositorioPaciente;

    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public String ejecutar(Paciente paciente){

        return String.valueOf(repositorioPaciente.crearPaciente(paciente));
    }

}
