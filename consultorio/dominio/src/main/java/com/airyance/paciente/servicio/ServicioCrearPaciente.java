package com.airyance.paciente.servicio;

import com.airyance.negocio.excepciones.ExcepcionRegistroExistente;
import com.airyance.paciente.modelo.Paciente;
import com.airyance.paciente.puerto.dao.DaoPaciente;
import com.airyance.paciente.puerto.repositorio.RepositorioPaciente;

import java.util.Optional;

public class ServicioCrearPaciente {
    private static final String YA_EXISTE_UN_USUARIO_CON_ESA_IDENTIFICACION = "Ya existe un usuario con esa identificacion.";
    private static final String HA_CREADO_EXITOSAMENTE_EL_REGISTRO_PARA = "Se ha creado exitosamente el registro para: %1s paciente.";
    private static final String NO_FUE_POSIBLE_CREAR_EL_PACIENTE_POR_FAVOR_CONTACTE_AL_ADMINISTRADOR = "No fue posible crear el paciente, por favor contacte al administrador.";
    private RepositorioPaciente repositorioPaciente;
    private DaoPaciente daoPaciente;

    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente, DaoPaciente daoPaciente) {
        this.repositorioPaciente = repositorioPaciente;
        this.daoPaciente = daoPaciente;
    }

    public String ejecutar(Paciente paciente) {

        try {
            var registrosPrevios = Optional.ofNullable(daoPaciente.buscarPacientePorIdentificacion(paciente.getIdentificacion()));

            if (registrosPrevios.isPresent()) {
                throw new ExcepcionRegistroExistente(YA_EXISTE_UN_USUARIO_CON_ESA_IDENTIFICACION);
            }
            return creacionPaciente(paciente);

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }
    }

    private String creacionPaciente(Paciente paciente) {

        var registroCreado = repositorioPaciente.crearPaciente(paciente);

        String resultado = NO_FUE_POSIBLE_CREAR_EL_PACIENTE_POR_FAVOR_CONTACTE_AL_ADMINISTRADOR;

        if (registroCreado > 0) {
            resultado = String.format(HA_CREADO_EXITOSAMENTE_EL_REGISTRO_PARA, registroCreado);
        }

        return resultado;
    }

}
