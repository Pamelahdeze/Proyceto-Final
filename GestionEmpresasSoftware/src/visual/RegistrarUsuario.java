package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setBounds(100, 100, 267, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Registrar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		textField = new JTextField();
		textField.setBounds(77, 27, 139, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 64, 139, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(77, 138, 139, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(77, 175, 139, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		comboBox.setBounds(77, 101, 139, 20);
		contentPanel.add(comboBox);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
