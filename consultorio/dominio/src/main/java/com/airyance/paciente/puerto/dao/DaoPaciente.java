package com.airyance.paciente.puerto.dao;

import com.airyance.paciente.modelo.DtoPaciente;

import java.util.List;

public interface DaoPaciente {

    /**
     * Permite buscar paciente en base a su identificacion
     *
     * @param identificacion
     * @return paciente encontrado.
     */
    DtoPaciente buscarPacientePorIdentificacion (long identificacion);

    /**
     *
     * Permite listar todos los pacientes registrados
     *
     * @return listado de pacientes
     */
    List<DtoPaciente> listarPacientes();
}
