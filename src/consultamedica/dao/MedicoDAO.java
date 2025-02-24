package consultamedica.dao;

import java.util.ArrayList;
import consultamedica.model.*;

public class MedicoDAO {
	private static ArrayList<Medico> medicos = new ArrayList<Medico>();
	
	public static void create(Medico medico) {
		medicos.add(medico);
	}
	
	public static ArrayList<Medico> list() {
		return medicos;
	}
	public static void delete(int linha) {
		medicos.remove(linha);
	}
}
