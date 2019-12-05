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
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JPasswordField textContraseña;
	private JPasswordField textConfirmarContraseña;
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
		setUndecorated(true);
		miDialog = this;
		setTitle("Registrar Usuario");
		setBounds(100, 100, 500, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new LineBorder(SystemColor.desktop, 2, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNombre.setBounds(216, 40, 60, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo:");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTipoDeUsuario.setBounds(216, 99, 88, 14);
		contentPanel.add(lblTipoDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblContrasea.setBounds(216, 157, 88, 14);
		contentPanel.add(lblContrasea);
		
		JLabel lblNueva = new JLabel("Confirmar");
		lblNueva.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNueva.setBounds(216, 203, 88, 14);
		contentPanel.add(lblNueva);
		
		JLabel lblContrasea_1 = new JLabel("contrase\u00F1a:");
		lblContrasea_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblContrasea_1.setBounds(216, 215, 88, 14);
		contentPanel.add(lblContrasea_1);
		
		textNombre = new JTextField();
		textNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textNombre.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textNombre.setBounds(314, 38, 176, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textContraseña.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textContraseña.setEchoChar('*');
		textContraseña.setBounds(314, 154, 176, 20);
		contentPanel.add(textContraseña);
		textContraseña.setColumns(10);
		
		textConfirmarContraseña = new JPasswordField();
		textConfirmarContraseña.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textConfirmarContraseña.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textConfirmarContraseña.setEchoChar('*');
		textConfirmarContraseña.setBounds(314, 212, 176, 20);
		contentPanel.add(textConfirmarContraseña);
		textConfirmarContraseña.setColumns(10);
		
		comboTipo = new JComboBox();
		comboTipo.setBackground(SystemColor.window);
		comboTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboTipo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar Usuario>", "Administrador", "Cliente"}));
		comboTipo.setBounds(314, 96, 176, 20);
		contentPanel.add(comboTipo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.desktop, 2, true));
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 206, 270);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JButton okButton = new JButton("Registrar");
			okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			okButton.setBorder(new LineBorder(SystemColor.desktop, 3, true));
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			okButton.setBackground(SystemColor.window);
			okButton.setBounds(10, 236, 186, 23);
			panel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validarCamposUsuario())
					{	
						if (usuario == null) {
							Usuario usuario = new Usuario(textNombre.getText(),
									comboTipo.getSelectedItem().toString(), textContraseña.getText());
							Empresa.getInstance().RegistrarUsuario(usuario);
							JOptionPane.showMessageDialog(miDialog, "Usuario registrado exitosamente",
									"Información", JOptionPane.INFORMATION_MESSAGE);
							clear();
						}else {
							usuario.setNombre(textNombre.getText());
							usuario.setContraseña(textContraseña.getText());
							usuario.setTipo(comboTipo.getSelectedItem().toString());
							clear();
							Empresa.getInstance().escribirDatos();
							usuario = null;
							JOptionPane.showMessageDialog(miDialog, "Usuario actualizado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							closeDialog();
						}
					}
				}


				private void clear() {
					textNombre.setText(null);
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
					else if(Empresa.getInstance().existeUsuario(textNombre.getText()) && usuario == null) {
						mensajeValidacion += "*El nombre de usuario ya ha sido registrado\n";
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
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/imagenes/males-group.png")));
		lblNewLabel.setBounds(36, 11, 160, 214);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("X");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
					RegistrarUsuario.this.dispose();
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				label.setForeground(Color.WHITE);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		label.setBounds(480, 0, 20, 20);
		contentPanel.add(label);
		if(usuario != null) {
	    	llenarCampos();
	    }
	}

	private void closeDialog() {
		this.dispose();
	}
	
	private void llenarCampos() {
		textNombre.setText(usuario.getNombre());
		textContraseña.setText(usuario.getContraseña());
		textConfirmarContraseña.setText(usuario.getContraseña());
		comboTipo.setSelectedItem(usuario.getTipo());
	}
}
