package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ListPanel extends JPanel {
	
	private JTable table;
	
	public ListPanel(String[][] tableData, String[] tableColumns, String title) {
		setLayout(null);
		this.setSize(new Dimension(600, 476));
		
		JLabel lblIncludepanel = new JLabel(title, SwingConstants.CENTER);
		lblIncludepanel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIncludepanel.setBounds(12, 12, 576, 32);
		add(lblIncludepanel);
		
		table = new JTable(tableData, tableColumns);
		table.setBounds(12, 122, 563, 236);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 56, 576, 409);
		add(scrollPane);
	}
	
}
