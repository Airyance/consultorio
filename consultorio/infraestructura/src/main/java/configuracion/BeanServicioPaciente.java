package configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import paciente.puerto.RepositorioPaciente;
import paciente.servicio.ServicioCrearPaciente;

@Configuration
public class BeanServicioPaciente {

    @Bean
    public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioPaciente){
        return new ServicioCrearPaciente(repositorioPaciente);
    }

}
