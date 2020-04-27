package controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

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
	CardLayout cardLayout = new CardLayout();
	JPanel parentPanel;

	public CarController() {
	}

	public void execute() {
		mainWindow = new MainWindow();
		includePanelController = new IncludePanelController();
		findPanelController = new FindPanelController();
		parentPanel = new JPanel();
		mainWindow.getContentPane().add(parentPanel);
		parentPanel.setLayout(cardLayout);
		parentPanel.add(includePanelController.includePanel, INCLUDE_PANEL);
		parentPanel.add(findPanelController.findPanel, FIND_PANEL);
		mainWindow.includeMenuItem.addActionListener(e -> showIncludePanel());
		mainWindow.findMenuItem.addActionListener(e -> showFindPanel());
		mainWindow.phyisicalListMenuItem.addActionListener(e -> showPhysicalListPanel());
		mainWindow.logicalListMenuItem.addActionListener(e -> showLogicalListPanel());
		mainWindow.propertiesMenuItem.addActionListener(e -> showPropertiesPanel());
	}

	private void showIncludePanel() {
		cardLayout.show(parentPanel, INCLUDE_PANEL);
	}

	private void showFindPanel() {
		cardLayout.show(parentPanel, FIND_PANEL);
	}

	private void showPhysicalListPanel() {
		physicalListPanelController = new PhysicalListPanelController();
		parentPanel.add(physicalListPanelController.physicalListPanel, PHYSICAL_LIST_PANEL);
		cardLayout.show(parentPanel, PHYSICAL_LIST_PANEL);
	}

	private void showLogicalListPanel() {
		logicalListPanelController = new LogicalListPanelController();
		parentPanel.add(logicalListPanelController.listPanel, LOGICAL_LIST_PANEL);
		cardLayout.show(parentPanel, LOGICAL_LIST_PANEL);
	}

	private void showPropertiesPanel() {
		propertiesPanelController = new PropertiesPanelController();
		parentPanel.add(propertiesPanelController.propertiesPanel, PROPERTIES_PANEL);
		cardLayout.show(parentPanel, PROPERTIES_PANEL);
	}

}