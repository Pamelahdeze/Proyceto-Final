package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import logico.Cliente;
import logico.Contrato;
import logico.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class RegistrarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdContrato;
	private JTextField txtIdCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarContrato dialog = new RegistrarContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarContrato() {
		setTitle("Registrar Contrato");
		setBounds(100, 100, 571, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		{
			JLabel lblIDContrato = new JLabel("ID Contrato:");
			lblIDContrato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblIDContrato.setBounds(21, 68, 116, 18);
			contentPanel.add(lblIDContrato);
		}
		{
			txtIdContrato = new JTextField();
			txtIdContrato.setBounds(159, 66, 182, 20);
			contentPanel.add(txtIdContrato);
			txtIdContrato.setColumns(10);
			txtIdContrato.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
		}
		{
			JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
			lblFechaInicial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblFechaInicial.setBounds(21, 122, 116, 18);
			contentPanel.add(lblFechaInicial);
		}
		{
			JLabel lblFechaEntrega = new JLabel("Fecha Entrega:");
			lblFechaEntrega.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblFechaEntrega.setBounds(21, 176, 116, 18);
			contentPanel.add(lblFechaEntrega);
		}
		{
			JLabel lblIdCliente = new JLabel("ID Cliente:");
			lblIdCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblIdCliente.setBounds(21, 227, 116, 18);
			contentPanel.add(lblIdCliente);
		}
		{
			txtIdCliente = new JTextField();
			txtIdCliente.setColumns(10);
			txtIdCliente.setBounds(159, 227, 182, 20);
			contentPanel.add(txtIdCliente);
			txtIdCliente.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
		}
		
		JFormattedTextField ftxtFechaInicial = new JFormattedTextField();
		ftxtFechaInicial.setBounds(159, 120, 182, 20);
		contentPanel.add(ftxtFechaInicial);
		ftxtFechaInicial.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
		
		JFormattedTextField ftxtFechaEntrega = new JFormattedTextField();
		ftxtFechaEntrega.setBounds(159, 174, 182, 20);
		contentPanel.add(ftxtFechaEntrega);
		ftxtFechaEntrega.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(359, 0, 212, 343);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Registrar");
		//button.addActionListener(new ActionListener() {
		/*public void actionPerformed(ActionEvent e) {
				if(validarCamposContrato())
				{
					if(contrato==null) {
						Contrato contrac = new Contrato(txtIdContrato.getText(), proyecto, cliente, fechaInicio, fechaEntrega, fechaProrroga)
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
				
			}*/
		//});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setActionCommand("OK");
		button.setBounds(37, 307, 146, 25);
		panel.add(button);
		button.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistrarContrato.class.getResource("/imagenes/policy.png")));
		lblNewLabel.setBounds(30, 24, 192, 272);
		panel.add(lblNewLabel);
		
		JLabel close = new JLabel("X");
		close.setBounds(156, 11, 46, 14);
		panel.add(close);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		close.setForeground(SystemColor.desktop);
		close.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		/*private boolean validarCamposContrato() {
			String mensajeValidacion = "";
			boolean datosValidos = true;
			
			if(txtIdContrato.getText().trim().isEmpty()) {
				mensajeValidacion += "*El identificador es necesario\n";
				datosValidos = false;
			}
			if(ftxtFechaInicial.getText().trim().isEmpty()) {
				mensajeValidacion += "*El campo fecha inicial es necesario\n";
				datosValidos = false;
			}
			if(ftxtFechaEntrega.getText().trim().isEmpty()) {
				mensajeValidacion += "*El campo fecha inicial es necesario\n";
				datosValidos = false;
			}
			if(txtIdCliente.getText().trim().isEmpty()) {
				mensajeValidacion += "*El identificador de cliente es necesario\n";
				datosValidos = false;
			}
			
			return datosValidos;
		}*/
	}
}
