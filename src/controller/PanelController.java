package controller;

import java.util.List;

import entity.Car;
import service.CarService;

/**
 * Classe pai dos PanelController contendo os métodos e atributos comuns a mais de um PanelController
 * @author geison
 *
 */
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
			index++;
		}
		return data;
	}

}
