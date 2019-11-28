package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Empresa;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido;
	private JPasswordField textContraseña;
	private JPasswordField textConfirmarContraseña;
    private JDialog miDialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuario dialog = new RegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		miDialog = this;
		setTitle("Registrar Usuario");
		setBounds(100, 100, 267, 303);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 30, 46, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 67, 46, 14);
		contentPanel.add(lblApellido);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo:");
		lblTipoDeUsuario.setBounds(10, 104, 88, 14);
		contentPanel.add(lblTipoDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 141, 67, 14);
		contentPanel.add(lblContrasea);
		
		JLabel lblNueva = new JLabel("Confirmar");
		lblNueva.setBounds(10, 168, 67, 14);
		contentPanel.add(lblNueva);
		
		JLabel lblContrasea_1 = new JLabel("contrase\u00F1a:");
		lblContrasea_1.setBounds(10, 181, 67, 14);
		contentPanel.add(lblContrasea_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(77, 27, 139, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(77, 64, 139, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setEchoChar('*');
		textContraseña.setBounds(77, 138, 139, 20);
		contentPanel.add(textContraseña);
		textContraseña.setColumns(10);
		
		textConfirmarContraseña = new JPasswordField();
		textConfirmarContraseña.setEchoChar('*');
		textConfirmarContraseña.setBounds(77, 175, 139, 20);
		contentPanel.add(textConfirmarContraseña);
		textConfirmarContraseña.setColumns(10);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar Usuario>", "Administrador", "Cliente"}));
		comboTipo.setBounds(77, 101, 139, 20);
		contentPanel.add(comboTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCamposUsuario())
						{	
							Usuario usuario = new Usuario(textNombre.getText(),comboTipo.getSelectedItem().toString(),textContraseña.getText());
							Empresa.getInstance().RegistrarUsuario(usuario);
							JOptionPane.showMessageDialog(miDialog, "Usuario registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						    clear();
						}
					}

					private void clear() {
						textNombre.setText(null);
						textApellido.setText(null);
						comboTipo.setSelectedIndex(0);
						textContraseña.setText(null);
						textConfirmarContraseña.setText(null);
					}

					private boolean validarCamposUsuario() {
						String mensajeValidacion = "";
						boolean datosValidos = true;
						if(textNombre.getText().trim().isEmpty()) {
							mensajeValidacion += "*El campo nombre es necesario\n";
							datosValidos = false;
						}
						if(textApellido.getText().trim().isEmpty()) {
							mensajeValidacion += "*El campo apellido es necesario\n";
							datosValidos = false;
						}
						if(comboTipo.getSelectedIndex() == 0) {
							mensajeValidacion += "*Debe seleccionar el tipo de usuario\n";
							datosValidos = false;
						}
						if(textContraseña.getText().trim().isEmpty()){
							mensajeValidacion += "*El campo contraseña es necesario\n";
							datosValidos = false;
						} 
						if(textConfirmarContraseña.getText().trim().isEmpty()) {
							mensajeValidacion += "*Debe confirmar la contraseña\n";
							datosValidos = false;
						}
						else if(!textConfirmarContraseña.getText().trim().contentEquals(textContraseña.getText().trim())) {
							mensajeValidacion += "*Las contraseñas deben coincidir\n";
							datosValidos = false;
						}
						if(datosValidos == false) {
							JOptionPane.showMessageDialog(miDialog, mensajeValidacion, "Error de validación", JOptionPane.ERROR_MESSAGE);
						}
						return datosValidos;
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
						miDialog.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
