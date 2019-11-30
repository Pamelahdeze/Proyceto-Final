package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListTrabajadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private static JButton btnModificar;
	JComboBox cbxTipoTrabajador;
	private int code;

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
			
			
	
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			/*String country;
				int delivery;*/
				if(table.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = table.getSelectedRow();
					code = (int)table.getModel().getValueAt(index, 0);
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
		scrollPane.setViewportView(table);
		
			
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
			
		/*	public static void loadTrabajador(int selection) {
				tableModel.setRowCount(0);
				fila = new Object[tableModel.getColumnCount()];
				switch (selection) {
				case 0:
					for (Trabajador aux : Empresa.getInstance().getMisTrabajadores()) {
						fila[0] = aux.getId();
						fila[1] = aux.getNombre();
						fila[2] = aux.getApellidos();
						fila[3] = aux.get();
						if(aux instanceof Libro)
							fila[4] = "Libro";
						if(aux instanceof Revista)
							fila[4] = "Revista";
						if(aux instanceof Articulo)
							fila[4] = "Artículo";
						
						tableModel.addRow(fila);
					}
					break;
				case 1:
					for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
						if(aux instanceof Articulo){
						fila[0] = aux.getId();
						fila[1] = aux.getTitulo();
						fila[2] = aux.getAutor();
						fila[3] = aux.getMateria();
						fila[4] = "Artículo";
						
						tableModel.addRow(fila);
						}
					}
					break;	
				case 2:
					for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
						if(aux instanceof Libro){
						fila[0] = aux.getId();
						fila[1] = aux.getTitulo();
						fila[2] = aux.getAutor();
						fila[3] = aux.getMateria();
						fila[4] = "Libro";
						
						tableModel.addRow(fila);
						}
					}
					break;	
				case 3:
					for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
						if(aux instanceof Revista){
						fila[0] = aux.getId();
						fila[1] = aux.getTitulo();
						fila[2] = aux.getAutor();
						fila[3] = aux.getMateria();
						fila[4] = "Revista";
						
						tableModel.addRow(fila);
						}
					}
					break;	
				}
				
				
				table.setModel(tableModel);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(60);
				columnModel.getColumn(1).setPreferredWidth(180);
				columnModel.getColumn(2).setPreferredWidth(150);
				columnModel.getColumn(3).setPreferredWidth(130);
				columnModel.getColumn(4).setPreferredWidth(81);
				/*if(tableModel.getRowCount()==0){
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}*/
				
				
			}	*/
	
	}
}
}
