package controllers;

import java.awt.event.ActionEvent;
import java.util.List;

import entities.Car;
import views.PhysicalListPanel;

public class PhysicalListPanelController extends PanelController{
	
	PhysicalListPanel physicalListPanel;
	private static final int NUMBER_OF_COLUMNS = 6;
	
	public PhysicalListPanelController () {
		List<Car> cars = carService.list(true);
		physicalListPanel = new PhysicalListPanel(super.buildTableData(cars, NUMBER_OF_COLUMNS, true));
	}
	
	void showPhysicalListPanel(ActionEvent e) {
		physicalListPanel.setVisible(true);
	}
}
