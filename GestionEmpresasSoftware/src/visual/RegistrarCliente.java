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
	public static Cliente cliente = null;
	private JSpinner spinnerCantidad;

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
		contentPanel.setBorder(new LineBorder(SystemColor.desktop, 2, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setUndecorated(true);
		
	    
		try {
			textId = new JFormattedTextField(new MaskFormatter("##-###"));
			textId.setFont(new Font("Tahoma", Font.ITALIC, 13));
			textId.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textId.setBounds(211, 35, 100, 20);
		contentPanel.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textNombre.setColumns(10);
		textNombre.setBounds(211, 90, 230, 20);
		contentPanel.add(textNombre);
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textDireccion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		textDireccion.setColumns(10);
		textDireccion.setBounds(211, 145, 230, 20);
		contentPanel.add(textDireccion);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		spinnerCantidad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		spinnerCantidad.setBounds(211, 200, 100, 20);
		contentPanel.add(spinnerCantidad);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.desktop, 2, true));
		panel.setBackground(SystemColor.controlShadow);
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
			okButton.setForeground(SystemColor.desktop);
			okButton.setBackground(SystemColor.activeCaption);
			okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			okButton.setHorizontalTextPosition(SwingConstants.CENTER);
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			okButton.setOpaque(false);
			okButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			okButton.setBounds(10, 222, 158, 23);
			panel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validarCamposCliente())
					{
						if(cliente==null) {
							Cliente cliente = new Cliente(textId.getText(),textNombre.getText(),textDireccion.getText(), (int)spinnerCantidad.getValue());
							Empresa.getInstance().RegistrarCliente(cliente);
							JOptionPane.showMessageDialog(miDialog, "Cliente registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						    clear();
						}
						else {
							cliente.setNombre(textNombre.getText());
							cliente.setDireccion(textDireccion.getText());
							cliente.setIndentificador(textId.getText());
							cliente.setCantMaxProyectos((int)spinnerCantidad.getValue());
							clear();
							Empresa.getInstance().escribirDatos();
							cliente = null;
							JOptionPane.showMessageDialog(miDialog, "Cliente actualizado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							closeDialog();
							
						}
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
		
		JLabel label = new JLabel("X");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
					RegistrarCliente.this.dispose();
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
		label.setBounds(450, 0, 20, 20);
		contentPanel.add(label);
		
		if(cliente != null) {
	    	llenarCampos();
	    }
		
	}
	

	private void closeDialog() {
		this.dispose();
	}
	
	private void llenarCampos() {
		textNombre.setText(cliente.getNombre());
		textDireccion.setText(cliente.getDireccion());
		textId.setText(cliente.getIndentificador());
		spinnerCantidad.setValue(cliente.getCantMaxProyectos());
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
		else if(Empresa.getInstance().existeIdCliente(textId.getText()) && cliente == null) {
			mensajeValidacion += "*El identificador ya ha sido utilizado\n";
			datosValidos = false;
		} 
		if(datosValidos == false) {
			JOptionPane.showMessageDialog(this, mensajeValidacion, "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
		return datosValidos;
	}
}
