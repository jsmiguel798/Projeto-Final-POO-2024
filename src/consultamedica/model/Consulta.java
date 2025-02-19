package consultamedica.model;

public class Consulta {

	private Paciente paciente;
	private Medico medico;
	private String data;
	private String horario;
	private String diagnostico;

	public Consulta(Paciente paciente, Medico medico, String data, String horario, String diagnostico) {
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
		this.horario = horario;
		this.diagnostico = diagnostico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
}
