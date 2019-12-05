package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import logico.Empresa;
import logico.JefeProyecto;
import logico.Trabajador;

public class RegistrarJefe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarJefe dialog = new RegistrarJefe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarJefe() {
		setBounds(100, 100, 451, 223);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		comboBox = new JComboBox();
		ArrayList<String> nombreJefes = new ArrayList<String>();
		ArrayList<Trabajador> jefes = new ArrayList<Trabajador>();
		jefes = Empresa.getInstance().obtenerTrabajadoresPorTipo("JefeProyecto");
		for(Trabajador trabajador: jefes) {
			nombreJefes.add(trabajador.getIdentificador()+"| "+trabajador.getNombre()+" "+trabajador.getApellido());
		}
		comboBox.setModel(new DefaultComboBoxModel(nombreJefes.toArray()));

		JLabel lblSeleccionarJefe = new JLabel("Seleccionar Jefe:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(79)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSeleccionarJefe))
						.addContainerGap(84, Short.MAX_VALUE))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(48)
						.addComponent(lblSeleccionarJefe)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(48, Short.MAX_VALUE))
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Next");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCantidadProyectos()) {
							String itemJefe = String.valueOf(comboBox.getSelectedItem());
							String codigoJefe = itemJefe.substring(0,itemJefe.indexOf('|'));
							Empresa.proyectoCreacion.getTrabajadores().add(((JefeProyecto)Empresa.getInstance().obtenerTrabajador(codigoJefe)));
							RegistrarDisenador registroDisenadorDialog = new RegistrarDisenador();
							registroDisenadorDialog.setModal(true);
							registroDisenadorDialog.setLocationRelativeTo(null);
							registroDisenadorDialog.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "El jefe no puede estar en más de un proyecto a la vez", "Información", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	private boolean validarCantidadProyectos() {
		Trabajador trabajador = Empresa.getInstance().obtenerTrabajador(String.valueOf(comboBox.getSelectedItem()));
		return Empresa.getInstance().validarJefe(trabajador);
	}
}
