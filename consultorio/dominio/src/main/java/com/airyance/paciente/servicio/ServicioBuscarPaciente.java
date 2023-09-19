package com.airyance.paciente.servicio;

import com.airyance.negocio.excepciones.ExcepcionSinDatos;
import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.puerto.dao.DaoPaciente;

import java.util.Optional;

public class ServicioBuscarPaciente {

    private static final String NO_SE_HA_ENCONTRADO_PACIENTE_CON_ESA_IDENTIFICACION = "No se ha encontrado paciente con esa identificación.";
    private DaoPaciente daoPaciente;

    public ServicioBuscarPaciente(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public Optional<DtoPaciente> ejecutar(long identificacion) {

        try {

            Optional<DtoPaciente> paciente = Optional.ofNullable(daoPaciente.buscarPacientePorIdentificacion(identificacion));

            if (!paciente.isPresent()) {
                throw new ExcepcionSinDatos(NO_SE_HA_ENCONTRADO_PACIENTE_CON_ESA_IDENTIFICACION);
            }

            return paciente;

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }

    }
}
