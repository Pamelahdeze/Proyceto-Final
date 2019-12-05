package visual;

import java.awt.BorderLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 702, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 666, 316);
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
			lblTipoDeTrabajador.setBounds(10, 32, 111, 14);
			panel.add(lblTipoDeTrabajador);
			
			JComboBox cbxTipoTrabajador = new JComboBox();
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
			cbxTipoTrabajador.setBounds(118, 29, 124, 20);
			panel.add(cbxTipoTrabajador);
			
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
				JButton btnAgregar = new JButton("Agregar");
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
	
				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificar();
					}
				});
				buttonPane.add(btnModificar);
				{
					JButton btnEliminar = new JButton("Eliminar");
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
				{
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					btnCancelar.setActionCommand("Cancel");
					buttonPane.add(btnCancelar);
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
