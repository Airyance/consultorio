package paciente.puerto;

import paciente.modelo.Paciente;

public interface RepositorioPaciente {

    /**
     * Permite crear pacientes nuevos
     *
     * @param paciente
     * @return Long
     */
    Long crearPaciente(Paciente paciente);
}
