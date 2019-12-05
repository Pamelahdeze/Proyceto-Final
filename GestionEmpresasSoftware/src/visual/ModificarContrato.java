package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

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
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setTitle("Modificar Contrato");
		setBounds(100, 100, 530, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID Contrato:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel.setBounds(198, 22, 136, 18);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
			textField.setBounds(310, 22, 200, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblIdCliente = new JLabel("ID Cliente:");
			lblIdCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblIdCliente.setBounds(198, 53, 79, 18);
			contentPanel.add(lblIdCliente);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
			textField_1.setColumns(10);
			textField_1.setBounds(310, 53, 200, 20);
			contentPanel.add(textField_1);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fechas del Contrato", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(188, 80, 332, 189);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblFechaInicio.setBounds(10, 36, 109, 18);
		panel.add(lblFechaInicio);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		formattedTextField.setBounds(122, 34, 200, 20);
		panel.add(formattedTextField);
		
		JLabel lblFechaEntrega = new JLabel("Fecha Entrega:");
		lblFechaEntrega.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblFechaEntrega.setBounds(10, 86, 143, 18);
		panel.add(lblFechaEntrega);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
		formattedTextField_1.setBounds(122, 84, 200, 20);
		panel.add(formattedTextField_1);
		{
			JLabel lblProrroga = new JLabel("Pr\u00F3rroga:");
			lblProrroga.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblProrroga.setBounds(10, 136, 79, 18);
			panel.add(lblProrroga);
		}
		{
			JFormattedTextField formattedTextField_2 = new JFormattedTextField();
			formattedTextField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.desktop));
			formattedTextField_2.setBounds(122, 134, 200, 20);
			panel.add(formattedTextField_2);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(0, 0, 178, 280);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		{
			JButton okButton = new JButton("Modificar");
			okButton.setBorder(new LineBorder(Color.BLACK, 2, true));
			okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(10, 246, 158, 23);
			panel_1.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon(ModificarContrato.class.getResource("/imagenes/contract (4).png")));
			lblNewLabel_1.setBounds(32, 11, 136, 224);
			panel_1.add(lblNewLabel_1);
		}
		{
			JLabel label = new JLabel("X");
			label.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION) == 0) {
						ModificarContrato.this.dispose();
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
			label.setBounds(510, 0, 20, 20);
			contentPanel.add(label);
		}
	}
}
