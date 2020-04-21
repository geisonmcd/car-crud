package controllers;

import java.awt.event.ActionEvent;
import java.util.List;

import entities.Car;
import views.ListPanel;

public class PhysicalListPanelController extends PanelController{
	
	ListPanel physicalListPanel;
	private static final int NUMBER_OF_COLUMNS = 6;
	private static String[] COLUMNS = {"Chassi", "Marca", "Modelo", "Ano", "Preco", "Excluído"};
	
	public PhysicalListPanelController () {
		List<Car> cars = carService.list(true);
		physicalListPanel = new ListPanel(super.buildTableData(cars, NUMBER_OF_COLUMNS, true), COLUMNS);
	}
	
	void showPhysicalListPanel(ActionEvent e) {
		physicalListPanel.setVisible(true);
	}
}
