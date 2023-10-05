package com.airyance.negocio.excepciones;

import lombok.Data;

@Data
public class ExcepcionInconsistenciaDatos extends RuntimeException{

    public ExcepcionInconsistenciaDatos(String message) {
        super(message);
    }
}
