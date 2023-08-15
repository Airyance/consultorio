package paciente.adaptador.repositorio;

import org.springframework.stereotype.Repository;
import paciente.modelo.Paciente;
import paciente.puerto.RepositorioPaciente;
@Repository
public class RepositorioOrquestadorPaciente implements RepositorioPaciente {
    @Override
    public Long crearPaciente(Paciente paciente) {
        return 1l;
    }
}
