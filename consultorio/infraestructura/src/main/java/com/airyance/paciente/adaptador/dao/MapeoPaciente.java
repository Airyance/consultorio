package com.airyance.paciente.adaptador.dao;

import com.airyance.paciente.modelo.DtoPaciente;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoPaciente implements ResultSetExtractor<DtoPaciente> {


    @Override
    public DtoPaciente extractData(ResultSet rs) throws SQLException, DataAccessException {


        if (rs.next()) {

            LocalDate fechaNacimiento = null;

            if (manejoDeFechas(rs)){
                fechaNacimiento = LocalDate.parse(rs.getString("fecha_Nacimiento"));
            }

            return new DtoPaciente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("direccion"),
                    fechaNacimiento,
                    rs.getLong("identificacion"),
                    rs.getLong("telefono"));

        } else {
            return null;
        }
    }

    private boolean manejoDeFechas(ResultSet rs) throws SQLException {

        if (rs.getDate("fecha_Nacimiento")==null){
            return false;
        }
        return true;
    }

}
