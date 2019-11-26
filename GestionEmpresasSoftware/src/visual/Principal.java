package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Trabajador;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-100);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTrabajador = new JMenu("Trabajador");
		mnTrabajador.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/operator.png")));
		menuBar.add(mnTrabajador);
		
		JMenuItem mntmRegistrarTrabajador = new JMenuItem("Registrar Trabajador");
		mntmRegistrarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegTrabajador	worker = new RegTrabajador();
				worker.setModal(true);
				worker.setLocationRelativeTo(null);
				worker.setVisible(true);
				
			}
		});
		mnTrabajador.add(mntmRegistrarTrabajador);
		
		JMenuItem mntmListarTrabajdor = new JMenuItem("Listar Trabajdor");
		mnTrabajador.add(mntmListarTrabajdor);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/team.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mnCliente.add(mntmRegistrarCliente);
		
		JMenu mnContrato = new JMenu("Contrato");
		menuBar.add(mnContrato);
		
		JMenuItem mntmRealizarContrato = new JMenuItem("Realizar Contrato");
		mnContrato.add(mntmRealizarContrato);
		
		JMenuItem mntmModificarContrato = new JMenuItem("Modificar Contrato");
		mnContrato.add(mntmModificarContrato);
		
		JMenu mnProyectos = new JMenu("Proyecto");
		menuBar.add(mnProyectos);
		
		JMenuItem mntmRegistrarProyecto = new JMenuItem("Registrar Proyecto");
		mntmRegistrarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegProyecto project = new RegProyecto();
				project.setModal(true);
				project.setLocationRelativeTo(null);
				project.setVisible(true);
			}
		});
		mnProyectos.add(mntmRegistrarProyecto);
		
		JMenuItem mntmListarProyectos = new JMenuItem("Listar Proyectos");
		mnProyectos.add(mntmListarProyectos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
