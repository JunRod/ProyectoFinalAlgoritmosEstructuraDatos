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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LogIn extends JFrame implements ActionListener {

	private static final Object TipoUsuario = null;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JTextField txtUsuario;
	private JPasswordField jpassContrasena;
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
		setBounds(100, 100, 450, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(109, 93, 78, 14);
		contentPane.add(lblUsuario);

		lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(109, 124, 78, 14);
		contentPane.add(lblContrasena);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(211, 90, 111, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		jpassContrasena = new JPasswordField();
		jpassContrasena.setBounds(211, 121, 111, 20);
		contentPane.add(jpassContrasena);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(112, 172, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(219, 172, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
		lblTipoDeUsuario.setBounds(90, 53, 111, 14);
		contentPane.add(lblTipoDeUsuario);
		
		JComboBox TipoUsuario = new JComboBox();
		TipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Mozo"}));
		TipoUsuario.setBounds(211, 50, 111, 20);
		contentPane.add(TipoUsuario);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		
		String usu=txtUsuario.getText(),
				con=jpassContrasena.getText();
		if(usu.equals("Gregory") && con.equals("usuario123"))
			
		{
			MenuPrincipal m =new MenuPrincipal();
			JOptionPane.showMessageDialog(null, "Bienvenido Al Sistema "+ usu);
			m.show();
		}else{
			JOptionPane.showMessageDialog(null, "Error Verifique los datos!!");
		}
	}
}