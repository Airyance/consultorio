package com.airyance.paciente.servicio;

import com.airyance.paciente.entidades.ConstructorPaciente;
import com.airyance.paciente.modelo.Paciente;
import com.airyance.paciente.puerto.dao.DaoPaciente;
import com.airyance.paciente.puerto.repositorio.RepositorioPaciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ServicioCrearPacienteTest {

    @Mock
    private RepositorioPaciente repositorioPaciente;
    @Mock
    private DaoPaciente daoPaciente;

    @InjectMocks
    private ServicioCrearPaciente servicioCrearPaciente;

    @Captor
    private ArgumentCaptor<Paciente> captorPaciente;


    @BeforeEach
    void configuracion(){
        initMocks(this);
    }

    @Test
    void debeCrearCorrectamente(){

        LocalDate  fecha = LocalDate.of(2023,9,18);
        var paciente = new ConstructorPaciente().conFechaNacimiento(fecha).construir();
        when(daoPaciente.buscarPacientePorIdentificacion(anyLong())).thenReturn(null);

        var registro = servicioCrearPaciente.ejecutar(paciente);

        verify(daoPaciente).buscarPacientePorIdentificacion(anyLong());
        verify(repositorioPaciente).crearPaciente(any(Paciente.class));
        assertEquals("0",registro);
    }

}
