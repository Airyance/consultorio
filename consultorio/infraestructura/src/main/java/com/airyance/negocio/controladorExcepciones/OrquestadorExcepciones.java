package com.airyance.negocio.controladorExcepciones;

import com.airyance.negocio.comando.ComandoRespuesta;
import com.airyance.negocio.excepciones.ExcepcionInconsistenciaDatos;
import com.airyance.negocio.excepciones.ExcepcionRegistroExistente;
import com.airyance.negocio.excepciones.ExcepcionSinDatos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrquestadorExcepciones {

    @ExceptionHandler(value = ExcepcionSinDatos.class)
    public ResponseEntity<ComandoRespuesta> excepcionSinDatos (ExcepcionSinDatos excepcionSinDatos){
        ComandoRespuesta respuesta = ComandoRespuesta.builder().mensaje(excepcionSinDatos.getMessage()).build();
        return new ResponseEntity(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ExcepcionRegistroExistente.class)
    public ResponseEntity<ComandoRespuesta> excepcionDatosExistentes (ExcepcionRegistroExistente excepcionRegistroExistente){
        ComandoRespuesta respuesta = ComandoRespuesta.builder().mensaje(excepcionRegistroExistente.getMessage()).build();
        return new ResponseEntity(respuesta, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ExcepcionInconsistenciaDatos.class)
    public ResponseEntity<ComandoRespuesta> excepcionInconsistenciaDatos (ExcepcionInconsistenciaDatos excepcionInconsistenciaDatos){
        ComandoRespuesta respuesta = ComandoRespuesta.builder().mensaje(excepcionInconsistenciaDatos.getMessage()).build();
        return new ResponseEntity(respuesta,HttpStatus.NOT_ACCEPTABLE);
    }


}
