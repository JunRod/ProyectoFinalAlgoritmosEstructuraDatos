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

import Arreglos.ArregloCancion;
import Clases.Artista;
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
import com.toedter.calendar.JDateChooser;


public class DlgCancion extends JDialog implements ActionListener, KeyListener, MouseListener {
	
	private JLabel lblNumeroCama;
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
					//Condicional, "AGREGUE UN GENERO ANTES DE AGREGAR UN ARTISTA (verificar si akmenos existe un genero)"
					DlgCancion dialog = new DlgCancion();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgCancion() {
		setResizable(false);
		setTitle("Mantenimiento | Cancion");
		setBounds(100, 100, 931, 572);
		getContentPane().setLayout(null);
		
		lblNumeroCama = new JLabel("ID");
		lblNumeroCama.setBounds(10, 10, 110, 23);
		getContentPane().add(lblNumeroCama);

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
		modelo.addColumn("Nombre");
		modelo.addColumn("ID Artista");
		modelo.addColumn("Album");
		modelo.addColumn("Fecha de Registro");
		modelo.addColumn("N° de Reproducciones");
		modelo.addColumn("Estado");
		
		tblCliente.setModel(modelo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(165, 46, 85, 22);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(163, 10, 88, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		lblDireccion = new JLabel("Estado");
		lblDireccion.setBounds(10, 219, 141, 23);
		getContentPane().add(lblDireccion);
		
		lblFechaRegistro = new JLabel("Fecha de Registro");
		lblFechaRegistro.setBounds(10, 146, 141, 23);
		getContentPane().add(lblFechaRegistro);
		
		cboEstado = new JComboBox<String>(Diccionario.estado);
		cboEstado.setEnabled(false);
		cboEstado.setBounds(165, 218, 156, 23);
		getContentPane().add(cboEstado);
		
		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setDateFormatString("d / MMM / y");
		dateFechaRegistro.setBounds(165, 145, 156, 22);
		getContentPane().add(dateFechaRegistro);
		
		lblIdGenero = new JLabel("ID Artista");
		lblIdGenero.setBounds(11, 77, 141, 23);
		getContentPane().add(lblIdGenero);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 49, 88, 16);
		getContentPane().add(lblNewLabel);
		
		lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(10, 116, 88, 16);
		getContentPane().add(lblAlbum);
		
		txtAlbum = new JTextField();
		txtAlbum.setEnabled(false);
		txtAlbum.setColumns(10);
		txtAlbum.setBounds(165, 113, 85, 22);
		getContentPane().add(txtAlbum);
		
		spinnerReproducciones = new JSpinner();
		spinnerReproducciones.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerReproducciones.setBounds(164, 183, 66, 22);
		getContentPane().add(spinnerReproducciones);
		
		lblNewLabel_1 = new JLabel("N° de Reproducciones");
		lblNewLabel_1.setBounds(10, 186, 150, 16);
		getContentPane().add(lblNewLabel_1);
		
		Diccionario.generarTodosLosIDArtista();

		    cbIdArtista = new JComboBox(Diccionario.IdArtistas);
		    cbIdArtista.setBounds(165, 81, 85, 24);
		    getContentPane().add(cbIdArtista);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	JComboBox<String> cboEstado;
	
	JLabel lblIdGenero;
	JDateChooser dateFechaRegistro;
	JComboBox cbIdArtista;
	ArregloCancion arregloCancion = new ArregloCancion();
	private JTextField txtNombre;
	private JTextField txtID;
	private JLabel lblDireccion;
	private JLabel lblFechaRegistro;
	private JLabel lblNewLabel;
	private JLabel lblAlbum;
	private JTextField txtAlbum;
	private JSpinner spinnerReproducciones;
	private JLabel lblNewLabel_1;
	
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
		if (arregloCancion.tamano() == 0) {
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
		
		if (arregloCancion.tamano() == 0)
			mensaje("No existen usuarios");
		else {
			editarFila();
			habilitarEntradas(false);
			String id = leerId();
			Cancion cancion = arregloCancion.buscar(id);
			if (cancion != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					arregloCancion.eliminar(arregloCancion.buscar(leerId()));
					listar();
					editarFila();
				}
			}
			
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0){
		String id = leerId();
		String nombre = leerNombre();
		String IdArtista = leerIdArtista();
		String album = leerAlbum();
		Date fechaRegistro = leerFechaRegistro();
		int numeroReproducciones = leerNumeroReproducciones();
		boolean estado = establecerEstado();
		
		//Validar
		if(id.isEmpty() || nombre.isEmpty() || IdArtista.isEmpty() || album.isEmpty()){
			mensaje("tiene que rellenar todos los campos");
			return ;
		}
			
		if (btnAdicionar.isEnabled() == false) {
			Cancion cancionNuevo = new Cancion(id, nombre, IdArtista, album, fechaRegistro, numeroReproducciones, estado);
			arregloCancion.adicionar(cancionNuevo);
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			
			Cancion cancionModificada = arregloCancion.buscar(id);
			cancionModificada.setIdCancion(id);
			cancionModificada.setNombre(nombre);;
			cancionModificada.setArtista(IdArtista);
			cancionModificada.setFechaRegistro(fechaRegistro);
			cancionModificada.setNumeroReproducciones(numeroReproducciones);
			cancionModificada.setEstado(estado);
			
			arregloCancion.actualizarArchivo();
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
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCliente.getSelectedRow();
		if (modelo.getRowCount() == arregloCancion.tamano() - 1)
			posFila = arregloCancion.tamano() - 1;
		if (posFila == arregloCancion.tamano())
			posFila --;
		modelo.setRowCount(0);
		Cancion cancion;
		for (int i=0; i<arregloCancion.tamano(); i++) {
			
			cancion = arregloCancion.obtener(i);
			Object[] fila = { 
					cancion.getIdCancion(),
					cancion.getNombre(),
					cancion.getArtista(),
					cancion.getAlbum(),
					cancion.getFechaRegistroFormateada(),
					cancion.getNumeroReproducciones(),
					BooleanToString(cancion.isEstado())
					};
			modelo.addRow(fila);
		}
		if (arregloCancion.tamano() > 0)
			tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	String BooleanToString(boolean estado) {
		if(estado)
			return "Habilitado";
		
		return "Inhabilitado" ;
	}
	
	void editarFila() {
		if (arregloCancion.tamano() == 0)
			limpieza();
		else {
			Cancion cancion = arregloCancion.obtener(tblCliente.getSelectedRow());
			txtID.setText("" + cancion.getIdCancion());
			txtNombre.setText("" + cancion.getNombre());
			cbIdArtista.setSelectedIndex(obtenerPosicionArtista(cancion.getArtista()));
			txtAlbum.setText("" + cancion.getAlbum());
			dateFechaRegistro.setDate(cancion.getFechaRegistro());
			spinnerReproducciones.setValue(cancion.getNumeroReproducciones());
			cboEstado.setSelectedIndex(BooleanToInt(cancion.isEstado()));
		}
	}
	
	int obtenerPosicionArtista(String artista) {
		for (int i = 0; i < Diccionario.IdArtistas.length; i++) {
			if(Diccionario.IdArtistas[i].equals(artista)) {
				return i;
			}
		}
		return -1;
	}
	
	int BooleanToInt (boolean estado) {
		if(estado)
			return 0;
		return 1;
	}
	
	void limpieza() {
		txtID.setText("" + arregloCancion.numeroCorrelativo());
		txtNombre.setText("");
		cbIdArtista.setSelectedIndex(-1);
		dateFechaRegistro.setDate(null);
		cboEstado.setSelectedIndex(1);
		spinnerReproducciones.setValue(1);
		txtAlbum.setText("");
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
		txtNombre.setEnabled(sino);
		cbIdArtista.setEnabled(sino);
		dateFechaRegistro.setEnabled(sino);
		cboEstado.setEnabled(sino);
		spinnerReproducciones.setEnabled(sino);
		txtAlbum.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  Metodos que retornan valor (sin parametros)
	
	int leerNumeroReproducciones() {
		return (int) spinnerReproducciones.getValue();
	}
	
	String leerAlbum() {
		return txtAlbum.getText().trim();
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	String leerIdArtista() {
		return (String) cbIdArtista.getSelectedItem();
	}
	
	Date leerFechaRegistro() {
		return dateFechaRegistro.getDate();
	}
	
	String leerId() {
		return txtID.getText().trim();
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