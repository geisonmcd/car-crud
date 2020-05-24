package controller;

import view.PropertiesPanel;

public class PropertiesPanelController extends PanelController {

	PropertiesPanel propertiesPanel;
	
	public PropertiesPanelController() {

		propertiesPanel = new PropertiesPanel(carService.getRegisterCount());
		propertiesPanel.btnClearfile.addActionListener(e2 -> deleteFile());
		propertiesPanel.btnCreateTable.addActionListener(e -> createTable());
	}
	
	private void deleteFile() {
		carService.clearFile();
		propertiesPanel.lblNumberOfRegisters.setText("0");
	}
	
	private void createTable() {
		carService.createTableIfNotExists();
		propertiesPanel.showTableCreatedMessage();
	}

}
