package consultamedica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import consultamedica.dao.MedicoDAO;
import consultamedica.dao.PacienteDAO;
import consultamedica.model.Medico;
import consultamedica.model.Paciente;

import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;

public class PacienteListar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTelefone;
	private JTextField textFieldNome;
	private JTextField textFieldMedico;
	private JTextField textFieldCPF;
	private JTextField textFieldNascimento;
	private JTable table;
	private DefaultTableModel modelo; // duvida sobre isso
	private JButton btnFinalizarEdição;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnAgendarConsulta;
	private JButton btnCadastrarPaciente;

	public PacienteListar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 524);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Dados do Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 10, 867, 174);
		contentPane.add(panel);
		panel.setLayout(null);

		Label Nome = new Label("Nome*:");
		Nome.setBounds(10, 20, 59, 23);
		panel.add(Nome);
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(172, 24, 307, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		Label labelCPF = new Label("CPF* :");
		labelCPF.setBounds(503, 22, 52, 21);
		panel.add(labelCPF);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCPF.setBackground(UIManager.getColor("Button.background"));

		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(588, 24, 235, 19);
		panel.add(textFieldCPF);
		textFieldCPF.setColumns(10);

		Label labelTelefone = new Label("Telefone*:");
		labelTelefone.setBounds(503, 60, 79, 21);
		panel.add(labelTelefone);
		labelTelefone.setBackground(UIManager.getColor("Button.background"));
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(588, 60, 235, 21);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		Label labelHistorico = new Label("Hisórico Médico*:");
		labelHistorico.setBounds(10, 96, 130, 21);
		panel.add(labelHistorico);
		labelHistorico.setFont(new Font("Tahoma", Font.PLAIN, 13));

		Label labelDataDeNascimento = new Label("Data De Nascimento*:");
		labelDataDeNascimento.setBounds(10, 60, 160, 21);
		panel.add(labelDataDeNascimento);
		labelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldNascimento = new JTextField();
		textFieldNascimento.setBounds(172, 60, 307, 21);
		panel.add(textFieldNascimento);
		textFieldNascimento.setColumns(10);

		textFieldMedico = new JTextField();
		textFieldMedico.setBounds(172, 98, 307, 19);
		panel.add(textFieldMedico);
		textFieldMedico.setColumns(10);

		btnCadastrarPaciente = new JButton("Cadastrar ");
		btnCadastrarPaciente.setForeground(Color.BLACK);
		btnCadastrarPaciente.setBounds(611, 127, 212, 37);
		panel.add(btnCadastrarPaciente);
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String CPF = textFieldCPF.getText();
				String telefone = textFieldTelefone.getText();
				String dataNascimento = textFieldNascimento.getText();
				String historicoMedico = textFieldMedico.getText();

				if (nome.isBlank() || CPF.isBlank() || telefone.isBlank() || dataNascimento.isBlank()
						|| historicoMedico.isBlank()) {
					// isBlank() verifica se a string é vazia

					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Criar um objeto da classe medico
					Paciente paciente = new Paciente(nome, CPF, telefone, dataNascimento, historicoMedico);

					// Adicionar o novo médico ao DAO
					PacienteDAO.create(paciente);

					// recarregar a tabela
					carregarLinhasDaTabela();

					// Limpar os campos depois que cadastrar
					textFieldNome.setText("");
					textFieldCPF.setText("");
					textFieldTelefone.setText("");
					textFieldNascimento.setText("");
					textFieldMedico.setText("");

				}
			}
		});
		//btnCadastrarPaciente.setBackground(SystemColor.activeCaption);
		btnCadastrarPaciente.setFont(new Font("Tahoma", Font.BOLD, 10));

		btnFinalizarEdição = new JButton("Finalizar Edição");
		btnFinalizarEdição.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();

				// pegar os valores editados
				String nome = textFieldNome.getText();
				String CPF = textFieldCPF.getText();
				String telefone = textFieldTelefone.getText();
				String dataNascimento = textFieldNascimento.getText();
				String historicoMedico = textFieldMedico.getText();

				if (nome.isBlank() || CPF.isBlank() || telefone.isBlank() || dataNascimento.isBlank()
						|| historicoMedico.isBlank()) {
					// isBlank() verifica se a string é vazia

					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					// Criar um objeto da classe paciente
					Paciente paciente = new Paciente(nome, CPF, telefone, dataNascimento, historicoMedico);

					// atualizar o novo paciente ao DAO
					PacienteDAO.update(paciente, linhaSelecionada);

					// recarregar a tabela
					carregarLinhasDaTabela();

					// ativar botões
					btnCadastrarPaciente.setEnabled(true);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnAgendarConsulta.setEnabled(true);
					table.setEnabled(true);

					// desativar botão de finalizar Edição
					btnFinalizarEdição.setEnabled(false);

					// limpar os campos depois que editar
					textFieldNome.setText("");
					textFieldCPF.setText("");
					textFieldTelefone.setText("");
					textFieldNascimento.setText("");
					textFieldMedico.setText("");
				}
			}
		});
		btnFinalizarEdição.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFinalizarEdição.setBounds(396, 127, 186, 35);
		panel.add(btnFinalizarEdição);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dados do Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 200, 867, 255);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 847, 189);
		panel_1.add(scrollPane);

		this.modelo = new DefaultTableModel() {
			@Override // nao deixar alterar a tabela
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Adicionando colunas da tabela
		this.modelo.addColumn("Nome");
		this.modelo.addColumn("CPF");
		this.modelo.addColumn("Telefone");
		this.modelo.addColumn("Data De Nascimento");
		this.modelo.addColumn("Histórico Médico");

		// Adicionando as linhas da tabela
		carregarLinhasDaTabela();

		// Criando a tabela, adicionando o modelo
		this.table = new JTable(this.modelo);
		// selecionar apenas uma linha de cada vez
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);

		btnAgendarConsulta = new JButton("Agendar Consulta");
		btnAgendarConsulta.setBounds(10, 220, 168, 25);
		panel_1.add(btnAgendarConsulta);
		//btnAgendarConsulta.setBackground(new Color(220, 220, 220));
		btnAgendarConsulta.setFont(new Font("Tahoma", Font.BOLD, 10));

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(235, 220, 168, 25);
		panel_1.add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(469, 220, 168, 25);
		panel_1.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();

				if (linhaSelecionada >= 0) {// ver se tem linha selecionada na tabela
					// Apagar Da Listagem a linha Selecionada
					PacienteDAO.delete(linhaSelecionada);
					// atualizar a tabela
					carregarLinhasDaTabela();
				}
			}
		});

		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {// ver se tem linha selecionada na tabela
					Paciente pacienteSelecionado = PacienteDAO.getPaciente(linhaSelecionada);
					String nome = pacienteSelecionado.getNome();
					textFieldNome.setText(nome);
					String cpf = pacienteSelecionado.getCPF();
					textFieldCPF.setText(cpf);
					String telefone = pacienteSelecionado.getTelefone();
					textFieldTelefone.setText(telefone);
					String dataNascimento = pacienteSelecionado.getDataNascimento();
					textFieldNascimento.setText(dataNascimento);
					String historicoMedico = pacienteSelecionado.getHistoricoMedico();
					textFieldMedico.setText(historicoMedico);

					// Desativar Botôes
					btnCadastrarPaciente.setEnabled(false);
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
					btnAgendarConsulta.setEnabled(false);
					table.setEnabled(false);
					// atiavar botão de finalizar Edição
					btnFinalizarEdição.setEnabled(true);

				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 10));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(698, 220, 140, 25);
		panel_1.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinica voltar = new Clinica();
				voltar.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));

		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 10));

		btnAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarConsulta nm = new CadastrarConsulta();
				nm.setVisible(true);
				dispose();

			}
		});

	}

	private void carregarLinhasDaTabela() {
		// zerar os dados da tabela
		this.modelo.setRowCount(0);
		// Adicionando os paciente na tabela
		ArrayList<Paciente> pacientes = PacienteDAO.list(); // Puxando os Paciente do DAO
		for (int i = 0; i < pacientes.size(); i++) { // Jogando a lista de médicos no modelo da tabela
			Paciente m = pacientes.get(i);
			this.modelo.addRow(new Object[] { m.getNome(), m.getCPF(), m.getTelefone(), m.getDataNascimento(),
					m.getHistoricoMedico() });
		}
	}
}
