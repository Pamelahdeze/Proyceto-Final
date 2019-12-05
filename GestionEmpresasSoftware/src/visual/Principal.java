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
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Color;

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
		menuBar.setBorder(new LineBorder(SystemColor.desktop, 2, true));
		menuBar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		menuBar.setBackground(SystemColor.activeCaptionBorder);
		setJMenuBar(menuBar);
		
		JMenu mnTrabajador = new JMenu("Trabajador");
		mnTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnTrabajador.setHorizontalTextPosition(SwingConstants.LEADING);
		mnTrabajador.setForeground(SystemColor.desktop);
		mnTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mnTrabajador.setHorizontalAlignment(SwingConstants.RIGHT);
		mnTrabajador.setBackground(SystemColor.controlShadow);
		mnTrabajador.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/operator.png")));
		menuBar.add(mnTrabajador);
		
		mntmRegistrarTrabajador = new JMenuItem("Registrar Trabajador");
		mntmRegistrarTrabajador.setForeground(SystemColor.desktop);
		mntmRegistrarTrabajador.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmRegistrarTrabajador.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/engineering.png")));
		mntmRegistrarTrabajador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRegistrarTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mntmRegistrarTrabajador.setBackground(SystemColor.controlShadow);
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
		mntmListarTrabajdor.setForeground(SystemColor.desktop);
		mntmListarTrabajdor.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/chart.png")));
		mntmListarTrabajdor.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmListarTrabajdor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmListarTrabajdor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mntmListarTrabajdor.setBackground(SystemColor.controlShadow);
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
		mnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		mnCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		mnCliente.setForeground(SystemColor.desktop);
		mnCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mnCliente.setBackground(SystemColor.controlShadow);
		mnCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/team.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmRegistrarCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/value.png")));
		mntmRegistrarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRegistrarCliente.setBackground(SystemColor.controlShadow);
		mntmRegistrarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
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
		mntmListarClientes.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/chart.png")));
		mntmListarClientes.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmListarClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmListarClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mntmListarClientes.setBackground(SystemColor.controlShadow);
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
		mnContrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnContrato.setHorizontalTextPosition(SwingConstants.LEADING);
		mnContrato.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/contract (1).png")));
		mnContrato.setHorizontalAlignment(SwingConstants.RIGHT);
		mnContrato.setForeground(SystemColor.desktop);
		mnContrato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mnContrato.setBackground(SystemColor.controlShadow);
		menuBar.add(mnContrato);
		
		JMenuItem mntmRealizarContrato = new JMenuItem("Realizar Contrato");
		mntmRealizarContrato.setBorder(new LineBorder(Color.BLACK, 1, true));
		mntmRealizarContrato.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/contract (2).png")));
		mntmRealizarContrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRealizarContrato.setBackground(SystemColor.controlShadow);
		mntmRealizarContrato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
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
		mntmModificarContrato.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/contract (3).png")));
		mntmModificarContrato.setBorder(new LineBorder(Color.BLACK, 1, true));
		mntmModificarContrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmModificarContrato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mntmModificarContrato.setBackground(SystemColor.controlShadow);
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
		mnProyectos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnProyectos.setHorizontalTextPosition(SwingConstants.LEADING);
		mnProyectos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/workstation.png")));
		mnProyectos.setHorizontalAlignment(SwingConstants.RIGHT);
		mnProyectos.setForeground(SystemColor.desktop);
		mnProyectos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mnProyectos.setBackground(SystemColor.controlShadow);
		menuBar.add(mnProyectos);
		
		JMenuItem mntmRegistrarProyecto = new JMenuItem("Registrar Proyecto");
		mntmRegistrarProyecto.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/testing.png")));
		mntmRegistrarProyecto.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmRegistrarProyecto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRegistrarProyecto.setBackground(SystemColor.controlShadow);
		mntmRegistrarProyecto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
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
		mntmListarProyectos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/chart.png")));
		mntmListarProyectos.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmListarProyectos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmListarProyectos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mntmListarProyectos.setBackground(SystemColor.controlShadow);
		mnProyectos.add(mntmListarProyectos);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnUsuarios.setHorizontalTextPosition(SwingConstants.LEADING);
		mnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/users-sign.png")));
		mnUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		mnUsuarios.setForeground(SystemColor.desktop);
		mnUsuarios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mnUsuarios.setBackground(SystemColor.controlShadow);
		menuBar.add(mnUsuarios);
		
		mntmRegistrarUsuario = new JMenuItem("Registrar Usuario");
		mntmRegistrarUsuario.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/user.png")));
		mntmRegistrarUsuario.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmRegistrarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmRegistrarUsuario.setBackground(SystemColor.controlShadow);
		mntmRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
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
		mntmListarUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/chart.png")));
		mntmListarUsuarios.setBorder(new LineBorder(SystemColor.desktop, 1, true));
		mntmListarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmListarUsuarios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mntmListarUsuarios.setBackground(SystemColor.controlShadow);
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
		mnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnSalir.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/logout.png")));
		mnSalir.setHorizontalTextPosition(SwingConstants.LEADING);
		mnSalir.setHorizontalAlignment(SwingConstants.RIGHT);
		mnSalir.setForeground(SystemColor.desktop);
		mnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		mnSalir.setBackground(SystemColor.controlShadow);
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
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new LineBorder(SystemColor.desktop, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setBackground(SystemColor.activeCaption);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setVisible(false);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
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
		
		lblUsuario.setText("Bienvenid@ "+user.getNombre());
		lblUsuario.setVisible(true);
	}
	
	private void activarModoCliente() {
		mntmRegistrarTrabajador.setEnabled(false);
		mntmRegistrarUsuario.setEnabled(false);
	}
}
