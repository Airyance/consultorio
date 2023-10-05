package com.airyance.paciente.controlador;

import com.airyance.paciente.comando.SolicitudPaciente;
import com.airyance.paciente.manejador.ManejadorActualizarPaciente;
import com.airyance.paciente.manejador.ManejadorCrearPaciente;
import com.airyance.paciente.modelo.DtoPaciente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/pacientes")
public class ControladorPaciente {

    private ManejadorCrearPaciente manejadorCrearPaciente;
    private ManejadorActualizarPaciente manejadorActualizarPaciente;


    @PostMapping
    public ResponseEntity<String> crearPacienteNuevo(@RequestBody SolicitudPaciente solicitudPaciente){
        return new ResponseEntity<>(manejadorCrearPaciente.ejecutar(solicitudPaciente),null, HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar/{id}")
    public Optional<DtoPaciente> actualizarPaciente(@RequestBody SolicitudPaciente solicitudPaciente,
                                                    @PathVariable int id){
        return manejadorActualizarPaciente.ejecutar(solicitudPaciente,id);
    }
}
