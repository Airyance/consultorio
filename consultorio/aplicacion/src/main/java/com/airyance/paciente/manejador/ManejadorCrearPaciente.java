package com.airyance.paciente.manejador;

import com.airyance.paciente.comando.SolicitudPaciente;
import com.airyance.paciente.fabrica.FabricaPaciente;
import com.airyance.paciente.servicio.ServicioCrearPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPaciente {

    private FabricaPaciente fabricaPaciente;
    private ServicioCrearPaciente servicioCrearPaciente;

    public ManejadorCrearPaciente(FabricaPaciente fabricaPaciente, ServicioCrearPaciente servicioCrearPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioCrearPaciente = servicioCrearPaciente;
    }

    public String ejecutar(SolicitudPaciente solicitudPaciente){

        return servicioCrearPaciente.ejecutar(fabricaPaciente.ejecutar(solicitudPaciente));
    }
}
