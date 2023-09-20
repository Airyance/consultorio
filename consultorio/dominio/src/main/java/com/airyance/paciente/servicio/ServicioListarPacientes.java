package com.airyance.paciente.servicio;

import com.airyance.negocio.excepciones.ExcepcionSinDatos;
import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.puerto.dao.DaoPaciente;

import java.util.List;

public class ServicioListarPacientes {

    private static final String NO_SE_HAN_ENCONTRADO_PACIENTES_REGISTRADOS = "No se han encontrado pacientes registrados.";
    private DaoPaciente daoPaciente;

    public ServicioListarPacientes(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public List<DtoPaciente> ejecutar() {

        try {

            var pacientes = daoPaciente.listarPacientes();

            if (pacientes.isEmpty()) {

                throw new ExcepcionSinDatos(NO_SE_HAN_ENCONTRADO_PACIENTES_REGISTRADOS);
            }
            return pacientes;

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }
    }
}
