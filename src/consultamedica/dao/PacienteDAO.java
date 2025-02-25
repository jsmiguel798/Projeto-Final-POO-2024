package consultamedica.dao;

import java.util.ArrayList;
import consultamedica.model.*;

public class PacienteDAO {
	public void cadastrarPaciente(Paciente paciente) {
		Database.getClinica().getPacientes().add(paciente);
	}
	
	public ArrayList<Paciente> listarPacientes() {
		return Database.getClinica().getPacientes();
	}
	
	public Paciente getPaciente(int linha) {
		return Database.getClinica().getPacientes().get(linha);
	}
	
	public void deletarPaciente(int linha) {
		Database.getClinica().getPacientes().remove(linha);
	}
	
	public void editarPaciente(Paciente paciente, int linha) {
		Database.getClinica().getPacientes().set(linha, paciente);
	}
}
