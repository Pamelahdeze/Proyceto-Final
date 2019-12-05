package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Disenador;
import logico.Empresa;
import logico.Programador;
import logico.Trabajador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreProyecto;
	private DefaultListModel<String> PDisp = new DefaultListModel<String>();
	private DefaultListModel<String> PSelect = new DefaultListModel<String>();
	private JList<String> ProgDisp;
	private JList<String> ProgSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegProyecto dialog = new RegProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegProyecto() {
		setUndecorated(true);
		setBounds(100, 100, 508, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.activeCaption);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(10, 27, 488, 127);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNombre.setBounds(10, 36, 61, 14);
		panel.add(lblNombre);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		txtNombreProyecto.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtNombreProyecto.setBounds(83, 33, 146, 20);
		panel.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTipo.setBounds(10, 72, 46, 14);
		panel.add(lblTipo);
		
		JComboBox cbxTipoProyecto = new JComboBox();
		cbxTipoProyecto.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		cbxTipoProyecto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		cbxTipoProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "App M\u00F3vil", "Escritorio", "Web"}));
		cbxTipoProyecto.setBounds(83, 69, 146, 20);
		panel.add(cbxTipoProyecto);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEstado.setBounds(239, 33, 61, 17);
		panel.add(lblEstado);
		
		JComboBox cbxEstadoProyecto = new JComboBox();
		cbxEstadoProyecto.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		cbxEstadoProyecto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		cbxEstadoProyecto.setBounds(334, 34, 146, 20);
		panel.add(cbxEstadoProyecto);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLenguaje.setBounds(239, 69, 85, 17);
		panel.add(lblLenguaje);
		
		JComboBox cbxLenguajeProyecto = new JComboBox();
		cbxLenguajeProyecto.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		cbxLenguajeProyecto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		cbxLenguajeProyecto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Java", "C#", "Python", "C++"}));
		cbxLenguajeProyecto.setBounds(334, 69, 146, 20);
		panel.add(cbxLenguajeProyecto);
		
		JPanel Tipo = new JPanel();
		Tipo.setBounds(10, 165, 488, 265);
		panel.add(Tipo);
		Tipo.setBorder(new LineBorder(SystemColor.window, 1, true));
		Tipo.setForeground(SystemColor.activeCaption);
		Tipo.setBackground(SystemColor.activeCaption);
		Tipo.setLayout(null);
		
		JLabel lblDiseadoresDisponibles = new JLabel("Dise\u00F1adores Disponibles:");
		lblDiseadoresDisponibles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDiseadoresDisponibles.setBounds(10, 11, 175, 14);
		Tipo.add(lblDiseadoresDisponibles);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 36, 157, 172);
		Tipo.add(scrollPane_2);
		
		JLabel lblDiseadoresSeleccionados = new JLabel("Dise\u00F1adores Seleccionados:");
		lblDiseadoresSeleccionados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDiseadoresSeleccionados.setBounds(269, 11, 191, 14);
		Tipo.add(lblDiseadoresSeleccionados);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(292, 36, 157, 172);
		Tipo.add(scrollPane_3);
		
		JButton button = new JButton(">");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(187, 84, 89, 23);
		Tipo.add(button);
		
		JButton button_1 = new JButton("<");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(187, 118, 89, 23);
		Tipo.add(button_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(314, 222, 89, 23);
		Tipo.add(btnNewButton);
		
		JPanel Lenguaje = new JPanel();
		Lenguaje.setBorder(new LineBorder(SystemColor.textHighlightText, 2));
		Lenguaje.setBackground(SystemColor.activeCaption);
		Lenguaje.setBounds(10, 165, 488, 265);
		contentPanel.add(Lenguaje);
		Lenguaje.setLayout(null);
		
		for (Trabajador allworkers : Empresa.getInstance().getMisTrabajadores()) {
			if(allworkers instanceof Programador) {
				PDisp.addElement(allworkers.getIdentificador()+", -"+allworkers.getNombre());
			}
			
		}
		
		JLabel lblProgramadoresDisponibles = new JLabel("Programadores Disponibles:");
		lblProgramadoresDisponibles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblProgramadoresDisponibles.setBounds(10, 11, 197, 23);
		Lenguaje.add(lblProgramadoresDisponibles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 157, 172);
		Lenguaje.add(scrollPane);
		
		ProgDisp = new JList();
		ProgDisp.setFont(new Font("Tahoma", Font.ITALIC, 13));
		ProgDisp.setModel(PDisp);
		scrollPane.setViewportView(ProgDisp);
		
		
		JLabel lblProgramadoresSeleccionados = new JLabel("Programadores Seleccionados:");
		lblProgramadoresSeleccionados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblProgramadoresSeleccionados.setBounds(259, 11, 201, 23);
		Lenguaje.add(lblProgramadoresSeleccionados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(292, 36, 157, 172);
		Lenguaje.add(scrollPane_1);
		
		ProgSelect = new JList();
		ProgSelect.setFont(new Font("Tahoma", Font.ITALIC, 13));
		ProgSelect.setModel(PSelect);
		scrollPane_1.setViewportView(ProgSelect);
		
		JButton btnAdd = new JButton(">");
		btnAdd.setBackground(SystemColor.window);
		btnAdd.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> PDisp = ((DefaultListModel<String>)ProgDisp.getModel());
				DefaultListModel<String> PSelect = ((DefaultListModel<String>)ProgSelect.getModel());
				
				for (int cadaProg : ProgDisp.getSelectedIndices()) {
					PSelect.addElement(PDisp.getElementAt(cadaProg));
					PDisp.removeElement(PDisp.getElementAt(cadaProg));
				}
				float val = 0;
				for(int i=0; i < ProgSelect.getModel().getSize(); i++) {
					String LosProgramadores = (String) ProgSelect.getModel().getElementAt(i);
					String[] separadorNombre = LosProgramadores.split("-",2);
					String Nombre = separadorNombre[1];
				}
			}
		});
		btnAdd.setBounds(187, 84, 89, 23);
		Lenguaje.add(btnAdd);
		
		JButton btnReturn = new JButton("<");
		btnReturn.setBackground(SystemColor.window);
		btnReturn.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> PDisp = ((DefaultListModel<String>)ProgDisp.getModel());
				DefaultListModel<String> PSelect = ((DefaultListModel<String>)ProgSelect.getModel());
				
				for (int cadaProg : ProgSelect.getSelectedIndices()) {
					PDisp.addElement(PSelect.getElementAt(cadaProg));
					PSelect.removeElement(PSelect.getElementAt(cadaProg));
				}
				float val = 0;
				for(int i=0; i < PSelect.getSize(); i++) {
					String Programmer = (String) PSelect.getElementAt(i);
					String[] sepNombre =Programmer.split("-",2);
					String Nombre = sepNombre[1];
				}
			}
			
		});
		btnReturn.setBounds(187, 118, 89, 23);
		Lenguaje.add(btnReturn);
		
		JButton button_2 = new JButton("Aceptar");
		button_2.setBackground(SystemColor.window);
		button_2.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		button_2.setBounds(314, 222, 89, 23);
		Lenguaje.add(button_2);
		{
			JButton okButton = new JButton("Registrar");
			okButton.setBackground(SystemColor.window);
			okButton.setBorder(new LineBorder(SystemColor.desktop, 3, true));
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			okButton.setBounds(163, 441, 182, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
					RegProyecto.this.dispose();
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
		label.setBounds(488, 0, 20, 20);
		contentPanel.add(label);
	}
}
