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
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

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
		setBounds(100, 100, 470, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(175, 238, 238));
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setUndecorated(true);
		
		try {
			textId = new JFormattedTextField(new MaskFormatter("##-###"));
			textId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textId.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textId.setBounds(211, 35, 100, 20);
		contentPanel.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textNombre.setColumns(10);
		textNombre.setBounds(211, 90, 230, 20);
		contentPanel.add(textNombre);
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDireccion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textDireccion.setColumns(10);
		textDireccion.setBounds(211, 145, 230, 20);
		contentPanel.add(textDireccion);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinnerCantidad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		spinnerCantidad.setBounds(211, 200, 100, 20);
		contentPanel.add(spinnerCantidad);
		
		JLabel close = new JLabel("X");
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		close.setForeground(Color.WHITE);
		close.setFont(new Font("Tahoma", Font.BOLD, 15));
		close.setBounds(424, 11, 46, 14);
		contentPanel.add(close);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 0, 178, 256);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagenes/owner.png")));
		lblNewLabel.setBounds(10, 38, 158, 166);
		panel.add(lblNewLabel);
		{
			JButton okButton = new JButton("Registrar");
			okButton.setBackground(SystemColor.activeCaption);
			okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			okButton.setHorizontalTextPosition(SwingConstants.CENTER);
			okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			okButton.setOpaque(false);
			okButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			okButton.setBounds(10, 222, 158, 23);
			panel.add(okButton);
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
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(211, 12, 46, 14);
		contentPanel.add(lblID);
		lblID.setForeground(SystemColor.desktop);
		lblID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblCantidadProyectos = new JLabel("Cantidad Proyectos:");
		lblCantidadProyectos.setBounds(211, 176, 138, 14);
		contentPanel.add(lblCantidadProyectos);
		lblCantidadProyectos.setForeground(SystemColor.desktop);
		lblCantidadProyectos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(211, 66, 64, 14);
		contentPanel.add(lblNombre);
		lblNombre.setForeground(SystemColor.desktop);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(211, 121, 64, 14);
		contentPanel.add(lblDireccin);
		lblDireccin.setForeground(SystemColor.desktop);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
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
