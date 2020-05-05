package controller;

import view.PropertiesPanel;

public class PropertiesPanelController extends PanelController {

	PropertiesPanel propertiesPanel;
	
	public PropertiesPanelController() {
		long[] properties = carService.getProperties();
		long fileSize = properties[0];
		long numberOfRegisters = properties[1];
		propertiesPanel = new PropertiesPanel(fileSize, numberOfRegisters);
		propertiesPanel.btnClearfile.addActionListener(e2 -> deleteFile());
	}
	
	private void deleteFile() {
		carService.clearFile();
		propertiesPanel.lblSize.setText("0 bytes");
		propertiesPanel.lblNumberOfRegisters.setText("0");
	}

}
