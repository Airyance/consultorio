package com.airyance.paciente.adaptador.dao;

import com.airyance.paciente.modelo.DtoPaciente;
import com.airyance.paciente.puerto.dao.DaoPaciente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoOrquestadorPaciente implements DaoPaciente {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private String sqlBucarPorIdentificacion="SELECT id, nombre, apellidos, direccion, fecha_nacimiento, identificacion, telefono\n" +
            "FROM public.pacientes WHERE identificacion = :identificacion ;";

    private String sqlListarPacientes = "SELECT id, nombre, apellidos, direccion, fecha_nacimiento, identificacion, telefono\n " +
            "FROM public.pacientes";
    public DaoOrquestadorPaciente(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DtoPaciente buscarPacientePorIdentificacion(long identificacion) {
        MapSqlParameterSource parametro = new MapSqlParameterSource();
        parametro.addValue("identificacion",identificacion);
        return this.jdbcTemplate.query(sqlBucarPorIdentificacion,parametro,new MapeoPaciente());
    }

    @Override
    public List<DtoPaciente> listarPacientes() {
        return this.jdbcTemplate.query(sqlListarPacientes,new MapeoListarPacientes());
    }
}
