package consultamedica.dao;

import java.util.ArrayList;

import consultamedica.model.Consulta;

public class ConsultaDAO {
	public void cadastrarConsulta(Consulta consulta) {
		Database.getClinica().getConsultas().add(consulta);
	}
	
	public ArrayList<Consulta> listarConsultas() {
		return Database.getClinica().getConsultas();
	}
	
	public Consulta getConsulta(int linha) {
		return Database.getClinica().getConsultas().get(linha);
	}
	
	public void deletarConsulta(int linha) {
		Database.getClinica().getConsultas().remove(linha);
	}
	
	public void editarConsulta(Consulta consulta, int linha) {
		Database.getClinica().getConsultas().set(linha, consulta);
	}
}
