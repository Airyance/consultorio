package paciente.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas-pacientes")
public class ConsultaPaciente {



    @GetMapping
    public ResponseEntity<String> prueba(){
        return new ResponseEntity<>("correcto",null, HttpStatus.CREATED);
    }
}
