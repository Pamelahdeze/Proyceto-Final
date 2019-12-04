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
import javax.swing.JLabel;
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
		tableTrabajadores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID","Nombre", "Tipo", "Direccion", "Salario"
			}
		));
		tableTrabajadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			/*String country;
				int delivery;*/
				if(tableTrabajadores.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = tableTrabajadores.getSelectedRow();
					code = (int)tableTrabajadores.getModel().getValueAt(index, 0);
					/*country = (String)tableSupply.getModel().getValueAt(index, 1);
					delivery = (Integer)tableSupply.getModel().getValueAt(index, 2);
					textFldSupplyName.setText(name);
					spnDelivery.getModel().setValue(Integer.valueOf(delivery));
					cbCountry.getModel().setSelectedItem(new String(country));*/
				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"ID","Nombre", "Apellidos", "Pago-Hora","Tipo"};
		tableModel.setColumnIdentifiers(columnNames);
		//loadTrabajador(0);
		scrollPane.setViewportView(tableTrabajadores);
		
			
			JLabel lblTipoDeTrabajador = new JLabel("Tipo de Trabajador:");
			lblTipoDeTrabajador.setBounds(10, 32, 111, 14);
			panel.add(lblTipoDeTrabajador);
			
			JComboBox cbxTipoTrabajador = new JComboBox();
			cbxTipoTrabajador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Dise\u00F1ador", "Jefe de Proyecto", "Programador", "Planificador"}));
			cbxTipoTrabajador.setBounds(118, 29, 124, 20);
			panel.add(cbxTipoTrabajador);
			
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
				JButton btnAgregar = new JButton("Agregar");
				buttonPane.add(btnAgregar);
	
				JButton btnModificar = new JButton("Modificar");
				buttonPane.add(btnModificar);
				{
					JButton btnEliminar = new JButton("Eliminar");
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
			private void llenarTablaTrabajadores() {
		        modeloTabla = (DefaultTableModel) tableTrabajadores.getModel();
		        int filas = modeloTabla.getRowCount();
		        for(int i = filas-1; i >= 0 ;i--){
		            modeloTabla.removeRow(i);
		        }
		        for(Trabajador trabajador: trabajadores){
		            modeloTabla.addRow(new Object[]{trabajador.getIdentificador(),trabajador.getNombre(),trabajador.getClass().getName(),trabajador.getDireccion(),trabajador.getSalario()});
		        }
		   }
	}
