package controllers;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import entities.Car;
import service.CarAlreadyExistsException;
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
		Car newCar = new Car(chassi, brand, model, Integer.valueOf(year), Double.valueOf(price));
		try {
			carService.save(newCar);
			JOptionPane.showMessageDialog(null, "Carro inserido com sucesso");
			clearFields();
		} catch (CarAlreadyExistsException caee) {
			JOptionPane.showMessageDialog(null, caee.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void clearFields() {
		includePanel.txtChassi.setText("");
		includePanel.txtMarca.setText("");
		includePanel.txtModelo.setText("");
		includePanel.txtPreco.setText("");
		includePanel.txtAno.setText("");
	}

}
