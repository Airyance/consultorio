package com.airyance.paciente.puerto.repositorio;

import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.modelo.Paciente;

public interface RepositorioPaciente {
    /**
     * Permite crear pacientes nuevos
     *
     * @param paciente: Objeto paciente a crear
     * @return Long: Cantidad de registros afectados
     */
    Long crearPaciente(Paciente paciente);

    /**
     * Permite actualizar paciente
     *
     * @param paciente : Objeto paciente a actualizar
     * @param id : Id a actualizar
     * @return Long: Cantidad de registros afectados
     */
    Long actualizarPaciente(Paciente paciente,int id);
}
