package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class FindPanel extends JPanel {
	
	public JTextField txtFind;
	public JButton findButton;
	public JTable table;
	public String[] tableColumns = {"Chassi", "Marca", "Modelo", "Ano", "Preco", "Delete"};
	public DefaultTableModel tableModel;
	
	public FindPanel() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));
		
		JLabel lblIncludepanel = new JLabel("BUSCAR", SwingConstants.CENTER);
		lblIncludepanel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIncludepanel.setBounds(12, 12, 576, 32);
		add(lblIncludepanel);
		
		txtFind = new JTextField();
		txtFind.setToolTipText("Digite o chassi ou descrição");
		txtFind.setBounds(12, 99, 417, 25);
		add(txtFind);
		txtFind.setColumns(10);
		
		findButton = new JButton("Buscar");
		findButton.setBounds(458, 99, 130, 25);
		add(findButton);
		
		tableModel = new DefaultTableModel(new String[0][0], tableColumns);
		table = new JTable(tableModel);
		table.setBounds(12, 122, 563, 236);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 139, 576, 398);
		add(scrollPane);
	}
}
