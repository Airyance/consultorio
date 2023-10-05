package com.airyance.paciente.servicio;

import com.airyance.negocio.excepciones.ExcepcionRegistroExistente;
import com.airyance.paciente.entidades.ConstructorDtoPaciente;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ServicioCrearPacienteTest {

    private static final String NO_FUE_POSIBLE_CREAR_EL_PACIENTE_POR_FAVOR_CONTACTE_AL_ADMINISTRADOR = "No fue posible crear el paciente, por favor contacte al administrador.";
    private static final String REGISTRO_PARA_1_PACIENTE = "Se ha creado exitosamente el registro para: 1 paciente.";
    private static final String YA_EXISTE_UN_USUARIO_CON_ESA_IDENTIFICACION = "Ya existe un usuario con esa identificacion.";
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
    void noDebeCrearCorrectamente(){

        LocalDate  fecha = LocalDate.of(2023,9,18);
        var paciente = new ConstructorPaciente().conFechaNacimiento(fecha).construir();
        when(daoPaciente.buscarPacientePorIdentificacion(anyLong())).thenReturn(null);

        var registro = servicioCrearPaciente.ejecutar(paciente);

        verify(daoPaciente).buscarPacientePorIdentificacion(anyLong());
        verify(repositorioPaciente).crearPaciente(any(Paciente.class));
        assertEquals(NO_FUE_POSIBLE_CREAR_EL_PACIENTE_POR_FAVOR_CONTACTE_AL_ADMINISTRADOR,registro);
    }

    @Test
    void debeCrearCorrectamente(){

        LocalDate  fecha = LocalDate.of(2023,9,18);
        var paciente = new ConstructorPaciente().conFechaNacimiento(fecha).construir();
        when(daoPaciente.buscarPacientePorIdentificacion(anyLong())).thenReturn(null);
        when(repositorioPaciente.crearPaciente(any(Paciente.class))).thenReturn(1l);

        var registro = servicioCrearPaciente.ejecutar(paciente);

        verify(daoPaciente).buscarPacientePorIdentificacion(anyLong());
        verify(repositorioPaciente).crearPaciente(captorPaciente.capture());
        assertEquals(REGISTRO_PARA_1_PACIENTE,registro);
        assertEquals(paciente.getNombre(),captorPaciente.getValue().getNombre());
    }

    @Test
    void debeLanzarExcepcion() throws ExcepcionRegistroExistente {

        var paciente = new ConstructorPaciente().construir();
        var dtoPaciente = new ConstructorDtoPaciente().conNombre("dtoUsuario").construir();
        when(daoPaciente.buscarPacientePorIdentificacion(anyLong())).thenReturn(dtoPaciente);

        var registro = assertThrows(RuntimeException.class,()-> servicioCrearPaciente.ejecutar(paciente));

        verify(daoPaciente).buscarPacientePorIdentificacion(anyLong());
        assertEquals(YA_EXISTE_UN_USUARIO_CON_ESA_IDENTIFICACION,registro.getMessage());
    }


}
