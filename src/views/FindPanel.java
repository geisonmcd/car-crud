package views;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class FindPanel extends JPanel {
	
	public JTextField txtFind;
	public JButton findButton;
	public JTable table;
	public String[] tableColumns = {"Chassi", "Marca", "Modelo", "Ano", "Preco"};
	public DefaultTableModel tableModel;
	
	public FindPanel() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));
		
		txtFind = new JTextField();
		txtFind.setToolTipText("Digite o chassei ou descrição");
		txtFind.setBounds(12, 80, 417, 25);
		add(txtFind);
		txtFind.setColumns(10);
		
		findButton = new JButton("Buscar");
		findButton.setBounds(458, 80, 117, 25);
		add(findButton);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(250, 12, 70, 15);
		add(lblNewLabel);
		
		tableModel = new DefaultTableModel(new String[0][0], tableColumns);
		table = new JTable(tableModel);
		table.setBounds(12, 122, 563, 236);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 122, 563, 236);
		add(scrollPane);
	}
}
