package com.airyance.negocio.excepciones;

import lombok.Data;
@Data
public class ExcepcionSinDatos extends RuntimeException{

    public ExcepcionSinDatos(String message) {
        super(message);
    }
}
