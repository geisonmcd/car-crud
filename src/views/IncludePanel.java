package views;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

		JLabel lblIncludepanel = new JLabel("Incluir Carro");
		lblIncludepanel.setBounds(156, 29, 158, 15);
		add(lblIncludepanel);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(12, 61, 114, 15);
		add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setText("Wolkswagen");
		txtMarca.setBounds(12, 87, 114, 19);
		add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(12, 128, 70, 15);
		add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setText("2014");
		txtAno.setBounds(12, 155, 114, 19);
		add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(12, 236, 114, 15);
		add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setText("32554.89");
		txtPreco.setBounds(12, 263, 114, 19);
		add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(216, 61, 70, 15);
		add(lblChassi);
		
		txtChassi = new JTextField();
		txtChassi.setText("0198230879");
		txtChassi.setBounds(213, 87, 114, 19);
		add(txtChassi);
		txtChassi.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(216, 128, 70, 15);
		add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setText("Jetta");
		txtModelo.setBounds(213, 155, 114, 19);
		add(txtModelo);
		txtModelo.setColumns(10);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(447, 461, 117, 25);
		add(btnIncluir);
	}
}
