package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import entities.Car;
import views.IncludePanel;

public class IncludePanelController extends PanelController{
	
	IncludePanel includePanel;
	
	public IncludePanelController() {
		includePanel = new IncludePanel();
		includePanel.btnIncluir.addActionListener(e2 -> insertCar());
	}

	private void insertCar() {
		String chassi = includePanel.txtChassi.getText();
		String brand = includePanel.txtMarca.getText();
		String model = includePanel.txtModelo.getText();
		String price = includePanel.txtPreco.getText();
		String year = includePanel.txtAno.getText();
		Car newCar = new Car(chassi, brand, model, Integer.valueOf(year), Double.valueOf(price) );
		carService.save(newCar);
	}

}
