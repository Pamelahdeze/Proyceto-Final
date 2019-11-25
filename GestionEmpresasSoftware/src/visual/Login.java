package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 234, 236);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 145, 218, 1);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Login");
				cancelButton.setBounds(245, 5, 57, 23);
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(10, 37, 46, 14);
			contentPanel.add(lblUsuario);
		}
		{
			textField = new JTextField();
			textField.setBounds(77, 34, 120, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setBounds(10, 86, 65, 14);
			contentPanel.add(lblContrasea);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(77, 83, 120, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(64, 157, 89, 23);
		contentPanel.add(btnLogin);
	}
}
