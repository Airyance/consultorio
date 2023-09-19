package com.airyance.paciente.servicio;

import com.airyance.negocio.excepciones.ExcepcionRegistroExistente;
import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.modelo.Paciente;
import com.airyance.paciente.puerto.dao.DaoPaciente;
import com.airyance.paciente.puerto.repositorio.RepositorioPaciente;

import java.util.Optional;

public class ServicioCrearPaciente {
    private static final String YA_EXISTE_UN_USUARIO_CON_ESA_IDENTIFICACION = "Ya existe un usuario con esa identificacion.";
    private RepositorioPaciente repositorioPaciente;
    private DaoPaciente daoPaciente;

    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente,DaoPaciente daoPaciente) {
        this.repositorioPaciente = repositorioPaciente;
        this.daoPaciente = daoPaciente;
    }

    public String ejecutar(Paciente paciente){

        var registrosPrevios = Optional.ofNullable(daoPaciente.buscarPacientePorIdentificacion(paciente.getIdentificacion()));

        if (registrosPrevios.isPresent()){
            throw new ExcepcionRegistroExistente(YA_EXISTE_UN_USUARIO_CON_ESA_IDENTIFICACION);
        }
        return String.valueOf(repositorioPaciente.crearPaciente(paciente));
    }

}
