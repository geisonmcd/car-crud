package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public JMenuBar menuBar;
	public JMenu carMenu;
	public JMenuItem includeMenuItem;
	public JMenuItem phyisicalListMenuItem;
	public JMenuItem findMenuItem;
	public JMenu editMenu;
	public JMenuItem propertiesMenuItem;
	public JPanel parentPanel;
	public CardLayout cardLayout;

	public MainWindow() {
		super("Carros");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		menuBar = new JMenuBar();
		carMenu = new JMenu("Carros");
		editMenu = new JMenu("Editar");
		includeMenuItem = new JMenuItem("Incluir");
		phyisicalListMenuItem = new JMenuItem("Listar (Físico)");
		findMenuItem = new JMenuItem("Consultar");
		propertiesMenuItem = new JMenuItem("Propriedades");
		getContentPane().add(menuBar, BorderLayout.NORTH);
		menuBar.add(carMenu);
		menuBar.add(editMenu);
		carMenu.add(includeMenuItem);
		carMenu.add(phyisicalListMenuItem);
		carMenu.add(findMenuItem);
		editMenu.add(propertiesMenuItem);
		cardLayout = new CardLayout();
		parentPanel = new JPanel();
		getContentPane().add(parentPanel);
		parentPanel.setLayout(cardLayout);
	}
}
