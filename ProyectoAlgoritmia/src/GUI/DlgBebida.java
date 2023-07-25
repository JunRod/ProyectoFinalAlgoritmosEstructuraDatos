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

import Arreglos.ArregloBebida;
import Clases.Artista;
import Clases.Bebida;
import Clases.Cancion;
import Clases.Cliente;
import Clases.Genero;
import Clases.Piqueo;
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


public class DlgBebida extends JDialog implements ActionListener, KeyListener, MouseListener {
	
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
					DlgBebida dialog = new DlgBebida();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgBebida() {
		setResizable(false);
		setTitle("Mantenimiento | Bebida");
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
		modelo.addColumn("Tipo de Bebida");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
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
		lblDireccion.setBounds(10, 188, 141, 23);
		getContentPane().add(lblDireccion);
		
		cboEstado = new JComboBox(Diccionario.estado);
		cboEstado.setSelectedIndex(1);
		cboEstado.setEnabled(false);
		cboEstado.setBounds(165, 187, 156, 23);
		getContentPane().add(cboEstado);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 49, 88, 16);
		getContentPane().add(lblNewLabel);
		
		lblAlbum = new JLabel("Precio");
		lblAlbum.setBounds(10, 156, 88, 16);
		getContentPane().add(lblAlbum);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(165, 153, 85, 22);
		getContentPane().add(txtPrecio);
		
		lblNewLabel_1 = new JLabel("Tipo de bebida");
		lblNewLabel_1.setBounds(10, 85, 150, 16);
		getContentPane().add(lblNewLabel_1);
		
		cbTipoBebida = new JComboBox(Diccionario.tipoBebida);
		cbTipoBebida.setBounds(165, 81, 156, 24);
		getContentPane().add(cbTipoBebida);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(165, 118, 85, 22);
		getContentPane().add(txtMarca);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 121, 88, 16);
		getContentPane().add(lblMarca);
		
		Diccionario.generarTodosLosIDArtista();
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	
	JComboBox cbTipoBebida;
	JComboBox cboEstado;
	ArregloBebida arregloBebida = new ArregloBebida();
	private JTextField txtNombre;
	private JTextField txtID;
	private JLabel lblDireccion;
	private JLabel lblNewLabel;
	private JLabel lblAlbum;
	private JTextField txtPrecio;
	private JLabel lblNewLabel_1;
	private JTextField txtMarca;
	
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
		if (arregloBebida.tamano() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen piqueos");	
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
		
		if (arregloBebida.tamano() == 0)
			mensaje("No existen bebidas");
		else {
			editarFila();
			habilitarEntradas(false);
			String id = leerId();
			Bebida bebida = arregloBebida.buscar(id);
			if (bebida != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					arregloBebida.eliminar(arregloBebida.buscar(leerId()));
					listar();
					editarFila();
				}
			}
			
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0){
		String id = leerId();
		String nombre = leerNombre();
		int tipoBebida = leerTipoBebida();
		String marca = leerMarca();
		double precio = leerPrecio();
		boolean estado = establecerEstado();
		
		//Validar
		if(id.isEmpty() || nombre.isEmpty() || String.valueOf(precio).length() == 0 || marca.length() > 50 ){
			mensaje("tiene que rellenar todos los campos");
			return ;
		}
			
		if (btnAdicionar.isEnabled() == false) {
			Bebida bebidaNueva = new Bebida(id, nombre, tipoBebida, marca, precio, estado);
			arregloBebida.adicionar(bebidaNueva);
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			
			Bebida bebidaModificada = arregloBebida.buscar(id);
			bebidaModificada.setIdBebida(id);
			bebidaModificada.setNombre(nombre);
			bebidaModificada.setTipoBebida(tipoBebida);
			bebidaModificada.setPrecio(precio);
			bebidaModificada.setEstado(estado);
			
			arregloBebida.actualizarArchivo();
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
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCliente.getSelectedRow();
		if (modelo.getRowCount() == arregloBebida.tamano() - 1)
			posFila = arregloBebida.tamano() - 1;
		if (posFila == arregloBebida.tamano())
			posFila --;
		modelo.setRowCount(0);
		Bebida bebida;
		for (int i=0; i<arregloBebida.tamano(); i++) {
			bebida = arregloBebida.obtener(i);
			Object[] fila = { 
					bebida.getIdBebida(),
					bebida.getNombre(),
					IntAStringTipoPiqueo(bebida.getTipoBebida()),
					bebida.getMarca(),
					bebida.getPrecio(),
					BooleanToString(bebida.isEstado())
					};
			modelo.addRow(fila);
		}
		if (arregloBebida.tamano() > 0)
			tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	String IntAStringTipoPiqueo(int tipo) {
		switch (tipo) {
		case 0:
			return "Cerveza";
		case 1:
			return "Vinos";
		case 2:
			return "Whisky";
		case 3:
			return "Ron";
		case 4:
			return "Frutado";
		case 5:
			return "Combinación preparada";
		default:
			return "Agua embotellada";
		}
	}
	
	String BooleanToString(boolean estado) {
		if(estado)
			return "Habilitado";
		
		return "Inhabilitado" ;
	}
	
	void editarFila() {
		if (arregloBebida.tamano() == 0)
			limpieza();
		else {
			Bebida bebida = arregloBebida.obtener(tblCliente.getSelectedRow());
			
			txtID.setText("" + bebida.getIdBebida());
			txtNombre.setText("" + bebida.getNombre());
			cbTipoBebida.setSelectedIndex(bebida.getTipoBebida());
			txtPrecio.setText("" + bebida.getPrecio());
			cboEstado.setSelectedIndex(BooleanToInt(bebida.isEstado()));
		}
	}
	
	int BooleanToInt (boolean estado) {
		if(estado)
			return 0;
		return 1;
	}
	
	void limpieza() {
		txtID.setText("" + arregloBebida.numeroCorrelativo());
		txtNombre.setText("");
		cbTipoBebida.setSelectedIndex(-1);
		txtPrecio.setText("");
		cboEstado.setSelectedIndex(1);
		txtMarca.setText("");
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
		cboEstado.setEnabled(sino);
		txtPrecio.setEnabled(sino);
		cboEstado.setEnabled(sino);
		cbTipoBebida.setEnabled(sino);
		txtMarca.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  Metodos que retornan valor (sin parametros)
	
	String leerMarca() {
		return txtMarca.getText();
	}
	double leerPrecio () {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	int leerTipoBebida() {
		return cbTipoBebida.getSelectedIndex();
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
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