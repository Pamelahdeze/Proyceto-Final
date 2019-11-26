package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JList;

public class RegTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private DefaultListModel<String> ProgDisp = new DefaultListModel<String>();
	private DefaultListModel<String> ProgSelect = new DefaultListModel<String>();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegTrabajador dialog = new RegTrabajador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegTrabajador() {
		setBounds(100, 100, 560, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 525, 230);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblId = new JLabel("ID:");
				lblId.setBounds(10, 32, 46, 14);
				panel.add(lblId);
			}
			{
				textField = new JTextField();
				textField.setBounds(76, 29, 86, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 69, 56, 14);
				panel.add(lblNombre);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(76, 66, 140, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(10, 107, 56, 14);
				panel.add(lblApellidos);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(76, 104, 140, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JLabel lblSexo = new JLabel("Sexo:");
				lblSexo.setBounds(10, 146, 46, 14);
				panel.add(lblSexo);
			}
			{
				textField_3 = new JTextField();
				textField_3.setBounds(76, 143, 86, 20);
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				JLabel lblEdad = new JLabel("Edad:");
				lblEdad.setBounds(279, 68, 46, 14);
				panel.add(lblEdad);
			}
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(368, 66, 86, 20);
			panel.add(spinner);
			
			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(279, 105, 46, 14);
			panel.add(lblSalario);
			
			textField_4 = new JTextField();
			textField_4.setBounds(368, 104, 140, 20);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblPagoPorHora = new JLabel("Pago por Hora:");
			lblPagoPorHora.setBounds(279, 143, 86, 14);
			panel.add(lblPagoPorHora);
			
			textField_5 = new JTextField();
			textField_5.setBounds(368, 143, 140, 20);
			panel.add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setBounds(10, 189, 61, 14);
			panel.add(lblDireccin);
			
			textField_6 = new JTextField();
			textField_6.setBounds(76, 186, 432, 20);
			panel.add(textField_6);
			textField_6.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 252, 525, 48);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JRadioButton rdbtnDiseador = new JRadioButton("Dise\u00F1ador");
			rdbtnDiseador.setBounds(21, 18, 96, 23);
			panel.add(rdbtnDiseador);
		}
		{
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Jefe de Proyecto");
			rdbtnNewRadioButton.setBounds(130, 18, 134, 23);
			panel.add(rdbtnNewRadioButton);
		}
		{
			JRadioButton rdbtnProgramador = new JRadioButton("Programador");
			rdbtnProgramador.setBounds(277, 18, 109, 23);
			panel.add(rdbtnProgramador);
		}
		{
			JRadioButton rdbtnPlanificador = new JRadioButton("Planificador");
			rdbtnPlanificador.setBounds(402, 18, 109, 23);
			panel.add(rdbtnPlanificador);
		}
		{
			JPanel PanelDiseñador = new JPanel();
			PanelDiseñador.setBounds(10, 311, 525, 137);
			contentPanel.add(PanelDiseñador);
			PanelDiseñador.setLayout(null);
			{
				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(10, 25, 54, 14);
				PanelDiseñador.add(lblTipo);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "App M\u00F3vil", "Escritorio", "Web"}));
				comboBox.setBounds(110, 22, 131, 20);
				PanelDiseñador.add(comboBox);
			}
		}
		{
			JPanel panelProgramador = new JPanel();
			panelProgramador.setLayout(null);
			panelProgramador.setBounds(10, 311, 525, 137);
			contentPanel.add(panelProgramador);
			{
				JLabel label = new JLabel("Tipo:");
				label.setBounds(10, 25, 54, 14);
				panelProgramador.add(label);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(110, 22, 131, 20);
				panelProgramador.add(comboBox);
			}
		}
		{
			JPanel Planificador = new JPanel();
			Planificador.setLayout(null);
			Planificador.setBounds(10, 311, 525, 137);
			contentPanel.add(Planificador);
			{
				JLabel lblFrecuencia = new JLabel("Frecuencia:");
				lblFrecuencia.setBounds(10, 25, 135, 14);
				Planificador.add(lblFrecuencia);
			}
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(155, 22, 86, 20);
			Planificador.add(spinner);
		}
		{
			JPanel PanelJefe = new JPanel();
			PanelJefe.setBounds(10, 311, 525, 137);
			contentPanel.add(PanelJefe);
			PanelJefe.setLayout(null);
			{
				JLabel lblCantidad = new JLabel("Cantidad de Trabajadores:");
				lblCantidad.setBounds(10, 25, 135, 14);
				PanelJefe.add(lblCantidad);
			}
			{
				textField_8 = new JTextField();
				textField_8.setBounds(155, 22, 86, 20);
				PanelJefe.add(textField_8);
				textField_8.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
