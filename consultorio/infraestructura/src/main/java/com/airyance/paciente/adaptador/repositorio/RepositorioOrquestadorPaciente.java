package com.airyance.paciente.adaptador.repositorio;

import com.airyance.paciente.modelo.Paciente;
import com.airyance.paciente.puerto.RepositorioPaciente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioOrquestadorPaciente implements RepositorioPaciente {

    private String SQL_CREAR_PACIENTE= "INSERT INTO pacientes (nombre, apellidos, direccion, fecha_nacimiento, identificacion, " +
            "telefono) VALUES (:nombre, :apellidos, :direccion, :fechaNacimiento, :identificacion, :telefono);";
    private final NamedParameterJdbcTemplate jdbcTemplate;


    public RepositorioOrquestadorPaciente(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crearPaciente(Paciente paciente) {

        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("nombre",paciente.getNombre());
        parametros.addValue("apellidos",paciente.getApellidos());
        parametros.addValue("direccion",paciente.getDireccion());
        parametros.addValue("fechaNacimiento",paciente.getFechaNacimiento());
        parametros.addValue("identificacion",paciente.getIdentificacion());
        parametros.addValue("telefono",paciente.getTelefono());

        return (long) jdbcTemplate.update(SQL_CREAR_PACIENTE,parametros);
    }

}
