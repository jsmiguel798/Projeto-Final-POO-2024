package consultamedica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class PacienteListar extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteListar frame = new PacienteListar();
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

		JButton btnAgendarConsulta = new JButton("Agendar Consulta");
		btnAgendarConsulta.setBackground(new Color(220, 220, 220));
		btnAgendarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgendarConsulta.setBounds(30, 430, 168, 25);
		contentPane.add(btnAgendarConsulta);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Dados do Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 16, 848, 174);
		contentPane.add(panel);
		panel.setLayout(null);

		Label Nome = new Label("Nome*:");
		Nome.setBounds(10, 20, 59, 23);
		panel.add(Nome);
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setBounds(172, 24, 307, 19);
		panel.add(textField);
		textField.setColumns(10);

		Label labelCPF = new Label("CPF* :");
		labelCPF.setBounds(503, 22, 52, 21);
		panel.add(labelCPF);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCPF.setBackground(UIManager.getColor("Button.background"));

		textField_3 = new JTextField();
		textField_3.setBounds(588, 24, 235, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);

		Label labelTelefone = new Label("Telefone*:");
		labelTelefone.setBounds(503, 60, 79, 21);
		panel.add(labelTelefone);
		labelTelefone.setBackground(UIManager.getColor("Button.background"));
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_1 = new JTextField();
		textField_1.setBounds(588, 60, 235, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		Label labelHistorico = new Label("Hisórico Médico*:");
		labelHistorico.setBounds(10, 104, 130, 21);
		panel.add(labelHistorico);
		labelHistorico.setFont(new Font("Tahoma", Font.PLAIN, 13));

		Label labelDataDeNascimento = new Label("Data De Nascimento*:");
		labelDataDeNascimento.setBounds(10, 60, 160, 21);
		panel.add(labelDataDeNascimento);
		labelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_4 = new JTextField();
		textField_4.setBounds(172, 60, 307, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(172, 106, 307, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnCadastrarPaciente = new JButton("Cadastrar ");
		btnCadastrarPaciente.setForeground(UIManager.getColor("Button.background"));
		btnCadastrarPaciente.setBounds(611, 127, 212, 37);
		panel.add(btnCadastrarPaciente);
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCadastrarPaciente.setBackground(SystemColor.activeCaption);
		btnCadastrarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dados do Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 200, 848, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 828, 189);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Telefone", "CPF", "Data De Nascimento", "Hist\u00F3rico M\u00E9dico" }));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(718, 430, 140, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(300, 430, 101, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(518, 430, 101, 25);
		contentPane.add(btnNewButton_2);
	}
}
