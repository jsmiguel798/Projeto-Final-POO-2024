package consultamedica.dao;

import java.util.ArrayList;
import consultamedica.model.*;

public class MedicoDAO {
	public void cadastrarMedico(Medico medico) {
		Database.getClinica().getMedicos().add(medico);
	}
	
	public ArrayList<Medico> listarMedicos() {
		return Database.getClinica().getMedicos();
	}
	
	public Medico getMedico(int linha) {
		return Database.getClinica().getMedicos().get(linha);
	}
	
	public void deletarMedico(int linha) {
		Database.getClinica().getMedicos().remove(linha);
	}
	
	public void editarMedico(Medico medico, int linha) {
		Database.getClinica().getMedicos().set(linha, medico);
	}
}
