package consultamedica.dao;

import java.util.ArrayList;
import consultamedica.model.*;

public class PacienteDAO {
	private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

	public static void create(Paciente paciente) {
		pacientes.add(paciente);
	}

	public static ArrayList<Paciente> list() {
		return pacientes;
	}

	public static void delete(int linha) {
		pacientes.remove(linha);
	}

	public static Paciente getPaciente(int linha) {
		return pacientes.get(linha);
	}
	//

		public static void update(Paciente paciente, int linha) {
			pacientes.set(linha, paciente);
	}
}
