package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public JMenuItem mntmIncluir;

	public MainFrame() {
		super("Carros");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnCarros = new JMenu("Carros");
		menuBar.add(mnCarros);
		
		mntmIncluir = new JMenuItem("Incluir");
		mnCarros.add(mntmIncluir);

	}
}
