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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Disenador;
import logico.Empresa;
import logico.Programador;
import logico.Proyecto;
import logico.Trabajador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreProyecto;
	private DefaultListModel<String> PDisp = new DefaultListModel<String>();
	private DefaultListModel<String> PSelect = new DefaultListModel<String>();
	private JComboBox cbxTipoProyecto;
	private JComboBox cbxLenguajeProyecto;
	private JComboBox cbxEstadoProyecto;

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

	//No me deja
	/**
	 * Create the dialog.
	 */
	public RegProyecto() {
		setUndecorated(true);
		setBounds(100, 100, 508, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
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
		
		cbxTipoProyecto = new JComboBox();
		cbxTipoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "App M\u00F3vil", "Escritorio", "Web"}));
		cbxTipoProyecto.setBounds(60, 69, 146, 20);
		panel.add(cbxTipoProyecto);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(239, 33, 46, 14);
		panel.add(lblEstado);
		
		cbxEstadoProyecto = new JComboBox();
		cbxEstadoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "En curso", "Atrasado", "Finalizado"}));
		cbxEstadoProyecto.setBounds(305, 33, 146, 20);
		panel.add(cbxEstadoProyecto);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setBounds(239, 69, 61, 14);
		panel.add(lblLenguaje);
		
		cbxLenguajeProyecto = new JComboBox();
		cbxLenguajeProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Java", "C#", "Python", "C++"}));
		cbxLenguajeProyecto.setBounds(305, 69, 146, 20);
		panel.add(cbxLenguajeProyecto);
		
		for (Trabajador allworkers : Empresa.getInstance().getMisTrabajadores()) {
			if(allworkers instanceof Programador) {
				PDisp.addElement(allworkers.getIdentificador()+", -"+allworkers.getNombre());
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Next");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCampos()) {
							Empresa.proyectoCreacion = new Proyecto(String.valueOf(cbxTipoProyecto.getSelectedItem()), txtNombreProyecto.getText(), String.valueOf(cbxLenguajeProyecto.getSelectedItem()), String.valueOf(cbxEstadoProyecto.getSelectedItem()));
							Empresa.proyectoCreacion.setTrabajadores(new ArrayList<Trabajador>());
							RegistrarJefe registroJefeDialog = new RegistrarJefe();
							registroJefeDialog.setModal(true);
							registroJefeDialog.setLocationRelativeTo(null);
							registroJefeDialog.setVisible(true);
						}
					}
				});
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
	
	private boolean validarCampos() {
		String mensajeValidacion = "";
		boolean datosValidos = true;
		
		if(txtNombreProyecto.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo nombre es necesario\n";
			datosValidos = false;
		}
		if(cbxEstadoProyecto.getSelectedIndex() == 0) {
			mensajeValidacion += "*El campo estado es necesario\n";
			datosValidos = false;
		}
		if(cbxLenguajeProyecto.getSelectedIndex() == 0) {
			mensajeValidacion += "*El Lenguaje es necesario\n";
			datosValidos = false;
		}
		if(cbxTipoProyecto.getSelectedIndex() == 0) {
			mensajeValidacion += "*El tipo de proyecto es necesario \n";
			datosValidos = false;
		} 
		if(datosValidos == false) {
			JOptionPane.showMessageDialog(this, mensajeValidacion, "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
		return datosValidos;
	}
}
