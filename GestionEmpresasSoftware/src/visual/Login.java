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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JPasswordField textContraseña;
	public boolean loginOk = false;
	private JDialog miDialog;
	private JLabel lblLoginMessage = new JLabel("");
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
		setLocationRelativeTo(null);
		miDialog = this;
		setTitle("Login");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 2, true));
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 377, 580, 12);
		contentPanel.add(separator);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/security.png")));
		lblNewLabel.setBounds(175, 35, 250, 121);
		contentPanel.add(lblNewLabel);

		JLabel CloseLabel = new JLabel("X\r\n");
		CloseLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CloseLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
					Login.this.dispose();
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CloseLabel.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				CloseLabel.setForeground(Color.WHITE);
			}
		});
		CloseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CloseLabel.setForeground(SystemColor.text);
		CloseLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		CloseLabel.setBounds(580, 0, 20, 20);
		contentPanel.add(CloseLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(175, 167, 250, 40);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			textUsuario = new JTextField();
			textUsuario.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if (textUsuario.getText().equals("Usuario")) {
						textUsuario.setText("");
					}
					else {
						textUsuario.selectAll();
					}
				}
				public void focusLost(FocusEvent e) {
					if (textUsuario.getText().equals("")) {
						textUsuario.setText("Usuario");
					}

				}
			});
			textUsuario.setBorder(null);
			textUsuario.setFont(new Font("Arial Black", Font.PLAIN, 12));
			textUsuario.setText("Usuario");
			textUsuario.setBounds(10, 11, 170, 20);
			panel.add(textUsuario);
			textUsuario.setColumns(10);
		}

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/imagenes/login.png")));
		lblNewLabel_3.setBounds(204, 0, 46, 40);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(175, 218, 250, 40);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		{
			textContraseña = new JPasswordField();
			textContraseña.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (textContraseña.getText().equals("Contraseña")) {
						textContraseña.setEchoChar('■');
						textContraseña.setText("");
					}
					else {
						textContraseña.selectAll();
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (textContraseña.getText().equals("")) {
						textContraseña.setText("Contraseña");
						textContraseña.setEchoChar((char)0);
					}


				}
			});
			textContraseña.setBorder(null);
			textContraseña.setEchoChar((char)0);
			textContraseña.setFont(new Font("Arial Black", Font.PLAIN, 12));
			textContraseña.setText("Contrase\u00F1a");
			textContraseña.setBounds(10, 11, 170, 20);
			panel_1.add(textContraseña);
			textContraseña.setColumns(10);
		}

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/imagenes/password.png")));
		lblNewLabel_4.setBounds(204, 0, 46, 40);
		panel_1.add(lblNewLabel_4);

		JPanel loginPanel = new JPanel();
		loginPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String user = textUsuario.getText();
				String password = textContraseña.getText();
				if(Empresa.getInstance().IniciarSesion(user, password)) {
					loginOk = true;
					miDialog.dispose();
				}
				else if (textUsuario.getText().equals("") || textUsuario.getText().equals("Usuario") || 
						textContraseña.getText().equals("") || textContraseña.getText().equals("Contraseña")) {
					lblLoginMessage.setText("Por Favor, Introduce los Datos");
				}else {
					lblLoginMessage.setText("El usuario y/o la contraseña no concuerdan");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				loginPanel.setBackground(new Color(30,60,60));
			}
			public void mouseExited(MouseEvent e) {
				loginPanel.setBackground(new Color(47,79,79));
			}
			public void mousePressed(MouseEvent e) {
				loginPanel.setBackground(new Color(60,80,80));
			}
		});
		loginPanel.setBackground(new Color(30, 144, 255));
		loginPanel.setBounds(175, 292, 250, 50);
		contentPanel.add(loginPanel);
		loginPanel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.window);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(101, 11, 64, 28);
		loginPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/imagenes/key.png")));
		lblNewLabel_5.setBounds(56, 0, 50, 50);
		loginPanel.add(lblNewLabel_5);
		
		lblLoginMessage.setForeground(new Color(128, 0, 0));
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 10));
		lblLoginMessage.setBounds(175, 263, 292, 18);
		contentPanel.add(lblLoginMessage);
	}
}
