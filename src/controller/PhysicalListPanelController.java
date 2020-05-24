package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import entity.Car;
import view.ListPanel;

public class PhysicalListPanelController extends PanelController{
	
	ListPanel physicalListPanel;
	private static final int NUMBER_OF_COLUMNS = 6;
	private static String[] COLUMNS = {"Chassi", "Marca", "Modelo", "Ano", "Preco"};
	
	public PhysicalListPanelController () {
		List<Car> cars = carService.list(true);
		physicalListPanel = new ListPanel(super.buildTableData(cars, NUMBER_OF_COLUMNS, true), COLUMNS, "LISTAR");
	}
	
	void showPhysicalListPanel(ActionEvent e) {
		physicalListPanel.setVisible(true);
	}
}
