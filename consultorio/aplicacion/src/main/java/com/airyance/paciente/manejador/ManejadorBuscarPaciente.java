package com.airyance.paciente.manejador;

import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.servicio.ServicioBuscarPaciente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorBuscarPaciente {

    private ServicioBuscarPaciente servicioBuscarPaciente;

    public ManejadorBuscarPaciente(ServicioBuscarPaciente servicioBuscarPaciente) {
        this.servicioBuscarPaciente = servicioBuscarPaciente;
    }

    public Optional<DtoPaciente> ejecutar(long identificacion) {

        return servicioBuscarPaciente.ejecutar(identificacion);
    }
}
