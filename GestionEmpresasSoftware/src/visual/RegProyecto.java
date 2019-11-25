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
import javax.swing.DefaultComboBoxModel;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreProyecto;

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
		setBounds(100, 100, 508, 438);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 136, 470, 219);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProgramadoresDisponibles = new JLabel("Programadores Disponibles:");
		lblProgramadoresDisponibles.setBounds(10, 11, 175, 14);
		panel_1.add(lblProgramadoresDisponibles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 157, 172);
		panel_1.add(scrollPane);
		
		JList listProgDisp = new JList();
		scrollPane.setViewportView(listProgDisp);
		
		JLabel lblProgramadoresSeleccionados = new JLabel("Programadores Seleccionados:");
		lblProgramadoresSeleccionados.setBounds(269, 11, 191, 14);
		panel_1.add(lblProgramadoresSeleccionados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(292, 36, 157, 172);
		panel_1.add(scrollPane_1);
		
		JList listProgSelect = new JList();
		scrollPane_1.setViewportView(listProgSelect);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.setBounds(187, 84, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setBounds(187, 118, 89, 23);
		panel_1.add(btnNewButton_1);
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
