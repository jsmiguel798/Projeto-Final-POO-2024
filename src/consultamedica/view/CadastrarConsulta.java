package consultamedica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import consultamedica.dao.*;
import consultamedica.model.Consulta;
import consultamedica.model.Medico;
import consultamedica.model.Paciente;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;

public class CadastrarConsulta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField textFieldData;
	private JTextField textFieldHorario;
	private JTextField textFieldDiagnostico;
	private JComboBox cbPaciente;
	private JComboBox cbMedico;
	private JButton btnFedicao;
	private JButton btnCancelar;
	private JButton btnAgendar;
	private JButton btnEditar;
	private JButton btnVoltar;
	
	private MedicoDAO medicoDAO;
	private PacienteDAO pacienteDAO;
	private ConsultaDAO consultaDAO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarConsulta frame = new CadastrarConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarConsulta() {
		// construtor do DAO
		this.medicoDAO = new MedicoDAO();
		this.pacienteDAO = new PacienteDAO();
		this.consultaDAO = new ConsultaDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 922, 225);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Cadastro da Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Paciente*:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 28, 94, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Médico*:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(461, 30, 94, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data*:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 71, 45, 13);
		panel.add(lblNewLabel_2);

		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(115, 69, 300, 19);
		panel.add(textFieldData);

		JLabel lblNewLabel_3 = new JLabel("Horário*:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(461, 72, 94, 13);
		panel.add(lblNewLabel_3);

		textFieldHorario = new JTextField();
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(565, 69, 300, 19);
		panel.add(textFieldHorario);

		JLabel lblNewLabel_4 = new JLabel("Diagnóstico*:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 110, 94, 17);
		panel.add(lblNewLabel_4);

		btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(705, 175, 160, 27);
		panel.add(btnAgendar);
		btnAgendar.setFont(new Font("Tahoma", Font.BOLD, 10));

		cbPaciente = new JComboBox();
		this.comboBoxPacientes(); //colocar pacientes na combobox
		cbPaciente.setBounds(114, 27, 301, 21);
		panel.add(cbPaciente);
		

		textFieldDiagnostico = new JTextField();
		textFieldDiagnostico.setBounds(115, 108, 300, 19);
		panel.add(textFieldDiagnostico);
		textFieldDiagnostico.setColumns(10);

		cbMedico = new JComboBox();
		this.comboBoxMedicos(); // colocar os medicos na combobox
		cbMedico.setBounds(564, 27, 301, 21);
		panel.add(cbMedico);
		
		btnFedicao = new JButton("Finalizar Edição");
		btnFedicao.setEnabled(false);
		btnFedicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();

				// pegar os valores editados
				String data = textFieldData.getText();
				String diagnostico = textFieldDiagnostico.getText();
				String horario = textFieldHorario.getText();

				if (data.isBlank() || diagnostico.isBlank() || horario.isBlank()) {
					// isBlank() verifica se a string é vazia

					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "PopUp Dialog",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// pegar no dao a consulta que estamos modificando
					Consulta consulta = consultaDAO.getConsulta(linhaSelecionada);
					consulta.setData(data);
					consulta.setHorario(horario);
					consulta.setDiagnostico(diagnostico);


					// atualizar a consulta no DAO
					consultaDAO.editarConsulta(consulta, linhaSelecionada);

					// recarregar a tabela
					carregarLinhasDaTabela();

					// ativar botões
					btnAgendar.setEnabled(true);
					btnEditar.setEnabled(true);
					btnCancelar.setEnabled(true);
					table.setEnabled(true);

					// desativar botão de finalizar Edição
					btnFedicao.setEnabled(false);

					// limpar os campos depois que editar
					textFieldData.setText("");
					textFieldDiagnostico.setText("");
					textFieldHorario.setText("");
				}
			}
		});
		btnFedicao.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFedicao.setBounds(493, 175, 147, 27);
		panel.add(btnFedicao);

		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar paciente na combobox
				int pacienteSelecionado;
				try {
					pacienteSelecionado = cbPaciente.getSelectedIndex();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Selecione um paciente", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
					return; //parar a execução
				}

				// pegar medico na combobox
				int medicoSelecionado;
				try {
					// pegar medico na combobox
					medicoSelecionado = cbMedico.getSelectedIndex();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Selecione um medico", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
					return; //parar a execução
				}
				
				String data = textFieldData.getText();
				String diagnostico = textFieldDiagnostico.getText();
				String horario = textFieldHorario.getText();

				if (data.isBlank() || diagnostico.isBlank() || horario.isBlank()) {
					// isBlank() verifica se a string é vazia

					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					Paciente p = pacienteDAO.getPaciente(pacienteSelecionado);
					Medico m = medicoDAO.getMedico(medicoSelecionado);
					
					// Cria o objeto da consulta
					Consulta consulta = new Consulta(p, m, data, horario, diagnostico);
					
					// armazena a consulta no DAO
					consultaDAO.cadastrarConsulta(consulta);
					
					// Recarregar a tabela
					carregarLinhasDaTabela();

					// Limpar os campos depois que cadastrar
					textFieldData.setText("");
					textFieldDiagnostico.setText("");
					textFieldHorario.setText("");
				}

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Dados da Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 268, 922, 259);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 902, 227);
		panel_1.add(scrollPane_1);

		this.modelo = new DefaultTableModel() {
			@Override // nao deixar editar tabela
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Adicionando colunas da tabela

		this.modelo.addColumn("Paciente");
		this.modelo.addColumn("Médico");
		this.modelo.addColumn("Data");
		this.modelo.addColumn("Horário");
		this.modelo.addColumn("Diagnóstico");

		// Adicionando as linhas da tabela
		carregarLinhasDaTabela();
		
		// Criando a tabela, adicionando o modelo
		this.table = new JTable(this.modelo);
		
		// selecionar apenas uma linha de cada vez
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_1.setViewportView(table);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {// ver se tem linha selecionada na tabela
					Consulta consultaSelecionads = consultaDAO.getConsulta(linhaSelecionada);
					String data = consultaSelecionads.getData();
					textFieldData.setText(data);
					String hora = consultaSelecionads.getHorario();
					textFieldHorario.setText(hora);
					String diagonistico = consultaSelecionads.getDiagnostico();
					textFieldDiagnostico.setText(diagonistico);

					// Desativar Botôes
					btnAgendar.setEnabled(false);
					btnEditar.setEnabled(false);
					btnCancelar.setEnabled(false);
					table.setEnabled(false);
					
					// ativar botão de finalizar Edição
					btnFedicao.setEnabled(true);
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEditar.setBounds(20, 537, 200, 29);
		contentPane.add(btnEditar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClinicaTelaPrincipal tela = new ClinicaTelaPrincipal();
				tela.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVoltar.setBounds(732, 537, 200, 29);
		contentPane.add(btnVoltar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {// ver se tem linha selecionada na tabela
					// Apagar Da Listagem a linha Selecionada
					consultaDAO.deletarConsulta(linhaSelecionada);
					// atualizar a tabela
					carregarLinhasDaTabela();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancelar.setBounds(375, 537, 200, 29);
		contentPane.add(btnCancelar);
	}
	
	private void comboBoxPacientes() {
		// Adicionando os pacientes no combo box
		ArrayList<Paciente> paciente = this.pacienteDAO.listarPacientes(); // Puxando os pacientes do DAO
		for (int i = 0; i < paciente.size(); i++) {
			Paciente p = paciente.get(i);
			this.cbPaciente.addItem(new ComboItem(p.getNome(), i+""));
		}
	}
	
	private void comboBoxMedicos() {
		// Adicionando os médicos no combo box
		ArrayList<Medico> medicos = this.medicoDAO.listarMedicos(); // Puxando os médicos do DAO
		for (int i = 0; i < medicos.size(); i++) {
			Medico m = medicos.get(i);
			this.cbMedico.addItem(new ComboItem(m.getNome(), i+""));
		}
	}
	
	private void carregarLinhasDaTabela() {
		// zerar os dados da tabela
		this.modelo.setRowCount(0);

		// Adicionando os médicos na tabela
		ArrayList<Consulta> consultas = this.consultaDAO.listarConsultas(); // Puxando os médicos do DAO
		for (int i = 0; i < consultas.size(); i++) { // Jogando a lista de médicos no modelo da tabela
			Consulta c = consultas.get(i);
			Paciente p = c.getPaciente();
			Medico m = c.getMedico();
			this.modelo.addRow(
					new Object[] { p.getNome(), m.getNome(), c.getData(), c.getHorario(), c.getDiagnostico() });
		}
	}

}
