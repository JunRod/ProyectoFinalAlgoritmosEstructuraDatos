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

import Arreglos.ArregloCliente;
import Clases.Cliente;
import Clases.Usuario;
import libreria.Diccionario;
import libreria.ayudantes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class DlgCliente extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	private JLabel lblNumeroCama;
	private JLabel lblCategoria;
	private JLabel lblPrecioDia;
	private JLabel lblEstado;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblCliente;
	private DefaultTableModel modelo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCliente dialog = new DlgCliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgCliente() {
		setResizable(false);
		setTitle("Mantenimiento | Usuario");
		setBounds(100, 100, 931, 572);
		getContentPane().setLayout(null);
		
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
		btnAceptar.setBounds(401, 139, 100, 23);
		getContentPane().add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(753, 10, 150, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(753, 35, 150, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(753, 60, 150, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 288, 900, 233);
		getContentPane().add(scrollPane);

		tblCliente = new JTable();
		tblCliente.addKeyListener(this);
		tblCliente.addMouseListener(this);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);

		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Nombres");
		modelo.addColumn("Direccion");
		modelo.addColumn("Fecha de Nacimiento");
		modelo.addColumn("Fecha de Afiliacion");
		modelo.addColumn("Estado Civil");
		modelo.addColumn("Telefono");
		modelo.addColumn("DNI");
		modelo.addColumn("Tipo de Cliente");
		
		tblCliente.setModel(modelo);
		
		JLabel lblTipoEmpleado = new JLabel("Estado CIvil");
		lblTipoEmpleado.setBounds(12, 236, 141, 23);
		getContentPane().add(lblTipoEmpleado);
		
		cboEstadoCivil = new JComboBox<String>();
		cboEstadoCivil.setEnabled(false);
		cboEstadoCivil.setBounds(165, 236, 85, 23);
		cboEstadoCivil.setModel(new DefaultComboBoxModel <String> (Diccionario.estadoCivil));
		getContentPane().add(cboEstadoCivil);
		
		JLabel lblLogin = new JLabel("Telefono");
		lblLogin.setBounds(263, 13, 141, 23);
		getContentPane().add(lblLogin);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(416, 13, 85, 22);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblPassword = new JLabel("DNI");
		lblPassword.setBounds(263, 48, 141, 23);
		getContentPane().add(lblPassword);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(416, 48, 85, 22);
		getContentPane().add(txtDNI);
		
		JLabel lblTurno = new JLabel("Tipo de Cliente");
		lblTurno.setBounds(263, 83, 141, 23);
		getContentPane().add(lblTurno);
		
		cboTipoCliente = new JComboBox<String>();
		cboTipoCliente.setBounds(416, 83, 85, 23);
		cboTipoCliente.setModel(new DefaultComboBoxModel <String> (Diccionario.tipoDeCliente));
		getContentPane().add(cboTipoCliente);
		
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
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(163, 130, 85, 22);
		getContentPane().add(txtDireccion);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 130, 141, 23);
		getContentPane().add(lblDireccion);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 166, 141, 23);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblFechaDeAfilicacion = new JLabel("Fecha de Afilicacion");
		lblFechaDeAfilicacion.setBounds(10, 201, 141, 23);
		getContentPane().add(lblFechaDeAfilicacion);
		
		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setDateFormatString("d / MMM / y");
		dateFechaNacimiento.setBounds(166, 167, 165, 22);
		getContentPane().add(dateFechaNacimiento);
		
		dateFechaAfiliacion = new JDateChooser();
		dateFechaAfiliacion.setDateFormatString("d / MMM / y");
		dateFechaAfiliacion.setBounds(166, 201, 165, 22);
		getContentPane().add(dateFechaAfiliacion);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	
	//  Declaraci�n global
	JDateChooser dateFechaNacimiento;
	
	JDateChooser dateFechaAfiliacion;
	ArregloCliente arregloCliente = new ArregloCliente();
	private JTextField txtTelefono;
	private JTextField txtDNI;
	JComboBox<String> cboEstadoCivil;
	JComboBox<String> cboTipoCliente;
	private JTextField txtNombres;
	private JTextField txtApellidoMaterno;
	private JTextField txtApellidoPaterno;
	private JTextField txtID;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblFechaDeAfilicacion;
	
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
		if (arregloCliente.tamano() == 0) {
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
		if (arregloCliente.tamano() == 0)
			mensaje("No existen usuarios");
		else {
			editarFila();
			habilitarEntradas(false);
			String IdUsuario = leerId();
			Cliente cliente = arregloCliente.buscar(IdUsuario);
			if (cliente != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					arregloCliente.eliminar(arregloCliente.buscar(leerId()));
					listar();
					editarFila();
				}
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0){
		String idCliente = leerId();
		String apellidoPaterno = leerApellidoPaterno();
		String apellidoMaterno = leerApellidoMaterno();
		String nombres = leerNombres();
		String direccion = leerDireccion();
		Date fechaNacimiento = leerFechaNacimiento();
		Date fechaAfiliacion = leerFechaAfiliacion();
		String estadoCivil = establecerEstadoCivil();
		String telefono = leerTelefono();
		String dni = leerDNI();
		int tipoDeCliente = leerTipoCliente();
		
		//Validar
		
		if(dni.length() > 8) {
			mensaje("DNI Incorrecto");
			return;
		}
		
		if(idCliente.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || nombres.isEmpty() || direccion.isEmpty() || fechaNacimiento.before(new Date(0)) || fechaAfiliacion.before(new Date(0)) || estadoCivil.isEmpty() || telefono.isEmpty() || dni.isEmpty() ){
			mensaje("tiene que rellenar todos los campos");
			return ;
		}
			
		
		if (btnAdicionar.isEnabled() == false) {
			Cliente clienteNuevo = new Cliente(idCliente, apellidoPaterno, apellidoMaterno, nombres, direccion, fechaNacimiento, fechaAfiliacion,
					estadoCivil, telefono, dni, tipoDeCliente);
			arregloCliente.adicionar(clienteNuevo);
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Cliente clienteModificado = arregloCliente.buscar(idCliente);
			clienteModificado.setIdCliente(idCliente);
			clienteModificado.setApellidoPaterno(apellidoPaterno);
			clienteModificado.setApellidoPaterno(apellidoPaterno);
			clienteModificado.setNombres(nombres);
			clienteModificado.setDireccion(direccion);
			/*
			clienteModificado.setFechaNacimiento(fechaNacimiento);
			clienteModificado.setFechaAfiliacion(fechaAfiliacion);
			*/
			clienteModificado.setEstadoCivil(estadoCivil);
			clienteModificado.setTelefono(telefono);
			clienteModificado.setDni(dni);
			clienteModificado.setTipoDeCliente(tipoDeCliente);
			arregloCliente.actualizarArchivo();
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
		if (arg0.getSource() == tblCliente) {
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
		if (arg0.getSource() == tblCliente) {
			mouseClickedTblUsuario(arg0);
		}
	}

	protected void mouseClickedTblUsuario(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblUsuario(MouseEvent arg0) {
		tblCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
	
	//  Metodos tipo void (sin parametros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25)); 
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25)); 
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25)); 
		tcm.getColumn(4).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(5).setPreferredWidth(anchoColumna(25)); 
		tcm.getColumn(6).setPreferredWidth(anchoColumna(25)); 
		tcm.getColumn(7).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(8).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(9).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(10).setPreferredWidth(anchoColumna(25));  
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCliente.getSelectedRow();
		if (modelo.getRowCount() == arregloCliente.tamano() - 1)
			posFila = arregloCliente.tamano() - 1;
		if (posFila == arregloCliente.tamano())
			posFila --;
		modelo.setRowCount(0);
		Cliente cliente;
		for (int i=0; i<arregloCliente.tamano(); i++) {
			cliente = arregloCliente.obtener(i);
			Object[] fila = { 
					cliente.getIdCliente(),
					cliente.getApellidoPaterno(),
					cliente.getApellidoMaterno(),
					cliente.getNombres(),
					cliente.getDireccion(),
					cliente.getFechaNacimientoFormateada(),
					cliente.getFechaAfiliacionFormateada(),
					cliente.getEstadoCivil(),
					cliente.getTelefono(),
					cliente.getDni(),
					cliente.getTipoDeCliente(),
					};
			modelo.addRow(fila);
		}
		if (arregloCliente.tamano() > 0)
			tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (arregloCliente.tamano() == 0)
			limpieza();
		else {
			Cliente cliente = arregloCliente.obtener(tblCliente.getSelectedRow());
			txtID.setText("" + cliente.getIdCliente());
			txtApellidoPaterno.setText("" + cliente.getApellidoPaterno());
			txtApellidoMaterno.setText("" + cliente.getApellidoMaterno());
			txtNombres.setText("" + cliente.getNombres());
			txtDireccion.setText("" + cliente.getDireccion());
			dateFechaNacimiento.setDate(cliente.getFechaNacimiento());
			dateFechaAfiliacion.setDate(cliente.getFechaAfiliacion());
			cboEstadoCivil.setSelectedIndex(cliente.getTipoDeCliente());
			txtTelefono.setText("" + cliente.getTelefono());
			txtDNI.setText("" + cliente.getDni());
			cboTipoCliente.setSelectedIndex(cliente.getTipoDeCliente());
		}
	}
	
	void limpieza() {
		txtID.setText("" + arregloCliente.numeroCorrelativo());
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		txtNombres.setText("");
		txtDireccion.setText("");
		dateFechaAfiliacion.setDate(null);
		dateFechaNacimiento.setDate(null);
		cboEstadoCivil.setSelectedIndex(0);
		txtTelefono.setText("");
		txtDNI.setText("");
		cboTipoCliente.setSelectedIndex(0);
	}
	//  M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informacion", 0);
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
		txtDireccion.setEnabled(sino);
		cboEstadoCivil.setEnabled(sino);
		txtTelefono.setEnabled(sino);
		txtDNI.setEnabled(sino);
		cboTipoCliente.setEnabled(sino);
		dateFechaAfiliacion.setEnabled(sino);
		dateFechaNacimiento.setEnabled(sino);
		
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  Metodos que retornan valor (sin parametros)
	String leerId() {
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
	
	String leerDireccion () {
		return txtDireccion.getText().trim();
	}
	Date leerFechaNacimiento () {
		return dateFechaNacimiento.getDate();
	}
	
	Date leerFechaAfiliacion () {
		return dateFechaAfiliacion.getDate();
	}
	
	int leerEstadoCivil () {
		return cboEstadoCivil.getSelectedIndex();
	}
	
	String leerTelefono () {
		return txtTelefono.getText().trim();
	}
	
	String leerDNI () {
		return txtDNI.getText().trim();
	}
	
	int leerTipoCliente () {
		return cboTipoCliente.getSelectedIndex();
	}
	
	String establecerEstadoCivil() {
		switch (leerEstadoCivil()) {
			case 0:
				return "Soltero";
			case 1:
				return "Casado";
			case 3:
				return "Viudo";
			case 4:
				return "Divorciado";
			default:
				return "No especifica";	
		}
	}
	/*
	String establecerTipoCliente() {
		switch (leerTipoCliente()) {
			case 0:
				return "Estandar";
			case 1:
				return "Bronce";
			case 3:
				return "Plata";
			case 4:
				return "Oro";
			default:
				return "Diamante";	
		}
	}*/
	
	
	//  M�todos que retornan valor (con par�metros)
	
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