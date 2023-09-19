package com.airyance.negocio.excepciones;

import lombok.Data;

@Data
public class ExcepcionRegistroExistente extends RuntimeException {

    public ExcepcionRegistroExistente(String message) {
        super(message);
    }
}
