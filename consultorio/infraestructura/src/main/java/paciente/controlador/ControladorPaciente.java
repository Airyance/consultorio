package paciente.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paciente.comando.SolicitudPaciente;
import paciente.manejador.ManejadorCrearPaciente;

@RestController
@RequestMapping("/pacientes")
public class ControladorPaciente {

    private ManejadorCrearPaciente manejadorCrearPaciente;

    public ControladorPaciente(ManejadorCrearPaciente manejadorCrearPaciente) {
        this.manejadorCrearPaciente = manejadorCrearPaciente;
    }

    @PostMapping
    public ResponseEntity<String> crearPacienteNuevo(@RequestBody SolicitudPaciente solicitudPaciente){
        return new ResponseEntity<>(manejadorCrearPaciente.ejecutar(solicitudPaciente),null, HttpStatus.CREATED);
    }


}
