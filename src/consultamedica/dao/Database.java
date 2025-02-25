package consultamedica.dao;

import consultamedica.model.Clinica;

public class Database {
	private static Clinica clinica;

	public void conectar() {
		this.clinica = new Clinica();
	}

	public static Clinica getClinica() {
		return clinica;
	}

	public static void setClinica(Clinica clinica) {
		Database.clinica = clinica;
	}
}

// nao pode deixar um arrraylist nos DAO
