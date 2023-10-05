package com.airyance.paciente.adaptador.dao;

import com.airyance.paciente.modelo.DtoPaciente;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MapeoListarPacientes implements ResultSetExtractor<List<DtoPaciente>> {
    @Override
    public List<DtoPaciente> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<DtoPaciente> listaPacientes = new ArrayList<>();

        while (rs.next()) {
            DtoPaciente paciente = new DtoPaciente();
            LocalDate fechaNacimiento = null;

            if (manejoDeFechas(rs)){
                fechaNacimiento = LocalDate.parse(rs.getString("fecha_Nacimiento"));
            }


            paciente.setId(rs.getInt("id"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setApellidos(rs.getString("apellidos"));
            paciente.setDireccion(rs.getString("direccion"));
            paciente.setFechaNacimiento(fechaNacimiento);
            paciente.setIdentificacion(rs.getLong("identificacion"));
            paciente.setTelefono(rs.getLong("telefono"));

            listaPacientes.add(paciente);
        }

        return listaPacientes;
    }

    private boolean manejoDeFechas(ResultSet rs) throws SQLException {

        if (rs.getDate("fecha_Nacimiento")==null){
            return false;
        }

        return true;
    }
}
