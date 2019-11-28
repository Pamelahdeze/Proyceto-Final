package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Empresa;
import javax.swing.JSeparator;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JPasswordField textContraseña;
	public boolean loginOk = false;
    private JDialog miDialog;
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
		miDialog = this;
		setTitle("Login");
		setBounds(100, 100, 226, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 147, 239, -1);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBounds(245, 5, 57, 23);
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(10, 37, 64, 14);
			contentPanel.add(lblUsuario);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setBounds(84, 34, 116, 20);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setBounds(10, 86, 81, 14);
			contentPanel.add(lblContrasea);
		}
		{
			textContraseña = new JPasswordField();
			textContraseña.setEchoChar('*');
			textContraseña.setBounds(84, 83, 116, 20);
			contentPanel.add(textContraseña);
			textContraseña.setColumns(10);
		}
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(60, 137, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String user = textUsuario.getText();
				String password = textContraseña.getText();
				if(Empresa.getInstance().IniciarSesion(user, password)) {
					loginOk = true;
				    miDialog.dispose();
				}
				else {
					JOptionPane.showMessageDialog(miDialog, "Usuario o Contraseña incorrectos", "Información", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPanel.add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 124, 190, 12);
		contentPanel.add(separator);
	}
}
