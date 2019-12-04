package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import logico.Empresa;
import logico.Trabajador;
import logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	JMenuItem mntmRegistrarUsuario;
	JMenuItem mntmRegistrarTrabajador;
	JLabel lblUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				    frame.inicioSesion();
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
	
		setUndecorated(true);
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
		
		mntmRegistrarTrabajador = new JMenuItem("Registrar Trabajador");
		mntmRegistrarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    RegTrabajador	worker = new RegTrabajador();
				worker.setModal(true);
				worker.setLocationRelativeTo(null);
				worker.setVisible(true);
				
			}
		});
		mnTrabajador.add(mntmRegistrarTrabajador);
		
		JMenuItem mntmListarTrabajdor = new JMenuItem("Listar Trabajador");
		mntmListarTrabajdor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListTrabajadores listarTrabajadoresDialog = new ListTrabajadores();
				listarTrabajadoresDialog.setModal(true);
				listarTrabajadoresDialog.setLocationRelativeTo(null);
				listarTrabajadoresDialog.setVisible(true);
			}
		});
		mnTrabajador.add(mntmListarTrabajdor);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/team.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente clienteDialog = new RegistrarCliente();
				clienteDialog.setModal(true);
				clienteDialog.setLocationRelativeTo(null);
				clienteDialog.setVisible(true);
			}
		});
		mnCliente.add(mntmRegistrarCliente);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
		mntmListarClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios clientesDialog = new ListarUsuarios();
				clientesDialog.setModal(true);
				clientesDialog.setLocationRelativeTo(null);
				clientesDialog.setVisible(true);
			}
		});
		mnCliente.add(mntmListarClientes);
		
		JMenu mnContrato = new JMenu("Contrato");
		menuBar.add(mnContrato);
		
		JMenuItem mntmRealizarContrato = new JMenuItem("Realizar Contrato");
		mntmRealizarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegistrarContrato contratoDialog = new RegistrarContrato();
				contratoDialog.setModal(true);
				contratoDialog.setLocationRelativeTo(null);
				contratoDialog.setVisible(true);
			}
		});
		mnContrato.add(mntmRealizarContrato);
		
		JMenuItem mntmModificarContrato = new JMenuItem("Modificar Contrato");
		mntmModificarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegistrarContrato modificarcontratoDialog = new RegistrarContrato();
				modificarcontratoDialog.setModal(true);
				modificarcontratoDialog.setLocationRelativeTo(null);
				modificarcontratoDialog.setVisible(true);
			}
		});
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
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		mntmRegistrarUsuario = new JMenuItem("Registrar Usuario");
		mntmRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarUsuario usuariosDialog = new RegistrarUsuario();
				usuariosDialog.setModal(true);
				usuariosDialog.setLocationRelativeTo(null);
				usuariosDialog.setVisible(true);
			}
		});
		mnUsuarios.add(mntmRegistrarUsuario);
		
		JMenuItem mntmListarUsuarios = new JMenuItem("Listar Usuarios");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarUsuarios listarUsuariosDialog = new ListarUsuarios();
				listarUsuariosDialog.setModal(true);
				listarUsuariosDialog.setLocationRelativeTo(null);
				listarUsuariosDialog.setVisible(true);
			}
		});
		mnUsuarios.add(mntmListarUsuarios);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				System.exit(0);
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setVisible(false);
		lblUsuario.setFont(new Font("Tahoma", Font.ITALIC, 21));
		lblUsuario.setBounds(0, 11, 1350, 26);
		contentPane.add(lblUsuario);
		
		
		
	}
	
	private void inicioSesion() {
		Login login = new Login();
		login.setModal(true);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		
		if(!login.loginOk) {
			System.exit(0);
		}
		
		Usuario user = Empresa.getInstance().usuarioLogeado;
		if(user.getTipo().equals("Cliente")) {
			activarModoCliente();
		}
		//una chuleria que puse para quien inicie sesion
		lblUsuario.setText("Bienvenid@ "+user.getNombre());
		lblUsuario.setVisible(true);
	}
	
	private void activarModoCliente() {
		mntmRegistrarTrabajador.setEnabled(false);
		mntmRegistrarUsuario.setEnabled(false);
	}
}
