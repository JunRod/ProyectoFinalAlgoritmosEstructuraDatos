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

import Arreglos.ArregloGenero;
import Clases.Cancion;
import Clases.Cliente;
import Clases.Genero;
import Clases.Usuario;
import libreria.Diccionario;
import libreria.ayudantes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class DlgGenero extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	private JLabel lblNumeroCama;
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
					DlgGenero dialog = new DlgGenero();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgGenero() {
		setResizable(false);
		setTitle("Mantenimiento | Genero");
		setBounds(100, 100, 931, 572);
		getContentPane().setLayout(null);
		
		lblNumeroCama = new JLabel("ID");
		lblNumeroCama.setBounds(10, 10, 110, 23);
		getContentPane().add(lblNumeroCama);
		
		lblEstado = new JLabel("Descripcion");
		lblEstado.setBounds(12, 46, 141, 23);
		getContentPane().add(lblEstado);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setBounds(276, 10, 100, 23);
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
		modelo.addColumn("Descripcion");
		modelo.addColumn("Epoca");
		modelo.addColumn("Estado");
		
		tblCliente.setModel(modelo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(165, 46, 85, 22);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(163, 10, 88, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		lblDireccion = new JLabel("Estado");
		lblDireccion.setBounds(10, 119, 141, 23);
		getContentPane().add(lblDireccion);
		
		lblFechaRegistro = new JLabel("Epoca");
		lblFechaRegistro.setBounds(10, 82, 141, 23);
		getContentPane().add(lblFechaRegistro);
		
		cboEstado = new JComboBox<String>(Diccionario.estado);
		cboEstado.setEnabled(false);
		cboEstado.setBounds(165, 118, 85, 23);
		getContentPane().add(cboEstado);
		
		spinnerEpoca = new JSpinner();
		spinnerEpoca.setModel(new SpinnerNumberModel(1970, 1960, 2020, 10));
		spinnerEpoca.setBounds(165, 81, 85, 22);
		getContentPane().add(spinnerEpoca);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	JSpinner spinnerEpoca;
	JComboBox<String> cboEstado;
	ArregloGenero arregloGenero = new ArregloGenero();
	private JTextField txtDescripcion;
	private JTextField txtID;
	private JLabel lblDireccion;
	private JLabel lblFechaRegistro;
	
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
		if (arregloGenero.tamano() == 0) {
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
		if (arregloGenero.tamano() == 0)
			mensaje("No existen usuarios");
		else {
			editarFila();
			habilitarEntradas(false);
			String id = leerId();
			Genero genero = arregloGenero.buscar(id);
			if (genero != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					arregloGenero.eliminar(arregloGenero.buscar(leerId()));
					listar();
					editarFila();
				}
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0){
		String id = leerId();
		String descripcion = leerDescripcion();
		int epoca = leerEpoca();
		boolean estado = establecerEstado();
		
		//Validar
		if(id.isEmpty() || descripcion.isEmpty()){
			mensaje("tiene que rellenar todos los campos");
			return ;
		}
			
		if (btnAdicionar.isEnabled() == false) {
			Genero generoNuevo = new Genero(id, descripcion, epoca, estado);
			arregloGenero.adicionar(generoNuevo);
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			Genero generoModificado = arregloGenero.buscar(id);
			generoModificado.setIdGenero(id);
			generoModificado.setDescripcion(descripcion);;
			generoModificado.setEpoca(epoca);
			generoModificado.setEstado(estado);
			arregloGenero.actualizarArchivo();
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
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25)); 
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCliente.getSelectedRow();
		if (modelo.getRowCount() == arregloGenero.tamano() - 1)
			posFila = arregloGenero.tamano() - 1;
		if (posFila == arregloGenero.tamano())
			posFila --;
		modelo.setRowCount(0);
		Genero genero;
		for (int i=0; i<arregloGenero.tamano(); i++) {
			genero = arregloGenero.obtener(i);
			Object[] fila = { 
					genero.getIdGenero(),
					genero.getDescripcion(),
					genero.getEpoca(),
					BooleanToString(genero.isEstado())
					};
			modelo.addRow(fila);
		}
		if (arregloGenero.tamano() > 0)
			tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	String BooleanToString(boolean estado) {
		if(estado)
			return "Habilitado";
		
		return "Inhabilitado" ;
	}
	
	void editarFila() {
		if (arregloGenero.tamano() == 0)
			limpieza();
		else {
			Genero genero = arregloGenero.obtener(tblCliente.getSelectedRow());
			txtID.setText("" + genero.getIdGenero());
			txtDescripcion.setText("" + genero.getDescripcion());
			spinnerEpoca.setValue(genero.getEpoca());
			cboEstado.setSelectedIndex(BooleanToInt(genero.isEstado()));
		}
	}
	
	int BooleanToInt (boolean estado) {
		if(estado)
			return 0;
		return 1;
	}
	
	void limpieza() {
		txtID.setText("" + arregloGenero.numeroCorrelativo());
		txtDescripcion.setText("");
		spinnerEpoca.setValue(1970);
		cboEstado.setSelectedIndex(1);
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
		txtDescripcion.setEnabled(sino);
		cboEstado.setEnabled(sino);
		spinnerEpoca.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  Metodos que retornan valor (sin parametros)
	
	String leerId() {
		return txtID.getText().trim();
	}
	
	String leerDescripcion () {
		return txtDescripcion.getText().trim();
	}
	
	int leerEpoca () {
		return (int)spinnerEpoca.getValue();
	}
	
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	boolean establecerEstado() {
		switch (leerEstado()) {
			case 0:
				return false;
			default:
				return true;	
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