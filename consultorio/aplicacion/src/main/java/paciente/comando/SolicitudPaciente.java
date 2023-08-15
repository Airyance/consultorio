package paciente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudPaciente {

    private String nombre;
    private String apellidos;
    private String direccion;
    private LocalDate fechaNacimiento;
    private long identificacion;
    private long telefono;



}
