package controllers;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

import button.ButtonEditor;
import button.ButtonRenderer;
import entities.Car;
import views.FindPanel;
import views.PhysicalListPanel;

public class FindPanelController extends PanelController{
	
	private static final int CHASSI_COLUMN_POSITION = 0;
	private static final int BRAND_COLUMN_POSITION = 1;
	private static final int MODEL_COLUMN_POSITION = 2;
	private static final int YEAR_COLUMN_POSITION = 3;
	private static final int PRICE_COLUMN_POSITION = 4;
	FindPanel findPanel;

	public FindPanelController() {
		findPanel = new FindPanel();
		findPanel.findButton.addActionListener(e2 -> findRegister(findPanel.txtFind.getText()));
		findPanel.tableModel.addTableModelListener(e2 -> tableChanged(e2));
	}

	void showFindPanel(ActionEvent e) {
//		hideOtherPanels("findPanel");
		findPanel.setVisible(true);
	}
	
	void findRegister(String text) {
		List<Car> cars = carService.find(text);
		String[] tableColumns = {"Chassi", "Marca", "Modelo", "Ano", "Preco", "Delete"};
		findPanel.tableModel.setDataVector(buildTableDataWithButton(cars), tableColumns);
		findPanel.table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
	    findPanel.table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));
	}
	
	private String[][] buildTableDataWithButton(List<Car> cars) {
		String[][] data = new String[cars.size()][6];
		int index = 0;
		for (Car car : cars) {
			data[index][0] = car.getChassi();
			data[index][1] = car.getBrand();
			data[index][2] = car.getModel();
			data[index][3] = car.getYearAsString();
			data[index][4] = car.getPriceAsString();
			data[index][5] = "Delete " + car.getChassi();
			index++;
		}
		return data;
	}
	
	void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		if (row == -1 || column == -1)
			return;
		TableModel model = (TableModel) e.getSource();
		String chassi = (String) model.getValueAt(row, 0);
		Car car = new Car(chassi);
		Object data = model.getValueAt(row, column);
		switch (column) {
		case CHASSI_COLUMN_POSITION:
			return;
		case BRAND_COLUMN_POSITION:
			car.setBrand((String) data);
			break;
		case MODEL_COLUMN_POSITION:
			car.setModel((String) data);
			break;
		case YEAR_COLUMN_POSITION:
			car.setYear(Integer.valueOf((String)data));
			break;
		case PRICE_COLUMN_POSITION:
			car.setPrice(Double.valueOf((String) data));
			break;
		default:
			return;
		}
		carService.update(car);
	}


}
