package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class PropertiesPanel extends JPanel {
	
	public JLabel lblSize;
	public JLabel lblNumberOfRegisters;
	public JButton btnClearfile;
	
	public PropertiesPanel(long fileSize, long numberOfRegisters) {
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		JLabel lblProperties = new JLabel("PROPRIEDADES", SwingConstants.CENTER);
		lblProperties.setFont(new Font("Dialog", Font.BOLD, 18));
		lblProperties.setBounds(12, 12, 576, 32);
		add(lblProperties);
		
		JLabel lblSizeLbl = new JLabel("Tamanho", SwingConstants.CENTER);
		lblSizeLbl.setBounds(12, 93, 576, 15);
		add(lblSizeLbl);
		
		lblSize = new JLabel(Long.toString(fileSize) + " bytes", SwingConstants.CENTER);
		lblSize.setBounds(12, 120, 576, 15);
		add(lblSize);
		
		JLabel lblNumberOfRegistersLbl = new JLabel("Número de registros", SwingConstants.CENTER);
		lblNumberOfRegistersLbl.setBounds(12, 212, 576, 15);
		add(lblNumberOfRegistersLbl);
		
		lblNumberOfRegisters = new JLabel(Long.toString(numberOfRegisters), SwingConstants.CENTER);
		lblNumberOfRegisters.setBounds(12, 239, 576, 15);
		add(lblNumberOfRegisters);
		
		btnClearfile = new JButton("Limpar Arquivo");
		btnClearfile.setBounds(239, 325, 139, 25);
		add(btnClearfile);
	}
}
