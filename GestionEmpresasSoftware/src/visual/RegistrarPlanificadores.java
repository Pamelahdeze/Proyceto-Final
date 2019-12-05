package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class RegistrarPlanificadores extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPlanificadores dialog = new RegistrarPlanificadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPlanificadores() {
		setBounds(100, 100, 563, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		{
			JLabel lblPlanificadoresDisponibles = new JLabel("Planificadores Disponibles:");
			lblPlanificadoresDisponibles.setBounds(10, 11, 175, 14);
			panel.add(lblPlanificadoresDisponibles);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 36, 157, 172);
			panel.add(scrollPane);
		}
		{
			JLabel lblPlanificadoresSeleccionados = new JLabel("Planificadores Seleccionados:");
			lblPlanificadoresSeleccionados.setBounds(269, 11, 191, 14);
			panel.add(lblPlanificadoresSeleccionados);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(292, 36, 157, 172);
			panel.add(scrollPane);
		}
		{
			JButton button = new JButton(">");
			button.setBounds(187, 84, 89, 23);
			panel.add(button);
		}
		{
			JButton button = new JButton("<");
			button.setBounds(187, 118, 89, 23);
			panel.add(button);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(37, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
						.addGap(30))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(23, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Next");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
