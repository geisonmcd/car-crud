package controller;

import java.util.List;

import entity.Car;
import service.CarService;

public class PanelController {
	
	CarService carService;

	public PanelController() {
		carService = new CarService();
	}
	
	protected String[][] buildTableData(List<Car> cars, int numberOfColumns, boolean showDeleted) {
		String[][] data = new String[cars.size()][numberOfColumns];
		int index = 0;
		for (Car car : cars) {
			data[index][0] = car.getChassi();
			data[index][1] = car.getBrand();
			data[index][2] = car.getModel();
			data[index][3] = car.getYearAsString();
			data[index][4] = car.getPriceAsString();
			if (showDeleted) data[index][5] = car.getDeletedAsString();
			index++;
		}
		return data;
	}

}
