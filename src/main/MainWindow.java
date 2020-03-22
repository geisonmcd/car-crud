package main;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	MainWindow() {
		super("Carros");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);

		//comoentario
		JMenuBar jMenuBar = new JMenuBar();
		this.setJMenuBar(jMenuBar);

		JMenu menuManutencao = new JMenu("Manutenção");
		jMenuBar.add(menuManutencao);

		JMenu menuCarro = new JMenu("Carro");
		menuManutencao.add(menuCarro);

		JMenuItem jMenuItemIncluir = new JMenuItem("Incluir");
		menuCarro.add(jMenuItemIncluir);
		
		jMenuItemIncluir.addActionListener(e ->	JOptionPane.showMessageDialog(null,"Hello World"));
	}

}
