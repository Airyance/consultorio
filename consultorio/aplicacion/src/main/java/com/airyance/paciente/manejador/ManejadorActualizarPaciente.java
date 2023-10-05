package com.airyance.paciente.manejador;

import com.airyance.paciente.comando.SolicitudPaciente;
import com.airyance.paciente.fabrica.FabricaPaciente;
import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.servicio.ServicioActualizarPaciente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorActualizarPaciente {

    private FabricaPaciente fabricaPaciente;
    private ServicioActualizarPaciente servicioActualizarPaciente;

    public ManejadorActualizarPaciente(FabricaPaciente fabricaPaciente, ServicioActualizarPaciente servicioActualizarPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioActualizarPaciente = servicioActualizarPaciente;
    }

    public Optional<DtoPaciente> ejecutar(SolicitudPaciente solicitudPaciente, int id){

        return servicioActualizarPaciente.ejecutar(fabricaPaciente.ejecutar(solicitudPaciente),id) ;
    }


}
