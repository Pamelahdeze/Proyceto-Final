package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Cliente;
import logico.Disenador;
import logico.Empresa;
import logico.JefeProyecto;
import logico.Planificador;
import logico.Programador;
import logico.Trabajador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class RegTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textId;
	private DefaultListModel<String> ProgDisp = new DefaultListModel<String>();
	private DefaultListModel<String> ProgSelect = new DefaultListModel<String>();
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textSexo;
	private JTextField textSalario;
	private JTextField textPagoPorHora;
	private JTextField textDireccion;
	private JSpinner spnCantidad;
	JPanel PanelDiseñador;
	JPanel panelProgramador;
	JPanel PanelJefe;
	JPanel PanelPlanificador;
	JRadioButton rdbtnJefe;
	JRadioButton rdbtnProgramador;
	JRadioButton rdbtnPlanificador;
	JRadioButton rdbtnDisenador;
	JSpinner spnFrecuencia;
	private JScrollPane lenguajesDisponiblesScroll;
	private JScrollPane lenguajesSeleccionadosScroll;
	private JList<String>lenguajesDisponiblesList;
	private JList<String>lenguajesSeleccionadosList;
	private JButton buttonAdd;
	private JButton buttonMin;
	private JSpinner spinnerEdad;
	private JComboBox comboTipo;

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
		
		lenguajesDisponiblesList = new JList<String>();
		lenguajesSeleccionadosList = new JList<String>();
		lenguajesDisponiblesScroll = new JScrollPane();
		lenguajesSeleccionadosScroll = new JScrollPane();
		lenguajesDisponiblesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lenguajesSeleccionadosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
				try {
					textId = new JFormattedTextField(new MaskFormatter("##-###"));
					textId.setFont(new Font("Tahoma", Font.PLAIN, 13));
					textId.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.activeCaptionText));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textId.setBounds(130, 29, 86, 20);
				panel.add(textId);
				textId.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 69, 56, 14);
				panel.add(lblNombre);
			}
			{
				textNombre = new JTextField();
				textNombre.setBounds(76, 66, 140, 20);
				panel.add(textNombre);
				textNombre.setColumns(10);
			}
			{
				JLabel lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(10, 107, 56, 14);
				panel.add(lblApellidos);
			}
			{
				textApellido = new JTextField();
				textApellido.setBounds(76, 104, 140, 20);
				panel.add(textApellido);
				textApellido.setColumns(10);
			}
			{
				JLabel lblSexo = new JLabel("Sexo:");
				lblSexo.setBounds(10, 146, 46, 14);
				panel.add(lblSexo);
			}
			{
				textSexo = new JTextField();
				textSexo.setBounds(130, 143, 86, 20);
				panel.add(textSexo);
				textSexo.setColumns(10);
			}
			{
				JLabel lblEdad = new JLabel("Edad:");
				lblEdad.setBounds(279, 68, 46, 14);
				panel.add(lblEdad);
			}
			
			spinnerEdad = new JSpinner();
			spinnerEdad.setBounds(368, 66, 86, 20);
			panel.add(spinnerEdad);
			
			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(279, 105, 46, 14);
			panel.add(lblSalario);
			
			textSalario = new JTextField();
			textSalario.setBounds(368, 104, 140, 20);
			panel.add(textSalario);
			textSalario.setColumns(10);
			
			JLabel lblPagoPorHora = new JLabel("Pago por Hora:");
			lblPagoPorHora.setBounds(279, 143, 86, 14);
			panel.add(lblPagoPorHora);
			
			textPagoPorHora = new JTextField();
			textPagoPorHora.setBounds(368, 143, 140, 20);
			panel.add(textPagoPorHora);
			textPagoPorHora.setColumns(10);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setBounds(10, 189, 61, 14);
			panel.add(lblDireccin);
			
			textDireccion = new JTextField();
			textDireccion.setBounds(76, 186, 432, 20);
			panel.add(textDireccion);
			textDireccion.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 252, 525, 48);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			rdbtnDisenador = new JRadioButton("Dise\u00F1ador");
			rdbtnDisenador.setSelected(true);
			rdbtnDisenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelDiseñador.setVisible(true);
					panelProgramador.setVisible(false);
					PanelJefe.setVisible(false);
					PanelPlanificador.setVisible(false);			
					rdbtnDisenador.setSelected(true);
					rdbtnJefe.setSelected(false);
					rdbtnProgramador.setSelected(false);
					rdbtnPlanificador.setSelected(false);
					//txtCantidad.setVisible(false);
					//spnFrecuencia.setVisible(false);
					
					}
			});
			rdbtnDisenador.setSelected(true);
			rdbtnDisenador.setBounds(21, 18, 96, 23);
			panel.add(rdbtnDisenador);
		}
		{
			rdbtnJefe = new JRadioButton("Jefe de Proyecto");
			rdbtnJefe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelDiseñador.setVisible(false);
					panelProgramador.setVisible(false);
					PanelJefe.setVisible(true);
					PanelPlanificador.setVisible(false);			
					rdbtnDisenador.setSelected(false);
					rdbtnJefe.setSelected(true);
					rdbtnProgramador.setSelected(false);
					rdbtnPlanificador.setSelected(false);
				}
			});
			rdbtnJefe.setBounds(130, 18, 134, 23);
			panel.add(rdbtnJefe);
		}
		{
			rdbtnProgramador = new JRadioButton("Programador");
			rdbtnProgramador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelDiseñador.setVisible(false);
					panelProgramador.setVisible(true);
					PanelJefe.setVisible(false);
					PanelPlanificador.setVisible(false);			
					rdbtnDisenador.setSelected(false);
					rdbtnJefe.setSelected(false);
					rdbtnProgramador.setSelected(true);
					rdbtnPlanificador.setSelected(false);
				}
			});
			rdbtnProgramador.setBounds(277, 18, 109, 23);
			panel.add(rdbtnProgramador);
		}
		{
			rdbtnPlanificador = new JRadioButton("Planificador");
			rdbtnPlanificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelDiseñador.setVisible(false);
					panelProgramador.setVisible(false);
					PanelJefe.setVisible(false);
					PanelPlanificador.setVisible(true);			
					rdbtnDisenador.setSelected(false);
					rdbtnJefe.setSelected(false);
					rdbtnProgramador.setSelected(false);
					rdbtnPlanificador.setSelected(true);
					
				}
			});
			rdbtnPlanificador.setBounds(402, 18, 109, 23);
			panel.add(rdbtnPlanificador);
		}
		{
			PanelDiseñador = new JPanel();
			PanelDiseñador.setBounds(10, 311, 525, 137);
			contentPanel.add(PanelDiseñador);
			PanelDiseñador.setLayout(null);
			{
				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(10, 25, 54, 14);
				PanelDiseñador.add(lblTipo);
			}
			{
				comboTipo = new JComboBox();
				comboTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "App M\u00F3vil", "Escritorio", "Web"}));
				comboTipo.setBounds(110, 22, 131, 20);
				PanelDiseñador.add(comboTipo);
			}
		}
		{
			panelProgramador = new JPanel();
			panelProgramador.setLayout(null);
			panelProgramador.setBounds(10, 311, 525, 137);
			contentPanel.add(panelProgramador);
			
			{
				JLabel labelDisp = new JLabel("Disponibles");
				labelDisp.setBounds(10, 0, 100, 40);
				panelProgramador.add(labelDisp);
				
				lenguajesDisponiblesList.setModel(ProgDisp);
				lenguajesDisponiblesScroll.setBounds(10, 30, 226, 115);
				lenguajesDisponiblesScroll.setViewportView(lenguajesDisponiblesList);
				panelProgramador.add(lenguajesDisponiblesScroll);
				
				buttonAdd = new JButton(" >");
				buttonAdd.setBounds(246, 30, 50, 35);
				buttonAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						agregarLenguaje();
					}

				
				});
				panelProgramador.add(buttonAdd);
				
				buttonMin = new JButton(" <");
				buttonMin.setBounds(246, 70, 50, 35);
				buttonMin.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					    quitarLenguaje();
					}
				});
				panelProgramador.add(buttonMin);
				
				lenguajesSeleccionadosList.setModel(ProgSelect);
				lenguajesSeleccionadosScroll.setBounds(301, 30, 220, 115);
				lenguajesSeleccionadosScroll.setViewportView(lenguajesSeleccionadosList);
				panelProgramador.add(lenguajesSeleccionadosScroll);
				
				
				
			}
		}
		{
			PanelPlanificador = new JPanel();
			PanelPlanificador.setLayout(null);
			PanelPlanificador.setBounds(10, 311, 525, 137);
			contentPanel.add(PanelPlanificador);
			{
				JLabel lblFrecuencia = new JLabel("Frecuencia:");
				lblFrecuencia.setBounds(10, 25, 135, 14);
				PanelPlanificador.add(lblFrecuencia);
			}
			
			spnFrecuencia = new JSpinner();
			spnFrecuencia.setBounds(155, 22, 86, 20);
			PanelPlanificador.add(spnFrecuencia);
		}
		{
			PanelJefe = new JPanel();
			PanelJefe.setBounds(10, 311, 525, 137);
			contentPanel.add(PanelJefe);
			PanelJefe.setLayout(null);
			{
				JLabel lblCantidad = new JLabel("Cantidad de Trabajadores:");
				lblCantidad.setBounds(10, 25, 135, 14);
				PanelJefe.add(lblCantidad);
			}
			{
				spnCantidad = new JSpinner();
				spnCantidad.setBounds(155, 22, 86, 20);
				PanelJefe.add(spnCantidad);
				//txtCantidad.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						registrarTrabajador();
					}
				});
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
		llenarListaLenguajes();
	}
	
	private void registrarTrabajador() {
		if(validarCampos()) {
			Trabajador trabajador = null;
			if(rdbtnJefe.isSelected()) {
				trabajador = new JefeProyecto(textId.getText(),textNombre.getText(),textApellido.getText(),textDireccion.getText(), (int)spinnerEdad.getValue(), textSexo.getText(), Float.parseFloat(textSalario.getText()),"sin evaluar",Double.parseDouble(textPagoPorHora.getText()), (int)spnCantidad.getValue());
				
			}else if(rdbtnDisenador.isSelected()) {
				trabajador = new Disenador(textId.getText(),textNombre.getText(),textApellido.getText(),textDireccion.getText(), (int)spinnerEdad.getValue(), textSexo.getText(), Float.parseFloat(textSalario.getText()),"sin evaluar",Double.parseDouble(textPagoPorHora.getText()), comboTipo.getSelectedItem().toString());
			}else if(rdbtnPlanificador.isSelected()) {
				trabajador  = new Planificador(textId.getText(),textNombre.getText(),textApellido.getText(),textDireccion.getText(), (int)spinnerEdad.getValue(), textSexo.getText(), Float.parseFloat(textSalario.getText()),"sin evaluar",Double.parseDouble(textPagoPorHora.getText()), (int)spnFrecuencia.getValue());
			}else if(rdbtnProgramador.isSelected()) {
				ArrayList<String> listadoLenguajes = new ArrayList<String>();
				for(int i=0; i<lenguajesSeleccionadosList.getModel().getSize();i++) {
					listadoLenguajes.add(lenguajesSeleccionadosList.getModel().getElementAt(i));
				}
				trabajador = new Programador(textId.getText(),textNombre.getText(),textApellido.getText(),textDireccion.getText(), (int)spinnerEdad.getValue(), textSexo.getText(), Float.parseFloat(textSalario.getText()),"sin evaluar",Double.parseDouble(textPagoPorHora.getText()), listadoLenguajes);
			}
			Empresa.getInstance().RegistrarTrabajador(trabajador);
			JOptionPane.showMessageDialog(null, "Trabajador registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		    limpiarCampos();
		}
	}
	
	private void limpiarCampos() {
		textId.setText(null);
		textNombre.setText(null);
		textApellido.setText(null);
		textDireccion.setText(null);
		spinnerEdad.setValue(0);
		spinnerEdad.setValue(0);
		textSexo.setText(null);
		textSalario.setText(null);
		textPagoPorHora.setText(null);
		spnCantidad.setValue(0);
		comboTipo.setSelectedIndex(0);
		spnFrecuencia.setValue(0);
		ProgDisp.clear();
		llenarListaLenguajes();
		ProgSelect.clear();
		lenguajesDisponiblesList.setModel(ProgDisp);
		lenguajesSeleccionadosList.setModel(ProgSelect);
	}
	
	private boolean validarCampos() {
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
		if(textPagoPorHora.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo pago por hora es necesario\n";
			datosValidos = false;
		}else if(!textPagoPorHora.getText().matches("[-+]?[0-9]*\\.?[0-9]+")) { //validar si es un número float, int, etc.
			mensajeValidacion += "*El campo pago por hora debe ser double\n";
			datosValidos = false;
		}
		if(textApellido.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo apellid0 es necesario\n";
			datosValidos = false;
		}
		
		if(textSalario.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo salario es necesario\n";
			datosValidos = false;
		}else if(!textSalario.getText().matches("[-+]?[0-9]*\\.?[0-9]+")) { //validar si es un número float, int, etc.
			mensajeValidacion += "*El campo salario debe ser float\n";
			datosValidos = false;
		}
		
	    if((int)spinnerEdad.getValue() == 0) {
	    	mensajeValidacion += "*La edad debe ser mayor a cero\n";
			datosValidos = false;
	    }
	
		if(textSexo.getText().trim().isEmpty()) {
			mensajeValidacion += "*El campo sexo es necesario\n";
			datosValidos = false;
		}
		
		if(textId.getText().trim().isEmpty()) {
			mensajeValidacion += "*El identificador es necesario\n";
			datosValidos = false;
		}
		else if(Empresa.getInstance().existeIdTrabajador(textId.getText())) {
			mensajeValidacion += "*El identificador ya ha sido utilizado\n";
			datosValidos = false;
		}
		
		if(rdbtnJefe.isSelected()) {
			if((int)spnCantidad.getValue() == 0) {
		    	mensajeValidacion += "*La cantidad de trabajadores debe ser mayor a cero para el Jefe\n";
				datosValidos = false;
		    }
		}else if(rdbtnDisenador.isSelected()) {
			if(comboTipo.getSelectedIndex() == 0) {
				mensajeValidacion += "*Debe seleccionar un tipo de diseñador\n";
				datosValidos = false;
			}
		}else if(rdbtnPlanificador.isSelected()) {
			if((int)spnFrecuencia.getValue() == 0) {
		    	mensajeValidacion += "*El planificador debe tener una frecuencia mayor a cero\n";
				datosValidos = false;
		    }
		}else if(rdbtnProgramador.isSelected()) {
			if(lenguajesSeleccionadosList.getModel().getSize() == 0) {
				mensajeValidacion += "*Indique los lenguajes de programación\n";
				datosValidos = false;
			}
		}
		
		if(datosValidos == false) {
			JOptionPane.showMessageDialog(this, mensajeValidacion, "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
		return datosValidos;
	}
	
	
	private void agregarLenguaje() {
		ProgDisp = ((DefaultListModel<String>)lenguajesDisponiblesList.getModel());
		ProgSelect = ((DefaultListModel<String>)lenguajesSeleccionadosList.getModel());
		for (int lenguaje : lenguajesDisponiblesList.getSelectedIndices()) {
			ProgSelect.addElement(ProgDisp.getElementAt(lenguaje));
			ProgDisp.removeElement(ProgDisp.getElementAt(lenguaje));
		}
		
	}
	
	private void quitarLenguaje() {
		ProgDisp = ((DefaultListModel<String>)lenguajesDisponiblesList.getModel());
		ProgSelect = ((DefaultListModel<String>)lenguajesSeleccionadosList.getModel());
		for (int lenguaje : lenguajesSeleccionadosList.getSelectedIndices()) {
			ProgDisp.addElement(ProgSelect.getElementAt(lenguaje));
			ProgSelect.removeElement(ProgSelect.getElementAt(lenguaje));
		}
	}

	private void llenarListaLenguajes() {
		ProgDisp.addElement("Java");
		ProgDisp.addElement("C#");
		ProgDisp.addElement("Kotlin");
		ProgDisp.addElement("Visual Basic");
		ProgDisp.addElement("C");
		ProgDisp.addElement("C++");
		ProgDisp.addElement("Ruby");
		ProgDisp.addElement("Perl");
		ProgDisp.addElement("Phyton");
		ProgDisp.addElement("Php");
		ProgDisp.addElement("JavaScript");
		ProgDisp.addElement("Assembler");
	}
}
