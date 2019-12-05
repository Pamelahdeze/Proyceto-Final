package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Cliente;
import logico.Empresa;
import logico.Trabajador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class ListTrabajadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tableTrabajadores;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private static JButton btnModificar;
	JComboBox cbxTipoTrabajador;
	private int code;
	private DefaultTableModel modeloTabla;
	private List<Trabajador> trabajadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListTrabajadores dialog = new ListTrabajadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListTrabajadores() {
		setBounds(100, 100, 691, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new TitledBorder(null, "Listado de Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 37, 666, 316);
		contentPanel.add(panel);
		panel.setLayout(null);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 57, 646, 248);
			panel.add(scrollPane);
			
			
	
		
		tableTrabajadores = new JTable();
		tableTrabajadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTrabajadores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID","Nombre", "Tipo", "Direccion", "Salario"
			}
		));
		/*tableTrabajadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(tableTrabajadores.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = tableTrabajadores.getSelectedRow();
					code = (int)tableTrabajadores.getModel().getValueAt(index, 0);
				}
			}
		});*/
		tableModel = new DefaultTableModel();
		String[] columnNames = {"ID","Nombre", "Apellidos", "Pago-Hora","Tipo"};
		tableModel.setColumnIdentifiers(columnNames);
		//loadTrabajador(0);
		scrollPane.setViewportView(tableTrabajadores);
		
			
			JLabel lblTipoDeTrabajador = new JLabel("Tipo de Trabajador:");
			lblTipoDeTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblTipoDeTrabajador.setBounds(10, 32, 111, 14);
			panel.add(lblTipoDeTrabajador);
			
			JComboBox cbxTipoTrabajador = new JComboBox();
			cbxTipoTrabajador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			cbxTipoTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbxTipoTrabajador.getSelectedIndex() == 0) {
						trabajadores = Empresa.getInstance().getMisTrabajadores();
					}else if(cbxTipoTrabajador.getSelectedIndex() == 1) {
						trabajadores = Empresa.getInstance().obtenerTrabajadoresPorTipo("Disenador");
					}else if(cbxTipoTrabajador.getSelectedIndex() == 2) {
						trabajadores = Empresa.getInstance().obtenerTrabajadoresPorTipo("JefeProyecto");
					}else if(cbxTipoTrabajador.getSelectedIndex() == 3) {
						trabajadores = Empresa.getInstance().obtenerTrabajadoresPorTipo("Programador");
					}
					else if(cbxTipoTrabajador.getSelectedIndex() == 4) {
						trabajadores = Empresa.getInstance().obtenerTrabajadoresPorTipo("Planificador");
					}
					llenarTablaTrabajadores();
				}
			});
			cbxTipoTrabajador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Dise\u00F1ador", "Jefe de Proyecto", "Programador", "Planificador"}));
			cbxTipoTrabajador.setBounds(137, 29, 124, 20);
			panel.add(cbxTipoTrabajador);
			
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBackground(SystemColor.controlHighlight);
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
				JButton btnAgregar = new JButton("Agregar");
				btnAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegTrabajador	worker = new RegTrabajador();
						worker.setModal(true);
						worker.setLocationRelativeTo(null);
						worker.setVisible(true);
						llenarTablaTrabajadores();
					}
				});
				buttonPane.add(btnAgregar);
				
				JLabel label = new JLabel("X");
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
							ListTrabajadores.this.dispose();
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
				label.setBounds(656, 11, 20, 20);
				contentPanel.add(label);
	
				JButton btnModificar = new JButton("Modificar");
				btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificar();
					}
				});
				buttonPane.add(btnModificar);
				{
					JButton btnEliminar = new JButton("Eliminar");
					btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (tableTrabajadores.getSelectedRow() != -1) {
								int dialogResult = JOptionPane.showConfirmDialog(null,
										"Está a punto de eliminar un registro, ¿Desea continuar?", "Confirmación",
										JOptionPane.YES_NO_OPTION);
								if (dialogResult == JOptionPane.YES_OPTION) {
									eliminar();
									trabajadores = Empresa.getInstance().getMisTrabajadores();
									llenarTablaTrabajadores();
									JOptionPane.showMessageDialog(null, "Trabajador eliminado exitosamente", "Información",
											JOptionPane.INFORMATION_MESSAGE);
								} 
							}
						}
					});
					btnEliminar.setActionCommand("OK");
					buttonPane.add(btnEliminar);
					getRootPane().setDefaultButton(btnEliminar);
				}
			}
			
			trabajadores = Empresa.getInstance().getMisTrabajadores();	
			llenarTablaTrabajadores();
			}
	
			private void modificar() {
			    String codigoTrabajador = (String) modeloTabla.getValueAt(tableTrabajadores.getSelectedRow(), 0);
				RegTrabajador.trabajador = Empresa.getInstance().obtenerTrabajador(codigoTrabajador);
				RegTrabajador trabajadorDialog = new RegTrabajador();
				trabajadorDialog.setModal(true);
				trabajadorDialog.setLocationRelativeTo(null);
				trabajadorDialog.setVisible(true);
				RegTrabajador.trabajador = null;
				trabajadores = Empresa.getInstance().getMisTrabajadores();
				llenarTablaTrabajadores();
			}
	
			private void eliminar() {
				String codigoTrabajador = (String) modeloTabla.getValueAt(tableTrabajadores.getSelectedRow(), 0);
				Trabajador trabajad = Empresa.getInstance().obtenerTrabajador(codigoTrabajador);
				Empresa.getInstance().eliminarTrabajador(trabajad);
				
			}
			private void llenarTablaTrabajadores() {
		        modeloTabla = (DefaultTableModel) tableTrabajadores.getModel();
		        int filas = modeloTabla.getRowCount();
		        for(int i = filas-1; i >= 0 ;i--){
		            modeloTabla.removeRow(i);
		        }
		        for(Trabajador trabajador: trabajadores){
		            modeloTabla.addRow(new Object[]{trabajador.getIdentificador(),trabajador.getNombre(),trabajador.getClass().getSimpleName(),trabajador.getDireccion(),trabajador.getSalario()});
		        }
		   }
	}
