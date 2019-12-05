package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logico.Empresa;
import logico.Trabajador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarDisenador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList<String> listDisponibles;
	private JList listSeleccionados;
	private DefaultListModel<String> listaDisponiblesModel;
	private DefaultListModel<String> listaSeleccionadosModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarDisenador dialog = new RegistrarDisenador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarDisenador() {
		setBounds(100, 100, 602, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setBounds(75, 45, 470, 256);
		panel.setLayout(null);

		JLabel label = new JLabel("Dise\u00F1adores Disponibles:");
		label.setBounds(10, 11, 175, 14);
		panel.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 157, 172);
		panel.add(scrollPane);

		listDisponibles = new JList<String>();
		scrollPane.setViewportView(listDisponibles);

		JLabel label_1 = new JLabel("Dise\u00F1adores Seleccionados:");
		label_1.setBounds(269, 11, 191, 14);
		panel.add(label_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(292, 36, 157, 172);
		panel.add(scrollPane_1);

		listSeleccionados = new JList();
		scrollPane_1.setViewportView(listSeleccionados);

		JButton buttonAdd = new JButton(">");
		buttonAdd.setBounds(187, 84, 89, 23);
		panel.add(buttonAdd);

		JButton buttonMin = new JButton("<");
		buttonMin.setBounds(187, 118, 89, 23);
		panel.add(buttonMin);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Next");
			okButton.setBounds(117, 11, 55, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			cancelButton.setBounds(42, 11, 65, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(68)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(73, Short.MAX_VALUE))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap(43, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addGap(33))
				);
		contentPanel.setLayout(gl_contentPanel);
		listaDisponiblesModel = new DefaultListModel<String>();
		for(Trabajador disenador: Empresa.getInstance().obtenerTrabajadoresPorTipo("Disenador")) {
			listaDisponiblesModel.addElement(disenador.getIdentificador()+"| "+disenador.getNombre()+" "+disenador.getApellido());
		}
		listDisponibles.setModel(listaDisponiblesModel);
		listaSeleccionadosModel = new DefaultListModel<String>();
	}

}


