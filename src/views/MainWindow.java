package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	public JMenuItem includeMenuItem;
	public JMenuItem phyisicalListMenuItem;
	public JMenu carMenu;
	public JMenuBar menuBar; 

	public MainWindow() {
		super("Carros");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		menuBar = new JMenuBar();
		carMenu = new JMenu("Carros");
		includeMenuItem = new JMenuItem("Incluir");
		phyisicalListMenuItem = new JMenuItem("Listar (Físico)");
		getContentPane().add(menuBar, BorderLayout.NORTH);
		menuBar.add(carMenu);
		carMenu.add(includeMenuItem);
		carMenu.add(phyisicalListMenuItem);
	}
}
