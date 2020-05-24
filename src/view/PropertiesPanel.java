package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class PropertiesPanel extends JPanel {

	public JLabel lblNumberOfRegisters;
	public JButton btnClearfile;
	public JButton btnCreateTable;

	public PropertiesPanel(int numberOfRegisters) {
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		JLabel lblProperties = new JLabel("PROPRIEDADES", SwingConstants.CENTER);
		lblProperties.setFont(new Font("Dialog", Font.BOLD, 18));
		lblProperties.setBounds(12, 12, 576, 32);
		add(lblProperties);

		JLabel lblNumberOfRegistersLbl = new JLabel("Número de registros", SwingConstants.CENTER);
		lblNumberOfRegistersLbl.setBounds(12, 84, 576, 15);
		add(lblNumberOfRegistersLbl);

		lblNumberOfRegisters = new JLabel(Long.toString(numberOfRegisters), SwingConstants.CENTER);
		lblNumberOfRegisters.setBounds(12, 111, 576, 15);
		add(lblNumberOfRegisters);

		btnClearfile = new JButton("Limpar Arquivo");
		btnClearfile.setBounds(239, 325, 139, 25);
		add(btnClearfile);

		btnCreateTable = new JButton("Criar Tabela");
		btnCreateTable.setBounds(239, 202, 139, 25);
		add(btnCreateTable);
	}

	public void showTableCreatedMessage() {
		JOptionPane.showMessageDialog(null, "Tabela criada");
	}
}
