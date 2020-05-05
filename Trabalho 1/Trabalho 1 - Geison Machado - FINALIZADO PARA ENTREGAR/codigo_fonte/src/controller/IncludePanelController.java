package controller;

import javax.swing.JOptionPane;

import entity.Car;
import exception.CarAlreadyExistsException;
import view.IncludePanel;

public class IncludePanelController extends PanelController{
	
	IncludePanel includePanel;
	
	public IncludePanelController() {
		includePanel = new IncludePanel();
		includePanel.btnInclude.addActionListener(e2 -> insertCar());
	}

	private void insertCar() {
		String chassi = includePanel.txtChassi.getText();
		String brand = includePanel.txtBrand.getText();
		String model = includePanel.txtModel.getText();
		Integer year = includePanel.txtYear.getText().equals("") ? 0 : Integer.valueOf(includePanel.txtYear.getText());
		Double price = includePanel.txtPrice.getText().equals("") ? 0 : Double.valueOf(includePanel.txtPrice.getText());
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
		includePanel.txtBrand.setText("");
		includePanel.txtModel.setText("");
		includePanel.txtPrice.setText("");
		includePanel.txtYear.setText("");
	}

}
