package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class IncludePanel extends JPanel {

	public JTextField txtBrand;
	public JTextField txtYear;
	public JTextField txtPrice;
	public JTextField txtChassi;
	public JTextField txtModel;
	public JButton btnInclude;

	public IncludePanel() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		JLabel lblIncludepanel = new JLabel("INCLUIR", SwingConstants.CENTER);
		lblIncludepanel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIncludepanel.setBounds(12, 12, 576, 32);
		add(lblIncludepanel);

		JLabel lblBrand = new JLabel("Marca");
		lblBrand.setBounds(12, 180, 114, 15);
		add(lblBrand);

		txtBrand = new JTextField();
		txtBrand.setBounds(12, 207, 196, 19);
		txtBrand.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtBrand.getText().length() > 12) {
					txtBrand.setText(txtBrand.getText().substring(0, 12));
				}
			}
		});
		add(txtBrand);

		JLabel lblYear = new JLabel("Ano");
		lblYear.setBounds(12, 264, 70, 15);
		add(lblYear);

		txtYear = new JTextField();
		txtYear.setBounds(12, 305, 196, 19);
		txtYear.setColumns(10);
		txtYear.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtYear.getText().equals("")) return;
				try {
					Integer.valueOf(txtYear.getText());
					if(txtYear.getText().length() != 4) throw new Exception();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ano inválido");
					txtYear.setText("");
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(txtYear);

		JLabel lblPrice = new JLabel("Preco");
		lblPrice.setBounds(247, 264, 114, 15);
		add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setBounds(247, 305, 217, 19);
		add(txtPrice);
		txtPrice.setColumns(10);
		txtPrice.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtPrice.getText().equals(""))
					return;
				try {
					Double.valueOf(txtPrice.getText());
				} catch (NumberFormatException c) {
					JOptionPane.showMessageDialog(null, "Preço inválido");
					txtPrice.setText("");
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(12, 99, 70, 15);
		add(lblChassi);

		txtChassi = new JTextField(12);
		txtChassi.setBounds(12, 126, 196, 19);
		txtChassi.addKeyListener( new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtChassi.getText().length() > 12) {
					txtChassi.setText(txtChassi.getText().substring(0, 12));
				}
			}
		});
		txtChassi.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (!txtChassi.getText().equals("") && !txtModel.getText().equals("")) {
					btnInclude.setEnabled(true);
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(txtChassi);

		JLabel lblModel = new JLabel("Modelo");
		lblModel.setBounds(251, 180, 70, 15);
		add(lblModel);

		txtModel = new JTextField(12);
		txtModel.setBounds(251, 207, 213, 19);
		txtModel.addKeyListener( new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtModel.getText().length() > 12) {
					txtModel.setText(txtModel.getText().substring(0, 12));
				}
			}
		});
		txtModel.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (!txtChassi.getText().equals("") && !txtModel.getText().equals("")) {
					btnInclude.setEnabled(true);
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(txtModel);

		btnInclude = new JButton("Incluir");
		btnInclude.setEnabled(false);
		btnInclude.setBounds(447, 461, 117, 25);
		add(btnInclude);
	}
}
