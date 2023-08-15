package paciente.servicio;

import paciente.modelo.Paciente;
import paciente.puerto.RepositorioPaciente;

public class ServicioCrearPaciente {

    private RepositorioPaciente repositorioPaciente;

    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public String ejecutar(Paciente paciente){

        return String.valueOf(repositorioPaciente.crearPaciente(paciente));
    }

}
