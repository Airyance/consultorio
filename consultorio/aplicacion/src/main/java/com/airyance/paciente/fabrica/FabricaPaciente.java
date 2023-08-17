package com.airyance.paciente.fabrica;

import com.airyance.paciente.comando.SolicitudPaciente;
import com.airyance.paciente.modelo.Paciente;
import org.springframework.stereotype.Component;

@Component
public class FabricaPaciente {

    public Paciente ejecutar (SolicitudPaciente solicitudPaciente){

        return new Paciente(solicitudPaciente.getNombre(), solicitudPaciente.getApellidos(),
                solicitudPaciente.getDireccion(), solicitudPaciente.getFechaNacimiento(),
                solicitudPaciente.getIdentificacion(), solicitudPaciente.getIdentificacion());

    }

}
