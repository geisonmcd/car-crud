package button;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import controller.FindPanelController;
import entity.Car;
import service.CarService;

@SuppressWarnings("serial")
public class ButtonEditor extends DefaultCellEditor {

	protected JButton button;
	private String label;
	private boolean isPushed;
	private CarService carService;
	private FindPanelController findPanelController;

	public ButtonEditor(JCheckBox checkBox, FindPanelController findPanelController) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		carService = new CarService();
		this.findPanelController = findPanelController;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
			String chassi = label.split(" ")[1];
			Car car = new Car();
			car.setChassi(chassi);
			car.setDeleted(Car.DELETED);
			carService.delete(car);
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
		findPanelController.findRegister(findPanelController.getFindPanel().txtFind.getText());
	}
}
