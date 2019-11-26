package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Disenador;
import logico.Empresa;
import logico.Programador;
import logico.Trabajador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreProyecto;
	private DefaultListModel<String> PDisp = new DefaultListModel<String>();
	private DefaultListModel<String> PSelect = new DefaultListModel<String>();
	private JList<String> ProgDisp;
	private JList<String> ProgSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegProyecto dialog = new RegProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegProyecto() {
		setBounds(100, 100, 508, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 470, 114);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 61, 14);
		panel.add(lblNombre);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setBounds(60, 33, 146, 20);
		panel.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 72, 46, 14);
		panel.add(lblTipo);
		
		JComboBox cbxTipoProyecto = new JComboBox();
		cbxTipoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "App M\u00F3vil", "Escritorio", "Web"}));
		cbxTipoProyecto.setBounds(60, 69, 146, 20);
		panel.add(cbxTipoProyecto);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(239, 33, 46, 14);
		panel.add(lblEstado);
		
		JComboBox cbxEstadoProyecto = new JComboBox();
		cbxEstadoProyecto.setBounds(305, 33, 146, 20);
		panel.add(cbxEstadoProyecto);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setBounds(239, 69, 61, 14);
		panel.add(lblLenguaje);
		
		JComboBox cbxLenguajeProyecto = new JComboBox();
		cbxLenguajeProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Java", "C#", "Python", "C++"}));
		cbxLenguajeProyecto.setBounds(305, 69, 146, 20);
		panel.add(cbxLenguajeProyecto);
		
		JPanel Tipo = new JPanel();
		Tipo.setBounds(10, 136, 470, 256);
		contentPanel.add(Tipo);
		Tipo.setLayout(null);
		
		JLabel lblDiseadoresDisponibles = new JLabel("Dise\u00F1adores Disponibles:");
		lblDiseadoresDisponibles.setBounds(10, 11, 175, 14);
		Tipo.add(lblDiseadoresDisponibles);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 36, 157, 172);
		Tipo.add(scrollPane_2);
		
		JLabel label_1 = new JLabel("Programadores Seleccionados:");
		label_1.setBounds(269, 11, 191, 14);
		Tipo.add(label_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(292, 36, 157, 172);
		Tipo.add(scrollPane_3);
		
		JButton button = new JButton(">");
		button.setBounds(187, 84, 89, 23);
		Tipo.add(button);
		
		JButton button_1 = new JButton("<");
		button_1.setBounds(187, 118, 89, 23);
		Tipo.add(button_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(314, 222, 89, 23);
		Tipo.add(btnNewButton);
		
		JPanel Lenguaje = new JPanel();
		Lenguaje.setBounds(10, 136, 470, 256);
		contentPanel.add(Lenguaje);
		Lenguaje.setLayout(null);
		
		for (Trabajador allworkers : Empresa.getInstance().getMisTrabajadores()) {
			if(allworkers instanceof Programador) {
				PDisp.addElement(allworkers.getIdentificador()+", -"+allworkers.getNombre());
			}
			
		}
		
		JLabel lblProgramadoresDisponibles = new JLabel("Programadores Disponibles:");
		lblProgramadoresDisponibles.setBounds(10, 11, 175, 14);
		Lenguaje.add(lblProgramadoresDisponibles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 157, 172);
		Lenguaje.add(scrollPane);
		
		ProgDisp = new JList();
		ProgDisp.setModel(PDisp);
		scrollPane.setViewportView(ProgDisp);
		
		
		JLabel lblProgramadoresSeleccionados = new JLabel("Programadores Seleccionados:");
		lblProgramadoresSeleccionados.setBounds(269, 11, 191, 14);
		Lenguaje.add(lblProgramadoresSeleccionados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(292, 36, 157, 172);
		Lenguaje.add(scrollPane_1);
		
		ProgSelect = new JList();
		ProgSelect.setModel(PSelect);
		scrollPane_1.setViewportView(ProgSelect);
		
		JButton btnAdd = new JButton(">");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> PDisp = ((DefaultListModel<String>)ProgDisp.getModel());
				DefaultListModel<String> PSelect = ((DefaultListModel<String>)ProgSelect.getModel());
				
				for (int cadaProg : ProgDisp.getSelectedIndices()) {
					PSelect.addElement(PDisp.getElementAt(cadaProg));
					PDisp.removeElement(PDisp.getElementAt(cadaProg));
				}
				float val = 0;
				for(int i=0; i < ProgSelect.getModel().getSize(); i++) {
					String LosProgramadores = (String) ProgSelect.getModel().getElementAt(i);
					String[] separadorNombre = LosProgramadores.split("-",2);
					String Nombre = separadorNombre[1];
				}
			}
		});
		btnAdd.setBounds(187, 84, 89, 23);
		Lenguaje.add(btnAdd);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> PDisp = ((DefaultListModel<String>)ProgDisp.getModel());
				DefaultListModel<String> PSelect = ((DefaultListModel<String>)ProgSelect.getModel());
				
				for (int cadaProg : ProgSelect.getSelectedIndices()) {
					PDisp.addElement(PSelect.getElementAt(cadaProg));
					PSelect.removeElement(PSelect.getElementAt(cadaProg));
				}
				float val = 0;
				for(int i=0; i < PSelect.getSize(); i++) {
					String Programmer = (String) PSelect.getElementAt(i);
					String[] sepNombre =Programmer.split("-",2);
					String Nombre = sepNombre[1];
				}
			}
			
		});
		btnReturn.setBounds(187, 118, 89, 23);
		Lenguaje.add(btnReturn);
		
		JButton button_2 = new JButton("Aceptar");
		button_2.setBounds(314, 222, 89, 23);
		Lenguaje.add(button_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
