package com.airyance.paciente.puerto.dao;

import com.airyance.paciente.modelo.DtoPaciente;

public interface DaoPaciente {

    /**
     * Permite buscar paciente en base a su identificacion
     *
     * @param identificacion
     * @return paciente encontrado.
     */
    DtoPaciente buscarPacientePorIdentificacion (long identificacion);
}
