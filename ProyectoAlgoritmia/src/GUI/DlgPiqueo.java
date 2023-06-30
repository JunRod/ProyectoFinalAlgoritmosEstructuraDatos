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

import Arreglos.ArregloPiqueo;
import Clases.Artista;
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


public class DlgPiqueo extends JDialog implements ActionListener, KeyListener, MouseListener {
	
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
					DlgPiqueo dialog = new DlgPiqueo();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgPiqueo() {
		setResizable(false);
		setTitle("Mantenimiento | Piqueo");
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
		modelo.addColumn("Tipo de Piqueo");
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
		lblDireccion.setBounds(10, 151, 141, 23);
		getContentPane().add(lblDireccion);
		
		cboEstado = new JComboBox<String>(Diccionario.estado);
		cboEstado.setSelectedIndex(1);
		cboEstado.setEnabled(false);
		cboEstado.setBounds(165, 150, 156, 23);
		getContentPane().add(cboEstado);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 49, 88, 16);
		getContentPane().add(lblNewLabel);
		
		lblAlbum = new JLabel("Precio");
		lblAlbum.setBounds(10, 119, 88, 16);
		getContentPane().add(lblAlbum);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(165, 116, 85, 22);
		getContentPane().add(txtPrecio);
		
		lblNewLabel_1 = new JLabel("Tipo de piqueo");
		lblNewLabel_1.setBounds(10, 85, 150, 16);
		getContentPane().add(lblNewLabel_1);
		
		cbTipoPiqueo = new JComboBox(Diccionario.tipoPiqueo);
		cbTipoPiqueo.setBounds(165, 81, 156, 24);
		getContentPane().add(cbTipoPiqueo);
		
		Diccionario.generarTodosLosIDArtista();
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		habilitarEntradas(false);
	}
	
	JComboBox cbTipoPiqueo;
	JComboBox<String> cboEstado;
	ArregloPiqueo arregloPiqueo = new ArregloPiqueo();
	private JTextField txtNombre;
	private JTextField txtID;
	private JLabel lblDireccion;
	private JLabel lblNewLabel;
	private JLabel lblAlbum;
	private JTextField txtPrecio;
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
		if (arregloPiqueo.tamano() == 0) {
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
		
		if (arregloPiqueo.tamano() == 0)
			mensaje("No existen piqueos");
		else {
			editarFila();
			habilitarEntradas(false);
			String id = leerId();
			Piqueo piqueo = arregloPiqueo.buscar(id);
			if (piqueo != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					arregloPiqueo.eliminar(arregloPiqueo.buscar(leerId()));
					listar();
					editarFila();
				}
			}
			
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0){
		String id = leerId();
		String nombre = leerNombre();
		int tipoPiqueo = leerTipoPiqueo();
		double precio = leerPrecio();
		boolean estado = establecerEstado();
		
		//Validar
		if(id.isEmpty() || nombre.isEmpty() || String.valueOf(precio).length() == 0 ){
			mensaje("tiene que rellenar todos los campos");
			return ;
		}
			
		if (btnAdicionar.isEnabled() == false) {
			Piqueo piqueoNuevo = new Piqueo(id, nombre, tipoPiqueo, precio, estado);
			arregloPiqueo.adicionar(piqueoNuevo);
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			
			Piqueo piqueoModificado = arregloPiqueo.buscar(id);
			piqueoModificado.setIdPiqueo(id);
			piqueoModificado.setNombre(nombre);
			piqueoModificado.setTipoPiqueo(tipoPiqueo);
			piqueoModificado.setPrecio(precio);
			piqueoModificado.setEstado(estado);
			
			arregloPiqueo.actualizarArchivo();
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
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCliente.getSelectedRow();
		if (modelo.getRowCount() == arregloPiqueo.tamano() - 1)
			posFila = arregloPiqueo.tamano() - 1;
		if (posFila == arregloPiqueo.tamano())
			posFila --;
		modelo.setRowCount(0);
		Piqueo piqueo;
		for (int i=0; i<arregloPiqueo.tamano(); i++) {
			
			piqueo = arregloPiqueo.obtener(i);
			Object[] fila = { 
					piqueo.getIdPiqueo(),
					piqueo.getNombre(),
					IntAStringTipoPiqueo(piqueo.getTipoPiqueo()),
					piqueo.getPrecio(),
					BooleanToString(piqueo.isEstado())
					};
			modelo.addRow(fila);
		}
		if (arregloPiqueo.tamano() > 0)
			tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	String IntAStringTipoPiqueo(int tipo) {
		switch (tipo) {
		case 0:
			return "Frios";
		case 1:
			return "Calientes";
		default:
			return "Snacks";
		}
	}
	
	String BooleanToString(boolean estado) {
		if(estado)
			return "Habilitado";
		
		return "Inhabilitado" ;
	}
	
	void editarFila() {
		if (arregloPiqueo.tamano() == 0)
			limpieza();
		else {
			Piqueo piqueo = arregloPiqueo.obtener(tblCliente.getSelectedRow());
			
			txtID.setText("" + piqueo.getIdPiqueo());
			txtNombre.setText("" + piqueo.getNombre());
			cbTipoPiqueo.setSelectedIndex(piqueo.getTipoPiqueo());
			txtPrecio.setText("" + piqueo.getPrecio());
			cboEstado.setSelectedIndex(BooleanToInt(piqueo.isEstado()));
		}
	}
	
	int BooleanToInt (boolean estado) {
		if(estado)
			return 0;
		return 1;
	}
	
	void limpieza() {
		txtID.setText("" + arregloPiqueo.numeroCorrelativo());
		txtNombre.setText("");
		cbTipoPiqueo.setSelectedIndex(-1);
		txtPrecio.setText("");
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
		txtNombre.setEnabled(sino);
		cboEstado.setEnabled(sino);
		txtPrecio.setEnabled(sino);
		cboEstado.setEnabled(sino);
		cbTipoPiqueo.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  Metodos que retornan valor (sin parametros)
	
	double leerPrecio () {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	int leerTipoPiqueo() {
		return cbTipoPiqueo.getSelectedIndex();
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