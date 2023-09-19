package com.airyance.negocio.controladorExcepciones;

import com.airyance.negocio.comando.ComandoRespuesta;
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


}
