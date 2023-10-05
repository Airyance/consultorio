package com.airyance.paciente.servicio;

import com.airyance.negocio.excepciones.ExcepcionInconsistenciaDatos;
import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.modelo.Paciente;
import com.airyance.paciente.puerto.repositorio.RepositorioPaciente;

import java.util.Optional;

public class ServicioActualizarPaciente {

    private static final String LOS_DATOS_SUMINISTRADOS_SON_INCONSISTENTES = "Los datos suministrados son inconsistentes.";
    private ServicioBuscarPaciente servicioBuscarPaciente;
    private RepositorioPaciente repositorioPaciente;

    public ServicioActualizarPaciente(ServicioBuscarPaciente servicioBuscarPaciente, RepositorioPaciente repositorioPaciente) {
        this.servicioBuscarPaciente = servicioBuscarPaciente;
        this.repositorioPaciente = repositorioPaciente;
    }

    public Optional<DtoPaciente> ejecutar(Paciente paciente, int id) {

        try {

            var resultado = obtenerPaciente(paciente);

            if (resultado.isPresent() && resultado.get().getId() == id) {
                repositorioPaciente.actualizarPaciente(paciente, id);
            }else{
                throw new ExcepcionInconsistenciaDatos(LOS_DATOS_SUMINISTRADOS_SON_INCONSISTENTES);
            }

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }

        return obtenerPaciente(paciente);
    }

    private Optional<DtoPaciente> obtenerPaciente(Paciente paciente) {
        return servicioBuscarPaciente.ejecutar(paciente.getIdentificacion());
    }
}
