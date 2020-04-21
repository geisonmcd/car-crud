package controllers;

import java.util.List;

import entities.Car;
import views.LogicalListPanel;

public class LogicalListPanelController extends PanelController{
	
	LogicalListPanel logicalListPanel;
	private static final int NUMBER_OF_COLUMNS = 5;
	
	public LogicalListPanelController () {
		List<Car> cars = carService.list(false);
		logicalListPanel = new LogicalListPanel(super.buildTableData(cars, NUMBER_OF_COLUMNS, false));
	}
	
}
