package consultamedica.model;

public class Paciente {

	private String nome;
	private String CPF;
	private String telefone;
	private String dataNascimento;
	private String historicoMedico;


	public Paciente(String nome, String CPF,String telefone, String dataNascimento, String historicoMedico) {
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.dataNascimento  = dataNascimento;
		this.historicoMedico = historicoMedico;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(String historicoMedico) {
		this.historicoMedico = historicoMedico;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	}


