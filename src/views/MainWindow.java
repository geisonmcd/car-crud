package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public JMenuBar menuBar;
	public JMenu carMenu;
	public JMenuItem includeMenuItem;
	public JMenuItem phyisicalListMenuItem;
	public JMenuItem logicalListMenuItem;
	public JMenuItem findMenuItem;
	public JMenu editMenu;
	public JMenuItem propertiesMenuItem;

	public MainWindow() {
		super("Carros");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		menuBar = new JMenuBar();
		carMenu = new JMenu("Carros");
		editMenu = new JMenu("Editar");
		includeMenuItem = new JMenuItem("Incluir");
		phyisicalListMenuItem = new JMenuItem("Listar (Físico)");
		logicalListMenuItem = new JMenuItem("Listar (Lógico)");
		findMenuItem = new JMenuItem("Consultar");
		propertiesMenuItem = new JMenuItem("Propriedades");
		getContentPane().add(menuBar, BorderLayout.NORTH);
		menuBar.add(carMenu);
		menuBar.add(editMenu);
		carMenu.add(includeMenuItem);
		carMenu.add(phyisicalListMenuItem);
		carMenu.add(logicalListMenuItem);
		carMenu.add(findMenuItem);
		editMenu.add(propertiesMenuItem);
	}
}
