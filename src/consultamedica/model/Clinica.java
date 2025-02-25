package consultamedica.model;

import java.util.ArrayList;

public class Clinica {
	private String nomeClinica;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Consulta> listaConsultas;

	public Clinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;

		// criar instancia das lista de medicos, pacientes e consultas.

		this.pacientes = new ArrayList<Paciente>();
		this.medicos = new ArrayList<Medico>();
		this.listaConsultas = new ArrayList<Consulta>();
	}
	public Clinica() {
		this.pacientes = new ArrayList<Paciente>();
		this.medicos = new ArrayList<Medico>();
	}

	public String getNomeClinica() {
		return nomeClinica;
	}

	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
	
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	
	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public ArrayList<Medico> getMedicos() {
		return medicos;
	}
	
	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}
	
}
