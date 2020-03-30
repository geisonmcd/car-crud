package controllers;

import entities.Car;
import service.CarService;
import views.IncludePanel;
import views.MainFrame;

public class CarController {
	
	MainFrame mainFrame;
	IncludePanel includePanel;
	CarService carService;
	
	public CarController() {
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		mainFrame.mntmIncluir.addActionListener(e -> showIncludePanel());
		carService = new CarService();
	}

	private void showIncludePanel() {
		includePanel = new IncludePanel();
		includePanel.btnIncluir.addActionListener(e -> insertCar());
		mainFrame.getContentPane().add(includePanel);
		mainFrame.setVisible(true);
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

}
