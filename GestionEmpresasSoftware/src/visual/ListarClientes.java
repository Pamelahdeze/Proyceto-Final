package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Empresa;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textBuscar;
	private JTable tableClientes;
	private DefaultTableModel modeloTabla;
    private List<Cliente> clientes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarClientes dialog = new ListarClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarClientes() {
		setBounds(100, 100, 580, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setForeground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlHighlight);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Listado de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 47, 555, 298);
			contentPanel.add(panel);
			
			JLabel lblBuscar = new JLabel("Buscar (c\u00F3digo):");
			lblBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			
			textBuscar = new JTextField();
			textBuscar.setToolTipText("");
			textBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if(!textBuscar.getText().isEmpty()) {
					    Cliente cli = Empresa.getInstance().obtenerCliente(textBuscar.getText());
					    if(cli!=null) {
					    	clientes.clear();
					    	clientes.add(cli);
					    	llenarTablaClientes();
					    }else {
					    	Empresa.getInstance().obtenerDatos();
							clientes = Empresa.getInstance().getMisClientes();
							llenarTablaClientes();
					    }
					}
				}
			});
			textBuscar.setColumns(20);
			
			JLabel label = new JLabel("X");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "�Seguro que quiere cerrar la aplicaci�n?","Confirmaci�n",JOptionPane.YES_NO_OPTION) == 0) {
						ListarClientes.this.dispose();
					}

				}
				@Override
				public void mouseEntered(MouseEvent e) {
					label.setForeground(Color.RED);
				}
				public void mouseExited(MouseEvent e) {
					label.setForeground(Color.WHITE);
				}
			});
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
			label.setBounds(545, 11, 20, 20);
			contentPanel.add(label);
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblBuscar)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBuscar)
							.addComponent(textBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(19, Short.MAX_VALUE))
			);
			
			tableClientes = new JTable();
			tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableClientes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nombre", "Direcci\u00F3n", "Cant. Max. Proyectos"
				}
			));
			scrollPane.setViewportView(tableClientes);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setForeground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAgregar = new JButton("Agregar");
				btnAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				//btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegistrarCliente clienteDialog = new RegistrarCliente();
						clienteDialog.setModal(true);
						clienteDialog.setLocationRelativeTo(null);
						clienteDialog.setVisible(true);
						clientes = Empresa.getInstance().getMisClientes();
						llenarTablaClientes();
					}
				});
				buttonPane.add(btnAgregar);
			}
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				//btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						 if (tableClientes.getSelectedRow() != -1) {
							int dialogResult = JOptionPane.showConfirmDialog(null,
									"Est� a punto de eliminar un registro, �Desea continuar?", "Confirmaci�n",
									JOptionPane.YES_NO_OPTION);
							if (dialogResult == JOptionPane.YES_OPTION) {
								eliminar();
								clientes = Empresa.getInstance().getMisClientes();
								llenarTablaClientes();
								JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente", "Informaci�n",
										JOptionPane.INFORMATION_MESSAGE);
							} 
						}
					}
				});
				buttonPane.add(btnEliminar);
			}
			{
				JButton okButton = new JButton("Modificar");
				okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(tableClientes.getSelectedRow() != -1)
							modificar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		clientes = Empresa.getInstance().getMisClientes();
		llenarTablaClientes();
	}
	
	private void modificar() {
	    String codigoCliente = (String) modeloTabla.getValueAt(tableClientes.getSelectedRow(), 0);
		RegistrarCliente.cliente = Empresa.getInstance().obtenerCliente(codigoCliente);
		RegistrarCliente clienteDialog = new RegistrarCliente();
		clienteDialog.setModal(true);
		clienteDialog.setLocationRelativeTo(null);
		clienteDialog.setVisible(true);
		RegistrarCliente.cliente = null;
		clientes = Empresa.getInstance().getMisClientes();
		llenarTablaClientes();
	}
	
	private void eliminar() {
		String codigoCliente = (String) modeloTabla.getValueAt(tableClientes.getSelectedRow(), 0);
		Cliente cliente = Empresa.getInstance().obtenerCliente(codigoCliente);
		Empresa.getInstance().eliminarCliente(cliente);
		
	}

	private void llenarTablaClientes() {
	        modeloTabla = (DefaultTableModel) tableClientes.getModel();
	        int filas = modeloTabla.getRowCount();
	        for(int i = filas-1; i >= 0 ;i--){
	            modeloTabla.removeRow(i);
	        }
	        for(Cliente cliente: clientes){
	            modeloTabla.addRow(new Object[]{cliente.getIndentificador(),cliente.getNombre(),cliente.getDireccion(),cliente.getCantMaxProyectos()});
	        }
	}
}
