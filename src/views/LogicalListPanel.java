package views;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class LogicalListPanel extends JPanel {
	
	private JTable table;
	public String[] tableColumns = {"Chassi", "Marca", "Modelo", "Ano", "Preco"};
	
	public LogicalListPanel(String[][] tableData) {
		setLayout(null);
		this.setSize(new Dimension(600, 600));
		table = new JTable(tableData, tableColumns);
		table.setBounds(60, 94, 490, 297);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 94, 490, 297);
		add(scrollPane);
	}
	
	public String[] getColumns() {
		return tableColumns;
	}

	public void setColumns(String[] columns) {
		this.tableColumns = columns;
	}

	public String[] getTableColumns() {
		return tableColumns;
	}

	public void setTableColumns(String[] tableColumns) {
		this.tableColumns = tableColumns;
	}

}
