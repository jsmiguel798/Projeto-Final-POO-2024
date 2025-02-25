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
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClinicaTelaPrincipal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicaTelaPrincipal frame = new ClinicaTelaPrincipal();
					// ação para exibir no meio
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ClinicaTelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 511);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sobre");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Bem-vindo ao nosso sistema! Aqui você pode agendar consultas de forma prática e rápida.\r\n\r\n");
		mntmNewMenuItem.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem);
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
		btnNewButton_3.setBounds(124, 367, 232, 36);
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
		btnNewButton_2.setBounds(124, 271, 232, 36);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_1 = new JButton(" Acessar Clinica");
		btnNewButton_1.setBackground(new Color(248, 248, 255));
		btnNewButton_1.setFont(new Font("Perpetua", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarConsulta n = new CadastrarConsulta();
				n.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(517, 367, 232, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Cadastrar Consulta");
		btnNewButton.setBackground(new Color(248, 248, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarConsulta CC = new CadastrarConsulta();
				CC.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Perpetua", Font.BOLD, 16));
		btnNewButton.setBounds(517, 271, 232, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("MEDCENTER");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel.setBounds(229, 82, 390, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClinicaTelaPrincipal.class.getResource("/consultamedica/view/resources/Imagem Tela Principal.jpg")));
		lblNewLabel_1.setBounds(0, 0, 810, 452);
		contentPane.add(lblNewLabel_1);
	}
}
