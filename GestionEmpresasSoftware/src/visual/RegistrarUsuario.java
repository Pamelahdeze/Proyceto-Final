package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
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
	private JPasswordField textContrase�a;
	private JPasswordField textConfirmarContrase�a;
	JComboBox comboTipo;
    private JDialog miDialog;
    public static Usuario usuario = null;
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
		setBounds(100, 100, 267, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 21, 82, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo:");
		lblTipoDeUsuario.setBounds(10, 64, 88, 14);
		contentPanel.add(lblTipoDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 99, 88, 14);
		contentPanel.add(lblContrasea);
		
		JLabel lblNueva = new JLabel("Confirmar");
		lblNueva.setBounds(10, 151, 88, 14);
		contentPanel.add(lblNueva);
		
		JLabel lblContrasea_1 = new JLabel("contrase\u00F1a:");
		lblContrasea_1.setBounds(10, 137, 88, 14);
		contentPanel.add(lblContrasea_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(81, 18, 160, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textContrase�a = new JPasswordField();
		textContrase�a.setEchoChar('*');
		textContrase�a.setBounds(81, 96, 160, 20);
		contentPanel.add(textContrase�a);
		textContrase�a.setColumns(10);
		
		textConfirmarContrase�a = new JPasswordField();
		textConfirmarContrase�a.setEchoChar('*');
		textConfirmarContrase�a.setBounds(81, 131, 160, 20);
		contentPanel.add(textConfirmarContrase�a);
		textConfirmarContrase�a.setColumns(10);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar Usuario>", "Administrador", "Cliente"}));
		comboTipo.setBounds(81, 61, 160, 20);
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
							if (usuario == null) {
								Usuario usuario = new Usuario(textNombre.getText(),
										comboTipo.getSelectedItem().toString(), textContrase�a.getText());
								Empresa.getInstance().RegistrarUsuario(usuario);
								JOptionPane.showMessageDialog(miDialog, "Usuario registrado exitosamente",
										"Informaci�n", JOptionPane.INFORMATION_MESSAGE);
								clear();
							}else {
								usuario.setNombre(textNombre.getText());
								usuario.setContrase�a(textContrase�a.getText());
								usuario.setTipo(comboTipo.getSelectedItem().toString());
								clear();
								Empresa.getInstance().escribirDatos();
								usuario = null;
								JOptionPane.showMessageDialog(miDialog, "Usuario actualizado exitosamente", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
								closeDialog();
							}
						}
					}


					private void clear() {
						textNombre.setText(null);
						comboTipo.setSelectedIndex(0);
						textContrase�a.setText(null);
						textConfirmarContrase�a.setText(null);
					}

					private boolean validarCamposUsuario() {
						String mensajeValidacion = "";
						boolean datosValidos = true;
						if(textNombre.getText().trim().isEmpty()) {
							mensajeValidacion += "*El campo nombre es necesario\n";
							datosValidos = false;
						}
						else if(Empresa.getInstance().existeUsuario(textNombre.getText()) && usuario == null) {
							mensajeValidacion += "*El nombre de usuario ya ha sido registrado\n";
							datosValidos = false;
						}
						if(comboTipo.getSelectedIndex() == 0) {
							mensajeValidacion += "*Debe seleccionar el tipo de usuario\n";
							datosValidos = false;
						}
						if(textContrase�a.getText().trim().isEmpty()){
							mensajeValidacion += "*El campo contrase�a es necesario\n";
							datosValidos = false;
						} 
						if(textConfirmarContrase�a.getText().trim().isEmpty()) {
							mensajeValidacion += "*Debe confirmar la contrase�a\n";
							datosValidos = false;
						}
						else if(!textConfirmarContrase�a.getText().trim().contentEquals(textContrase�a.getText().trim())) {
							mensajeValidacion += "*Las contrase�as deben coincidir\n";
							datosValidos = false;
						}
						if(datosValidos == false) {
							JOptionPane.showMessageDialog(miDialog, mensajeValidacion, "Error de validaci�n", JOptionPane.ERROR_MESSAGE);
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
		if(usuario != null) {
	    	llenarCampos();
	    }
	}

	private void closeDialog() {
		this.dispose();
	}
	
	private void llenarCampos() {
		textNombre.setText(usuario.getNombre());
		textContrase�a.setText(usuario.getContrase�a());
		textConfirmarContrase�a.setText(usuario.getContrase�a());
		comboTipo.setSelectedItem(usuario.getTipo());
	}
}
