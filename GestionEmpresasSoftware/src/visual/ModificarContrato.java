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
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;

public class ModificarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarContrato dialog = new ModificarContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarContrato() {
		setTitle("Modificar Contrato");
		setBounds(100, 100, 270, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID Contrato:");
			lblNewLabel.setBounds(10, 11, 79, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(99, 8, 145, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblIdCliente = new JLabel("ID Cliente:");
			lblIdCliente.setBounds(10, 36, 79, 14);
			contentPanel.add(lblIdCliente);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(99, 33, 145, 20);
			contentPanel.add(textField_1);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fechas del Contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 61, 234, 136);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(10, 23, 79, 14);
		panel.add(lblFechaInicio);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(100, 19, 90, 20);
		panel.add(formattedTextField);
		
		JLabel lblFechaEntrega = new JLabel("Fecha Entrega:");
		lblFechaEntrega.setBounds(10, 60, 91, 14);
		panel.add(lblFechaEntrega);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(100, 58, 90, 20);
		panel.add(formattedTextField_1);
		{
			JLabel lblProrroga = new JLabel("Prorroga:");
			lblProrroga.setBounds(10, 97, 79, 14);
			panel.add(lblProrroga);
		}
		{
			JFormattedTextField formattedTextField_2 = new JFormattedTextField();
			formattedTextField_2.setBounds(100, 97, 90, 20);
			panel.add(formattedTextField_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Modificar");
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
