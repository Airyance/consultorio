package paciente.fabrica;

import org.springframework.stereotype.Component;
import paciente.comando.SolicitudPaciente;
import paciente.modelo.Paciente;

@Component
public class FabricaPaciente {
    public Paciente ejecutar (SolicitudPaciente solicitudPaciente){

        return new Paciente(solicitudPaciente.getNombre(), solicitudPaciente.getApellidos(),
                solicitudPaciente.getDireccion(), solicitudPaciente.getFechaNacimiento(),
                solicitudPaciente.getIdentificacion(), solicitudPaciente.getIdentificacion());


    }
}
