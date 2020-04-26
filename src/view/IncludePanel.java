package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class IncludePanel extends JPanel {
	
	public JTextField txtMarca;
	public JTextField txtAno;
	public JTextField txtPreco;
	public JTextField txtChassi;
	public JTextField txtModelo;
	public JButton btnIncluir;

	public IncludePanel() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		JLabel lblIncludepanel = new JLabel("INCLUIR", SwingConstants.CENTER);
		lblIncludepanel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIncludepanel.setBounds(12, 12, 576, 32);
		add(lblIncludepanel);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(12, 180, 114, 15);
		add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(12, 207, 196, 19);
		add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(12, 264, 70, 15);
		add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setBounds(12, 305, 196, 19);
		add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(247, 264, 114, 15);
		add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(247, 305, 217, 19);
		add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(12, 99, 70, 15);
		add(lblChassi);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(12, 126, 196, 19);
		add(txtChassi);
		txtChassi.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(251, 180, 70, 15);
		add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(251, 207, 213, 19);
		add(txtModelo);
		txtModelo.setColumns(10);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(447, 461, 117, 25);
		add(btnIncluir);
	}
}
