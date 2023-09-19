package com.airyance.configuracion;

import com.airyance.paciente.puerto.dao.DaoPaciente;
import com.airyance.paciente.puerto.repositorio.RepositorioPaciente;
import com.airyance.paciente.servicio.ServicioBuscarPaciente;
import com.airyance.paciente.servicio.ServicioCrearPaciente;
import com.airyance.paciente.servicio.ServicioListarPacientes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPaciente {

    @Bean
    public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioPaciente, DaoPaciente daoPaciente){
        return new ServicioCrearPaciente(repositorioPaciente,daoPaciente);
    }
    @Bean
    public ServicioBuscarPaciente servicioBuscarPaciente(DaoPaciente daoPaciente){
        return new ServicioBuscarPaciente(daoPaciente);
    }

    @Bean
    public ServicioListarPacientes servicioListarPacientes(DaoPaciente daoPaciente){
        return new ServicioListarPacientes(daoPaciente);
    }

}
