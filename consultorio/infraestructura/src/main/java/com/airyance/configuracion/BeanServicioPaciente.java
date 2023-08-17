package com.airyance.configuracion;

import com.airyance.paciente.puerto.RepositorioPaciente;
import com.airyance.paciente.servicio.ServicioCrearPaciente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPaciente {

    @Bean
    public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioPaciente){
        return new ServicioCrearPaciente(repositorioPaciente);
    }

}
