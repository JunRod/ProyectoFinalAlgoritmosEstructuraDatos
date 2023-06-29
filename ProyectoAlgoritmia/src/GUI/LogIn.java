package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField jpassContrasenia;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(180, 11, 46, 14);
		contentPane.add(lblLogin);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 51, 78, 14);
		contentPane.add(lblUsuario);

		lblContrasea = new JLabel("Contrasena");
		lblContrasea.setBounds(10, 88, 78, 14);
		contentPane.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(115, 48, 111, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		jpassContrasenia = new JPasswordField();
		jpassContrasenia.setBounds(115, 85, 111, 20);
		contentPane.add(jpassContrasenia);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(296, 47, 89, 23);
		contentPane.add(btnIngresar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		char[] contrasenia = jpassContrasenia.getPassword();
		String miContrasenia = new String(contrasenia);
		if (txtUsuario.getText().equals("Junior") && miContrasenia.equals("123")) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido", "Ingresaste", JOptionPane.INFORMATION_MESSAGE);
			MenuPrincipal menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			jpassContrasenia.setText("");
			txtUsuario.requestFocus();
		}
	}
}
