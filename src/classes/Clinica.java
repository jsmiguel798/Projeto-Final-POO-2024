package classes;

import java.util.ArrayList;

public class Clinica {
	private String nomeClinica;
	private ArrayList<Paciente> listaPacientes;
	private ArrayList<Medico> listaMedicos;
	private ArrayList<Consulta> listaConsultas;

	public Clinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;

		// criar instancia das lista de médicos, pacientes e consultas.

		this.listaPacientes = new ArrayList<Paciente>();
		this.listaMedicos = new ArrayList<Medico>();
		this.listaConsultas = new ArrayList<Consulta>();

	}

	public String getNomeClinica() {
		return nomeClinica;
	}

	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}

	// adicionar o paciente na lista de paciente na clinica
	public void adicionarPaciente(Paciente paciente) {
		this.listaPacientes.add(paciente);

	}

	// adicionar o medico na lista da clinica
	public void adcionarMedico(Medico medico) {
		this.listaMedicos.add(medico);

	}

	// adicionar a consulta na clinica
	public void adcionarConsulta(Consulta consulta) {
		this.listaConsultas.add(consulta);

	}
}
