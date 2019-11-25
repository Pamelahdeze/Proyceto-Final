package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class RegistrarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_3;

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
		setBounds(100, 100, 300, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIDContrato = new JLabel("ID Contrato:");
			lblIDContrato.setBounds(10, 11, 75, 14);
			contentPanel.add(lblIDContrato);
		}
		{
			textField = new JTextField();
			textField.setBounds(92, 8, 182, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
			lblFechaInicial.setBounds(10, 36, 75, 14);
			contentPanel.add(lblFechaInicial);
		}
		{
			JLabel lblFechaEntrega = new JLabel("Fecha Entrega:");
			lblFechaEntrega.setBounds(10, 61, 75, 14);
			contentPanel.add(lblFechaEntrega);
		}
		{
			JLabel lblIdCliente = new JLabel("ID Cliente:");
			lblIdCliente.setBounds(10, 89, 75, 14);
			contentPanel.add(lblIdCliente);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(92, 86, 182, 20);
			contentPanel.add(textField_3);
		}
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(92, 33, 86, 20);
		contentPanel.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(92, 61, 86, 20);
		contentPanel.add(formattedTextField_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
