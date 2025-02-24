package consultamedica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					// ação para exibir no meio
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_3 = new JButton("Cadastrar Médico");
		btnNewButton_3.setBackground(new Color(248, 248, 255));
		btnNewButton_3.setFont(new Font("Perpetua", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMedico medico = new CadastrarMedico();
				medico.setVisible(true);
				dispose();

			}
		});
		btnNewButton_3.setBounds(139, 348, 176, 36);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("Cadastrar Paciente");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Perpetua", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chamar outra Tela
				PacienteListar n = new PacienteListar();
				n.setVisible(true);
				// ao clicar nele, a jenela fecha

				dispose();
			}
		});
		btnNewButton_2.setBounds(139, 271, 176, 36);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_1 = new JButton("Buscar Clinica");
		btnNewButton_1.setBackground(new Color(248, 248, 255));
		btnNewButton_1.setFont(new Font("Perpetua", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(476, 348, 176, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Cadastrar Consulta");
		btnNewButton.setBackground(new Color(248, 248, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Perpetua", Font.BOLD, 16));
		btnNewButton.setBounds(476, 271, 176, 36);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel(" Sistema de Gerenciamento de Pacientes e Consultas Médicas");
		lblNewLabel.setFont(new Font("Felix Titling", Font.BOLD, 20));
		lblNewLabel.setBounds(53, 105, 735, 90);
		contentPane.add(lblNewLabel);
	}

}
