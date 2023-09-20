package com.airyance.paciente.controlador;

import com.airyance.paciente.manejador.ManejadorBuscarPaciente;
import com.airyance.paciente.manejador.ManejadorListarPacientes;
import com.airyance.paciente.modelo.DtoPaciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class ConsultaPaciente {


    private ManejadorBuscarPaciente manejadorBuscarPaciente;

    private ManejadorListarPacientes manejadorListarPacientes;
    public ConsultaPaciente(ManejadorBuscarPaciente manejadorBuscarPaciente, ManejadorListarPacientes manejadorListarPacientes) {
        this.manejadorBuscarPaciente = manejadorBuscarPaciente;
        this.manejadorListarPacientes = manejadorListarPacientes;
    }

    @GetMapping(value = "/{identificacion}")
    public Optional<DtoPaciente> buscarPacientePorIdentificacion(@PathVariable long identificacion){
        return manejadorBuscarPaciente.ejecutar(identificacion);
    }

    @GetMapping(value = "/")
    public List<DtoPaciente> listarTodosLosPacientes(){
        return manejadorListarPacientes.ejecutar();
    }

}
