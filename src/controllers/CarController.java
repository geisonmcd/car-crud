package controllers;

import java.util.List;

import entities.Car;
import service.CarService;
import views.IncludePanel;
import views.MainWindow;
import views.PhysicalListPanel;

public class CarController {
	
	MainWindow mainWindow;
	IncludePanel includePanel;
	PhysicalListPanel physicalListPanel;
	CarService carService;
	
	public CarController() {
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		mainWindow.includeMenuItem.addActionListener(e -> showIncludePanel());
		mainWindow.phyisicalListMenuItem.addActionListener(e -> showPhysicalListPanel());
		carService = new CarService();
	}

	private void showIncludePanel() {
		includePanel = new IncludePanel();
		includePanel.btnIncluir.addActionListener(e -> insertCar());
		mainWindow.getContentPane().add(includePanel);
		mainWindow.setVisible(true);
		hideOtherPanels();
		includePanel.setVisible(true);
	}
	
	 void showPhysicalListPanel() {
		List<Car> cars = carService.list();
		physicalListPanel = new PhysicalListPanel(this.buildTableData(cars));
		mainWindow.getContentPane().add(physicalListPanel);
		mainWindow.setVisible(true);
		physicalListPanel.setVisible(true);
	}
	
	private String[][] buildTableData(List<Car> cars) {
		String[][] data = new String[cars.size()][2];
		int index = 0;
		for (Car car : cars) {
			data[index][0] = car.getChassi();
			data[index][1] = car.getYearAsString();
			index++;
		}
		return data;
	}

	private void insertCar() {
		String chassi = includePanel.txtChassi.getText();
		String brand = includePanel.txtMarca.getText();
		String model = includePanel.txtModelo.getText();
		String price = includePanel.txtPreco.getText();
		String year = includePanel.txtAno.getText();
		Car newCar = new Car(chassi, brand, model, Integer.valueOf(year), Double.valueOf(price));
		carService.save(newCar);
	}
	
	private void hideOtherPanels() {
		if (physicalListPanel != null) physicalListPanel.setVisible(false);
		if (includePanel != null) includePanel.setVisible(false);
	}

}
