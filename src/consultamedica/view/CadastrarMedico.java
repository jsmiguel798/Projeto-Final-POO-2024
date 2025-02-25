package consultamedica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import consultamedica.dao.MedicoDAO;
import consultamedica.dao.PacienteDAO;
import consultamedica.model.Medico;
import consultamedica.model.Paciente;

import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class CadastrarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCRM;
	private JTextField textFieldEspecialidade;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnEditar;
	private JButton btnExcluir;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMedico frame = new CadastrarMedico();
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dados do M\u00E9dico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 739, 136);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome*:");
		lblNewLabel.setBounds(10, 20, 46, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(105, 20, 255, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Especialidade*:");
		lblNewLabel_2.setBounds(10, 46, 104, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldEspecialidade = new JTextField();
		textFieldEspecialidade.setBounds(105, 44, 255, 19);
		panel.add(textFieldEspecialidade);
		textFieldEspecialidade.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail*:");
		lblNewLabel_3.setBounds(10, 69, 65, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(105, 67, 255, 19);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldCRM = new JTextField();
		textFieldCRM.setBounds(474, 20, 255, 19);
		panel.add(textFieldCRM);
		textFieldCRM.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CRM*:");
		lblNewLabel_1.setBounds(370, 22, 46, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_4 = new JLabel("Telefone*:");
		lblNewLabel_4.setBounds(370, 46, 75, 13);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(474, 44, 255, 19);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		JButton btnCadastrarMedico = new JButton("Cadastrar Médico");

		// btnCadastrarMedico.setBackground(new Color(240, 240, 240));
		btnCadastrarMedico.setBounds(530, 92, 199, 34);
		panel.add(btnCadastrarMedico);
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pega os valores que estão nos campos de texto
				String nome = textFieldNome.getText();
				String crm = textFieldCRM.getText();
				String especialidade = textFieldEspecialidade.getText();
				String email = textFieldEmail.getText();
				String telefone = textFieldTelefone.getText();

				if (nome.isBlank() || crm.isBlank() || especialidade.isBlank() || email.isBlank()
						|| telefone.isBlank()) {
					// isBlank() verifica se a string é vazia
					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "PopUp Dialog",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Criar um objeto da classe medico
					Medico medico = new Medico(nome, crm, especialidade, telefone, email);

					// Adicionar o novo médico ao DAO
					MedicoDAO.create(medico);

					// Recarregar a tabela
					carregarLinhasDaTabela();

					// Limpar os campos depois que cadastrar
					textFieldNome.setText("");
					textFieldCRM.setText("");
					textFieldEspecialidade.setText("");
					textFieldEmail.setText("");
					textFieldTelefone.setText("");
				}
			}
		});
		btnCadastrarMedico.setFont(new Font("Tahoma", Font.BOLD, 10));

		JButton btnFinalizarEdição = new JButton("Finalizar Edição");
		btnFinalizarEdição.setEnabled(false);
		btnFinalizarEdição.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();

				// pegar os valores editados
				String nome = textFieldNome.getText();
				String CRM = textFieldCRM.getText();
				String telefone = textFieldTelefone.getText();
				String especialidade = textFieldEspecialidade.getText();
				String email = textFieldEmail.getText();

				if (nome.isBlank() || CRM.isBlank() || telefone.isBlank() || especialidade.isBlank()
						|| email.isBlank()) {
					// isBlank() verifica se a string é vazia

					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "PopUp Dialog",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					// Criar um objeto da classe paciente
					Medico medico = new Medico(nome, CRM, telefone, especialidade, email);

					// atualizar o novo paciente ao DAO
					MedicoDAO.update(medico, linhaSelecionada);

					// recarregar a tabela
					carregarLinhasDaTabela();

					// ativar botões
					btnCadastrarMedico.setEnabled(true);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					table.setEnabled(true);

					// desativar botão de finalizar Edição
					btnFinalizarEdição.setEnabled(false);

					// limpar os campos depois que editar
					textFieldNome.setText("");
					textFieldCRM.setText("");
					textFieldTelefone.setText("");
					textFieldEspecialidade.setText("");
					textFieldEmail.setText("");

				}
			}
		});
		btnFinalizarEdição.setBounds(314, 92, 172, 30);
		panel.add(btnFinalizarEdição);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Listagem dos M\u00E9dicos", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_1.setBounds(10, 156, 736, 333);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 716, 258);
		panel_1.add(scrollPane);

		this.modelo = new DefaultTableModel() {

			@Override // nao deixar editar tabela
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};

		// Adicionando colunas da tabela

		this.modelo.addColumn("Nome");
		this.modelo.addColumn("CRM");
		this.modelo.addColumn("Especialidade");
		this.modelo.addColumn("Telefone");
		this.modelo.addColumn("E-mail");

		// Adicionando as linhas da tabela
		carregarLinhasDaTabela();

		// Criando a tabela, adicionando o modelo
		this.table = new JTable(this.modelo);
		// selecionar apenas uma linha de cada vez
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(10, 289, 199, 34);
		panel_1.add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {// ver se tem linha selecionada na tabela
					// Apagar Da Listagem a linha Selecionada
					MedicoDAO.delete(linhaSelecionada);
					// atualizar a tabela
					carregarLinhasDaTabela();
				}
			}
		});
		btnExcluir.setBounds(267, 289, 196, 34);
		panel_1.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(530, 290, 196, 33);
		panel_1.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinica voltar = new Clinica();
				voltar.setVisible(true);
				dispose();

			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegar a linha que esta selecionada
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {// ver se tem linha selecionada na tabela
					Medico medicoSelecionado = MedicoDAO.getMedico(linhaSelecionada);
					String nome = medicoSelecionado.getNome();
					textFieldNome.setText(nome);
					String crm = medicoSelecionado.getCrm();
					textFieldCRM.setText(crm);
					String especialidade = medicoSelecionado.getEspecialidade();
					textFieldEspecialidade.setText(especialidade);
					String telefone = medicoSelecionado.getTelefone();
					textFieldTelefone.setText(telefone);
					String email = medicoSelecionado.getEmail();
					textFieldEmail.setText(email);

					// Desativar Botôes
					btnCadastrarMedico.setEnabled(false);
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
					table.setEnabled(false);
					// atiavar botão de finalizar Edição
					btnFinalizarEdição.setEnabled(true);

				}
			}
		});
	}

	private void carregarLinhasDaTabela() {
		// zerar os dados da tabela
		this.modelo.setRowCount(0);

		// Adicionando os médicos na tabela
		ArrayList<Medico> medicos = MedicoDAO.list(); // Puxando os médicos do DAO
		for (int i = 0; i < medicos.size(); i++) { // Jogando a lista de médicos no modelo da tabela
			Medico m = medicos.get(i);
			this.modelo.addRow(
					new Object[] { m.getNome(), m.getCrm(), m.getEspecialidade(), m.getTelefone(), m.getEmail() });
		}
	}
}
