package controller;

import view.MainWindow;

public class CarController {

	private static final String INCLUDE_PANEL = "includePanel";
	private static final String FIND_PANEL = "findPanel";
	private static final String PHYSICAL_LIST_PANEL = "physicalListPanel";
	private static final String LOGICAL_LIST_PANEL = "logicalListPanel";
	private static final String PROPERTIES_PANEL = "propertiesPanel";
	MainWindow mainWindow;
	IncludePanelController includePanelController;
	PhysicalListPanelController physicalListPanelController;
	LogicalListPanelController logicalListPanelController;
	FindPanelController findPanelController;
	PropertiesPanelController propertiesPanelController;

	public CarController() {
	}

	public void execute() {
		mainWindow = new MainWindow();
		includePanelController = new IncludePanelController();
		findPanelController = new FindPanelController();
		mainWindow.parentPanel.add(includePanelController.includePanel, INCLUDE_PANEL);
		mainWindow.parentPanel.add(findPanelController.findPanel, FIND_PANEL);
		mainWindow.includeMenuItem.addActionListener(e -> showIncludePanel());
		mainWindow.findMenuItem.addActionListener(e -> showFindPanel());
		mainWindow.phyisicalListMenuItem.addActionListener(e -> showPhysicalListPanel());
		mainWindow.logicalListMenuItem.addActionListener(e -> showLogicalListPanel());
		mainWindow.propertiesMenuItem.addActionListener(e -> showPropertiesPanel());
	}

	private void showIncludePanel() {
		mainWindow.cardLayout.show(mainWindow.parentPanel, INCLUDE_PANEL);
	}

	private void showFindPanel() {
		mainWindow.cardLayout.show(mainWindow.parentPanel, FIND_PANEL);
	}

	private void showPhysicalListPanel() {
		physicalListPanelController = new PhysicalListPanelController();
		mainWindow.parentPanel.add(physicalListPanelController.physicalListPanel, PHYSICAL_LIST_PANEL);
		mainWindow.cardLayout.show(mainWindow.parentPanel, PHYSICAL_LIST_PANEL);
	}

	private void showLogicalListPanel() {
		logicalListPanelController = new LogicalListPanelController();
		mainWindow.parentPanel.add(logicalListPanelController.listPanel, LOGICAL_LIST_PANEL);
		mainWindow.cardLayout.show(mainWindow.parentPanel, LOGICAL_LIST_PANEL);
	}

	private void showPropertiesPanel() {
		propertiesPanelController = new PropertiesPanelController();
		mainWindow.parentPanel.add(propertiesPanelController.propertiesPanel, PROPERTIES_PANEL);
		mainWindow.cardLayout.show(mainWindow.parentPanel, PROPERTIES_PANEL);
	}

}