package com.airyance.paciente.puerto.repositorio;

import com.airyance.paciente.modelo.Paciente;

public interface RepositorioPaciente {
    /**
     * Permite crear pacientes nuevos
     *
     * @param paciente
     * @return Long
     */
    Long crearPaciente(Paciente paciente);
}
