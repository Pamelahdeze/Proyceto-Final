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
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

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
		
		setUndecorated(true);
		miDialog = this;
		setTitle("Login");
		setBounds(100, 100, 330, 265);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
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
			lblUsuario.setBounds(33, 159, 64, 14);
			contentPanel.add(lblUsuario);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setBounds(107, 156, 116, 20);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setBounds(33, 190, 81, 14);
			contentPanel.add(lblContrasea);
		}
		{
			textContraseña = new JPasswordField();
			textContraseña.setEchoChar('*');
			textContraseña.setBounds(107, 187, 116, 20);
			contentPanel.add(textContraseña);
			textContraseña.setColumns(10);
		}
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(120, 231, 89, 23);
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
		separator.setBounds(10, 218, 310, 12);
		contentPanel.add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/interaction.png")));
		lblNewLabel.setBounds(87, 25, 156, 121);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X\r\n");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(274, 11, 46, 14);
		contentPanel.add(lblNewLabel_1);
	}
}
