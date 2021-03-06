package controller;

import java.util.List;

import entity.Car;
import view.ListPanel;

public class LogicalListPanelController extends PanelController{
	
	ListPanel listPanel;
	private static final int NUMBER_OF_COLUMNS = 5;
	private static final String[] COLUMNS = {"Chassi", "Marca", "Modelo", "Ano", "Preco"};
	
	public LogicalListPanelController () {
		List<Car> cars = carService.list(false);
		listPanel = new ListPanel(super.buildTableData(cars, NUMBER_OF_COLUMNS, false), COLUMNS, "LISTAR (LÓGICO)");
	}
	
}
