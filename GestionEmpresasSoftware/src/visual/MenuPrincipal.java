package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuListener;
import javax.swing.JMenu;

public class MenuPrincipal implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	//Declarando items para el menu
	private JMenuItem registrarCliente = new JMenuItem("Registrar");
	private JMenuItem registrarTrabajador = new JMenuItem("Registrar");
	private JMenuItem realizarContrato = new JMenuItem("Realizar");
	private JMenuItem modificarContrato = new JMenuItem("Modificar");
	private JMenuItem registrarProyecto = new JMenuItem("Registrar");
	private JMenuItem listarProyecto = new JMenuItem("Listar");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//Declarando menus
		JMenu mnTrabajador = new JMenu("Trabajador");
		JMenu mnCliente = new JMenu("Cliente");
		JMenu mnContrato = new JMenu("Contrato");
		JMenu mnProyecto = new JMenu("Proyecto");
		
		//Inicializando items de menu
		registrarCliente = new JMenuItem("Registrar");
		registrarTrabajador = new JMenuItem("Registrar");
		realizarContrato = new JMenuItem("Realizar");
		modificarContrato = new JMenuItem("Modificar");
		registrarProyecto = new JMenuItem("Registrar");
		listarProyecto = new JMenuItem("Listar");
		
		//Agregando items a menus
		mnTrabajador.add(registrarTrabajador);
		mnCliente.add(registrarCliente);
		mnContrato.add(realizarContrato);
		mnContrato.add(modificarContrato);
		mnProyecto.add(registrarProyecto);
		mnProyecto.add(listarProyecto);
		
		//Agrendo menus a la barra
		menuBar.add(mnTrabajador);
		menuBar.add(mnCliente);
		menuBar.add(mnContrato);
		menuBar.add(mnProyecto);
		
		//Agregando la clase que escucha los eventos del item
		registrarCliente.addActionListener(this);
		registrarTrabajador.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem opcionSeleccionada = (JMenuItem)arg0.getSource();
		if(opcionSeleccionada.equals(registrarTrabajador)){
			//JOptionPane.showMessageDialog(frame, "Registro de usuarios");
			
		}else if(opcionSeleccionada.equals(registrarCliente)) {
			
		}
	}

}
