package paciente.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Paciente {

    private String nombre;
    private String apellidos;
    private String direccion;
    private LocalDate fechaNacimiento;
    private long identificacion;
    private long telefono;

    public Paciente(String nombre, String apellidos, String direccion, LocalDate fechaNacimiento,
                    long identificacion, long telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public Paciente(String nombre, String apellidos, long identificacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

}
