package paciente.manejador;

import org.springframework.stereotype.Component;
import paciente.comando.SolicitudPaciente;
import paciente.fabrica.FabricaPaciente;
import paciente.servicio.ServicioCrearPaciente;

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
