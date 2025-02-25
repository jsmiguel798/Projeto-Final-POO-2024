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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import consultamedica.dao.PacienteDAO;
import consultamedica.model.Paciente;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JTextField textFieldData;
	private JTextField textFieldHorario;
	private JTextField textFieldDiagnostico;

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

		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(705, 175, 160, 27);
		panel.add(btnAgendar);
		btnAgendar.setFont(new Font("Tahoma", Font.BOLD, 10));

		JComboBox cbPaciente = new JComboBox();
		cbPaciente.setBounds(114, 27, 301, 21);
		panel.add(cbPaciente);

		textFieldDiagnostico = new JTextField();
		textFieldDiagnostico.setBounds(115, 108, 300, 19);
		panel.add(textFieldDiagnostico);
		textFieldDiagnostico.setColumns(10);

		JComboBox cbMedico = new JComboBox();
		cbMedico.setBounds(564, 27, 301, 21);
		panel.add(cbMedico);
		
		JButton btnFedicao = new JButton("Finalizar Edição");
		btnFedicao.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFedicao.setBounds(493, 175, 147, 27);
		panel.add(btnFedicao);

		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = textFieldData.getText();
				String diagnostico = textFieldDiagnostico.getText();
				String horario = textFieldHorario.getText();

				if (data.isBlank() || diagnostico.isBlank() || horario.isBlank()) {
					// isBlank() verifica se a string é vazia

					// Mensagem de erro se tiver campo em branco
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Cadastro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

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

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Paciente", "M\u00E9dico", "Data", "Hor\u00E1rio", "Diagn\u00F3stico" }));
		scrollPane_1.setViewportView(table);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancelar.setBounds(10, 537, 200, 29);
		contentPane.add(btnCancelar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEditar.setBounds(255, 537, 200, 29);
		contentPane.add(btnEditar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinica tela = new Clinica();
				tela.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVoltar.setBounds(732, 537, 200, 29);
		contentPane.add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConcluir.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConcluir.setBounds(493, 537, 200, 29);
		contentPane.add(btnConcluir);
	}

}
