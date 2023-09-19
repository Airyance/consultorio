package com.airyance.paciente.manejador;

import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.servicio.ServicioListarPacientes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManejadorListarPacientes {

    private ServicioListarPacientes servicioListarPacientes;

    public ManejadorListarPacientes(ServicioListarPacientes servicioListarPacientes) {
        this.servicioListarPacientes = servicioListarPacientes;
    }

    public List<DtoPaciente> ejecutar(){
        return servicioListarPacientes.ejecutar();
    }
}
