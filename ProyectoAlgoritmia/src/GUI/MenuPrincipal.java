package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 361);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu Mantenimiento = new JMenu("Mantenimiento");
		menuBar.add(Mantenimiento);

		JMenuItem mntmNewMenuItem = new JMenuItem("Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgUsuario u = new DlgUsuario();
				u.setVisible(true);
			}
		});
		Mantenimiento.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cliente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCliente c = new DlgCliente();
				c.setVisible(true);
			}
		});
		Mantenimiento.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Genero");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgGenero g = new DlgGenero();
				g.setVisible(true);
			}
		});
		Mantenimiento.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Artista");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgArtista a = new DlgArtista();
				a.setVisible(true);
			}
		});
		Mantenimiento.add(mntmNewMenuItem_3);

//		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cancion");
//		mntmNewMenuItem_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DlgCancion c = new DlgCancion();
//				c.setVisible(true);
//			}
//		});
//		Mantenimiento.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Bebida");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgBebida b = new DlgBebida();
				b.setVisible(true);
			}
		});
		Mantenimiento.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Piqueo");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPiqueo p = new DlgPiqueo();
				p.setVisible(true);
			}
		});
		Mantenimiento.add(mntmNewMenuItem_6);

		JMenu RegisPed = new JMenu("Registro de Pedido");
		menuBar.add(RegisPed);

		JMenu RegisCon = new JMenu("Registro de Consumo");
		menuBar.add(RegisCon);

		JMenu Consultas = new JMenu("Consultas");
		menuBar.add(Consultas);

		JMenu Reportes = new JMenu("Reportes");
		menuBar.add(Reportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
