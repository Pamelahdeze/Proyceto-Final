package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.Cliente;
import logico.Empresa;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField textId;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JDialog miDialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setTitle("Registrar Cliente");
		setBounds(100, 100, 277, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 11, 46, 14);
		contentPanel.add(lblID);
		
		try {
			textId = new JFormattedTextField(new MaskFormatter("##-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textId.setBounds(66, 8, 97, 20);
		contentPanel.add(textId);
		textId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 42, 46, 14);
		contentPanel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(66, 39, 185, 20);
		contentPanel.add(textNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 76, 64, 14);
		contentPanel.add(lblDireccin);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(66, 70, 185, 20);
		contentPanel.add(textDireccion);
		
		JLabel lblCantidadProyectos = new JLabel("Cantidad Proyectos:");
		lblCantidadProyectos.setBounds(10, 113, 109, 14);
		contentPanel.add(lblCantidadProyectos);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(123, 110, 40, 20);
		contentPanel.add(spinnerCantidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCamposCliente())
						{	
							Cliente cliente = new Cliente(textId.getText(),textNombre.getText(),textDireccion.getText());
							Empresa.getInstance().RegistrarCliente(cliente);
							JOptionPane.showMessageDialog(miDialog, "Cliente registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						    clear();
						}
					}

					private void clear() {
						textId.setText(null);
						textNombre.setText(null);
						spinnerCantidad.setValue(0);
						textDireccion.setText(null);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private boolean validarCamposCliente() {
		String mensajeValidacion = "";
		boolean datosValidos = true;
		
		if(textNombre.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo nombre es necesario\n";
			datosValidos = false;
		}
		if(textDireccion.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo dirección es necesario\n";
			datosValidos = false;
		}
		if(textId.getText().trim().isEmpty()) {
			mensajeValidacion += "*El identificador es necesario\n";
			datosValidos = false;
		}
		else if(Empresa.getInstance().existeIdCliente(textId.getText())) {
			mensajeValidacion += "*El identificador ya ha sido utilizado\n";
			datosValidos = false;
		} 
		if(datosValidos == false) {
			JOptionPane.showMessageDialog(this, mensajeValidacion, "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
		return datosValidos;
	}
}
