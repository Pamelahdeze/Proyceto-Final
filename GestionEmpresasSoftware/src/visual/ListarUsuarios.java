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


import logico.Empresa;
import logico.Usuario;

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

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textBuscar;
	private JTable tableUsuarios;
	private DefaultTableModel modeloTabla;
    private List<Usuario> usuarios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarUsuarios dialog = new ListarUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarUsuarios() {
		setBounds(100, 100, 583, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlHighlight);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Listado de Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 34, 555, 298);
			contentPanel.add(panel);
			
			JLabel lblBuscar = new JLabel("Buscar (nombre):");
			lblBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			
			textBuscar = new JTextField();
			textBuscar.setToolTipText("");
			textBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if(!textBuscar.getText().isEmpty()) {
					    Usuario user = Empresa.getInstance().obtenerUsuario(textBuscar.getText());
					    if(user!=null) {
					    	usuarios.clear();
					    	usuarios.add(user);
					    	llenarTablaUsuarios();
					    }else {
					    	Empresa.getInstance().obtenerDatos();
							usuarios = Empresa.getInstance().getMisUsuarios();
							llenarTablaUsuarios();
					    }
					}
				}
			});
			textBuscar.setColumns(20);
			
			JLabel label = new JLabel("X");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
						ListarUsuarios.this.dispose();
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
			
			tableUsuarios = new JTable();
			tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableUsuarios.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Usuario", "Tipo"
				}
			));
			scrollPane.setViewportView(tableUsuarios);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAgregar = new JButton("Agregar");
				btnAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegistrarUsuario usuariosDialog = new RegistrarUsuario();
						usuariosDialog.setModal(true);
						usuariosDialog.setLocationRelativeTo(null);
						usuariosDialog.setVisible(true);
						usuarios = Empresa.getInstance().getMisUsuarios();
						llenarTablaUsuarios();
					}
				});
				buttonPane.add(btnAgregar);
			}
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						 if (tableUsuarios.getSelectedRow() != -1) {
							int dialogResult = JOptionPane.showConfirmDialog(null,
									"Está a punto de eliminar un registro, ¿Desea continuar?", "Confirmación",
									JOptionPane.YES_NO_OPTION);
							if (dialogResult == JOptionPane.YES_OPTION) {
								eliminar();
								usuarios = Empresa.getInstance().getMisUsuarios();
								llenarTablaUsuarios();
								JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente", "Información",
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
						if(tableUsuarios.getSelectedRow() != -1)
							modificar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		usuarios = Empresa.getInstance().getMisUsuarios();
		llenarTablaUsuarios();
	}
	
	private void modificar() {
	    String nombreUsuario = (String) modeloTabla.getValueAt(tableUsuarios.getSelectedRow(), 0);
		RegistrarUsuario.usuario = Empresa.getInstance().obtenerUsuario(nombreUsuario);
		RegistrarUsuario usuarioDialog = new RegistrarUsuario();
		usuarioDialog.setModal(true);
		usuarioDialog.setLocationRelativeTo(null);
		usuarioDialog.setVisible(true);
		RegistrarUsuario.usuario = null;
		usuarios = Empresa.getInstance().getMisUsuarios();
		llenarTablaUsuarios();
	}
	
	private void eliminar() {
		String nombreUsuario = (String) modeloTabla.getValueAt(tableUsuarios.getSelectedRow(), 0);
		Usuario usuario = Empresa.getInstance().obtenerUsuario(nombreUsuario);
		Empresa.getInstance().eliminarUsuario(usuario);
	}

	private void llenarTablaUsuarios() {
	        modeloTabla = (DefaultTableModel) tableUsuarios.getModel();
	        int filas = modeloTabla.getRowCount();
	        for(int i = filas-1; i >= 0 ;i--){
	            modeloTabla.removeRow(i);
	        }
	        for(Usuario usuario: usuarios){
	            modeloTabla.addRow(new Object[]{usuario.getNombre(),usuario.getTipo()});
	        }
	}
}
