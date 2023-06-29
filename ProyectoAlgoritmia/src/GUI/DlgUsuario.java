package GUI;

/*import clases.Cama;
import arreglos.ArregloCamas;
import libreria.Lib;
import libreria.Formato;*/

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloUsuario;
import Clases.Usuario;
import libreria.Diccionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgUsuario extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	private JLabel lblImgCama;
	private JLabel lblNumeroCama;
	private JLabel lblCategoria;
	private JLabel lblPrecioDia;
	private JLabel lblEstado;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblUsuario;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgUsuario dialog = new DlgUsuario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgUsuario() {
		setResizable(false);
		setTitle("Mantenimiento | Usuario");
		setBounds(100, 100, 931, 572);
		getContentPane().setLayout(null);
		
		lblImgCama = new JLabel();
		lblImgCama.setIcon(new ImageIcon("imagenes/dlgCama.png"));
		lblImgCama.setBounds(400, 10, 89, 89);
		getContentPane().add(lblImgCama);
		
		lblNumeroCama = new JLabel("ID");
		lblNumeroCama.setBounds(10, 10, 110, 23);
		getContentPane().add(lblNumeroCama);
		
		lblCategoria = new JLabel("Apellido Paterno");
		lblCategoria.setBounds(10, 40, 141, 23);
		getContentPane().add(lblCategoria);
	
		lblPrecioDia = new JLabel("Apellido Materno");
		lblPrecioDia.setBounds(10, 70, 141, 23);
		getContentPane().add(lblPrecioDia);
		
		lblEstado = new JLabel("Nombres");
		lblEstado.setBounds(10, 100, 141, 23);
		getContentPane().add(lblEstado);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setBounds(263, 10, 100, 23);
		getContentPane().add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(535, 10, 150, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(535, 35, 150, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(535, 60, 150, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 288, 900, 233);
		getContentPane().add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.addKeyListener(this);
		tblUsuario.addMouseListener(this);
		tblUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuario);

		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Nombres");
		modelo.addColumn("Tipo Empleado");
		modelo.addColumn("Login");
		modelo.addColumn("Password");
		modelo.addColumn("Turno");
		
		
		tblUsuario.setModel(modelo);
		
		JLabel lblTipoEmpleado = new JLabel("Tipo Empleado");
		lblTipoEmpleado.setBounds(10, 136, 141, 23);
		getContentPane().add(lblTipoEmpleado);
		
		cboTipoEmpleado = new JComboBox<String>();
		cboTipoEmpleado.setBounds(163, 136, 85, 23);
		cboTipoEmpleado.setModel(new DefaultComboBoxModel <String> (Diccionario.tipoEmpleado));
		getContentPane().add(cboTipoEmpleado);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 172, 141, 23);
		getContentPane().add(lblLogin);
		
		txtxLogin = new JTextField();
		txtxLogin.setBounds(163, 172, 85, 22);
		getContentPane().add(txtxLogin);
		txtxLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 207, 141, 23);
		getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(163, 207, 85, 22);
		getContentPane().add(txtPassword);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(10, 242, 141, 23);
		getContentPane().add(lblTurno);
		
		cboTurno = new JComboBox<String>();
		cboTurno.setBounds(163, 242, 85, 23);
		cboTurno.setModel(new DefaultComboBoxModel <String> (Diccionario.turno));
		getContentPane().add(cboTurno);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(163, 100, 85, 22);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setBounds(163, 70, 85, 22);
		getContentPane().add(txtApellidoMaterno);
		txtApellidoMaterno.setColumns(10);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setBounds(163, 40, 85, 22);
		getContentPane().add(txtApellidoPaterno);
		txtApellidoPaterno.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(163, 10, 88, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	
	//  Declaraci�n global
	ArregloUsuario arregloUsuario = new ArregloUsuario();
	private JTextField txtxLogin;
	private JTextField txtPassword;
	JComboBox<String> cboTipoEmpleado;
	JComboBox<String> cboTurno;
	private JTextField txtNombres;
	private JTextField txtApellidoMaterno;
	private JTextField txtApellidoPaterno;
	private JTextField txtID;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (arregloUsuario.tamano() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen usuarios");	
		}
		else {
			editarFila();
			habilitarEntradas(true);
			habilitarEntradas(true);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (arregloUsuario.tamano() == 0)
			mensaje("No existen usuarios");
		else {
			editarFila();
			habilitarEntradas(false);
			String IdUsuario = leerIdUsuario();
			Usuario usuario = arregloUsuario.buscar(IdUsuario);
			if (usuario != null) {
				int ok = confirmar("� Desea eliminar el registro ?");
				if (ok == 0) {
					arregloUsuario.eliminar(arregloUsuario.buscar(leerIdUsuario()));
					listar();
					editarFila();
				}
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String idUsuario = leerIdUsuario();
		String apellidoPaterno = leerApellidoPaterno();
		String apellidoMaterno = leerApellidoMaterno();
		String nombres = leerNombres();
		int tipoEmpleado = leerPosTipoEmpleado();
		String login = leerLogin();
		String password = leerPassword();
		String turno = establecerTurno();
		
		//Validar
		if(idUsuario.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || nombres.isEmpty() || login.isEmpty() || password.isEmpty()) {
			mensaje("tiene que rellenar todos los campos");
			return ;
		}
			
		
		if (btnAdicionar.isEnabled() == false) {
			Usuario usuarioNuevo = new Usuario(idUsuario,apellidoPaterno, apellidoMaterno, nombres, tipoEmpleado, login, password, turno);
			arregloUsuario.adicionar(usuarioNuevo);
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Usuario usuarioModificado = arregloUsuario.buscar(idUsuario);
			usuarioModificado.setIdUsuario(idUsuario);
			usuarioModificado.setApellidoPaterno(apellidoPaterno);
			usuarioModificado.setApellidoPaterno(apellidoPaterno);
			usuarioModificado.setNombres(nombres);
			usuarioModificado.setTipoEmpleado(tipoEmpleado);
			usuarioModificado.setLogin(login);
			usuarioModificado.setPassword(password);
			usuarioModificado.setTurno(turno);
			arregloUsuario.actualizarArchivo();
			btnModificar.setEnabled(true);
		}
		listar();
		habilitarEntradas(false);
	}

	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();		
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblUsuario) {
			mouseClickedTblUsuario(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			mouseEnteredBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(arg0);
		}
		if (arg0.getSource() == tblUsuario) {
			mouseClickedTblUsuario(arg0);
		}
	}

	protected void mouseClickedTblUsuario(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblUsuario(MouseEvent arg0) {
		tblUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnModificar(MouseEvent arg0) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnEliminar(MouseEvent arg0) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	//  M�todos tipo void (sin par�metros)
	
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblUsuario.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  // idUsuario
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // apellidoPaterno
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // apellidoMaterno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  // nombres
		tcm.getColumn(4).setPreferredWidth(anchoColumna(25));  // tipoEmpleado
		tcm.getColumn(5).setPreferredWidth(anchoColumna(25));  // login
		tcm.getColumn(6).setPreferredWidth(anchoColumna(25));  // password
		tcm.getColumn(7).setPreferredWidth(anchoColumna(25));  // turno
	}
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblUsuario.getSelectedRow();
		if (modelo.getRowCount() == arregloUsuario.tamano() - 1)
			posFila = arregloUsuario.tamano() - 1;
		if (posFila == arregloUsuario.tamano())
			posFila --;
		modelo.setRowCount(0);
		Usuario usuario;
		for (int i=0; i<arregloUsuario.tamano(); i++) {
			usuario = arregloUsuario.obtener(i);
			Object[] fila = { usuario.getIdUsuario(),
					usuario.getApellidoPaterno(),
					usuario.getApellidoMaterno(),
					usuario.getNombres(),
					categoriaEnTexto(usuario.getTipoEmpleado()),
					usuario.getLogin(),
					usuario.getPassword(),
					usuario.getTurno()};
			modelo.addRow(fila);
		}
		if (arregloUsuario.tamano() > 0)
			tblUsuario.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (arregloUsuario.tamano() == 0)
			limpieza();
		else {
			Usuario usuario = arregloUsuario.obtener(tblUsuario.getSelectedRow());
			txtID.setText("" + usuario.getIdUsuario());
			txtApellidoPaterno.setText("" + usuario.getApellidoPaterno());
			txtApellidoPaterno.setText("" + usuario.getApellidoMaterno());
			txtNombres.setText("" + usuario.getNombres());
			cboTipoEmpleado.setSelectedIndex(usuario.getTipoEmpleado());
			txtxLogin.setText("" + usuario.getLogin());
			txtPassword.setText("" + usuario.getPassword());
			cboTurno.setSelectedIndex(TurnoStringAInt(usuario.getTurno()));
		}
	}
	void limpieza() {
		txtID.setText("" + arregloUsuario.numeroCorrelativo());
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		txtNombres.setText("");
		txtxLogin.setText("");
		txtPassword.setText("");
		cboTipoEmpleado.setSelectedIndex(0);
		cboTurno.setSelectedIndex(0);
	}
	//  M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtApellidoPaterno.setEnabled(sino);
		txtApellidoMaterno.setEnabled(sino);
		txtNombres.setEnabled(sino);
		cboTipoEmpleado.setEnabled(sino);
		txtxLogin.setEnabled(sino);
		txtPassword.setEnabled(sino);
		cboTurno.setEnabled(sino);
		
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  M�todos que retornan valor (sin par�metros)
	String leerIdUsuario() {
		return txtID.getText().trim();
	}
	String leerApellidoPaterno() {
		return txtApellidoPaterno.getText().trim();
	}
	String leerApellidoMaterno() {
		return txtApellidoMaterno.getText().trim();
	}
	String leerNombres() {
		return txtNombres.getText().trim();
	}
	int leerPosTipoEmpleado() {
		return cboTipoEmpleado.getSelectedIndex();
	}
	String leerLogin() {
		return txtxLogin.getText().trim();
	}
	String leerPassword() {
		return txtPassword.getText().trim();
	}
	int leerPosTurno() {
		return cboTurno.getSelectedIndex();
	}
	
	String establecerTurno() {
		switch (leerPosTurno()) {
			case 0:
				return "Tarde";
			case 1:
				return "Noche";
			default:
				return "";	
		}
	}
	
	
	//  M�todos que retornan valor (con par�metros)
	
	int TurnoStringAInt(String turno) {
		switch (turno) {
		case "Tarde":
			return 0;
		case "Noche":
			return 1;
		default:
			return 3;	
	}
	}
	
	String categoriaEnTexto(int categoria) {
		switch (categoria) {
			case 0:
				return "Administrador";
			case 1:
				return "Supervisor";
			default:
				return "Mozo";	
		}
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}