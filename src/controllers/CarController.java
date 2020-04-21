package controllers;

import java.awt.CardLayout;

import javax.swing.JPanel;

import views.MainWindow;

public class CarController {

	MainWindow mainWindow;
	IncludePanelController includePanelController;
	PhysicalListPanelController physicalListPanelController;
	LogicalListPanelController logicalListPanelController;
	FindPanelController findPanelController;
    CardLayout cardLayout = new CardLayout();
    JPanel parentPanel;

	public CarController() {
		mainWindow = new MainWindow();
		includePanelController = new IncludePanelController();
		findPanelController = new FindPanelController();
		parentPanel = new JPanel();
		mainWindow.getContentPane().add(parentPanel);
		parentPanel.setLayout(cardLayout);
		parentPanel.add(includePanelController.includePanel, "pnlFirst");
		parentPanel.add(findPanelController.findPanel, "pnlSecond");
		mainWindow.includeMenuItem.addActionListener(e -> cardLayout.show(parentPanel, "pnlFirst"));
		mainWindow.findMenuItem.addActionListener(e -> cardLayout.show(parentPanel, "pnlSecond"));
		mainWindow.phyisicalListMenuItem.addActionListener(e -> showPhysicalListPanel());
		mainWindow.logicalListMenuItem.addActionListener(e -> showLogicalListPanel());
	}
	
	void showPhysicalListPanel() {
		physicalListPanelController = new PhysicalListPanelController();
		parentPanel.add(physicalListPanelController.physicalListPanel, "pnlThird");
		cardLayout.show(parentPanel, "pnlThird");
	}
	
	void showLogicalListPanel() {
		logicalListPanelController = new LogicalListPanelController();
		parentPanel.add(logicalListPanelController.listPanel, "logicalListPanel");
		cardLayout.show(parentPanel, "logicalListPanel");
	}

}