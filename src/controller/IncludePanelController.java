package controller;

import javax.swing.JOptionPane;

import entity.Car;
import exception.CarAlreadyExistsException;
import view.IncludePanel;

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
		Integer year = includePanel.txtAno.getText().equals("") ? 0 : Integer.valueOf(includePanel.txtAno.getText());
		Double price = includePanel.txtPreco.getText().equals("") ? 0 : Double.valueOf(includePanel.txtPreco.getText());
		if (chassi.equals("") || model.equals("")) {
			JOptionPane.showMessageDialog(null, "Chassi e modelo são obrigatórios");
			return;
		}
		Car newCar = new Car(chassi, brand, model, year, price);
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
