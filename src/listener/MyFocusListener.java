package listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("chegou aqui");
		displayMessage("focuslost", e);
	}
	
	 void displayMessage(String prefix, FocusEvent e) {
	        System.out.println(prefix
	                       + (e.isTemporary() ? " (temporary):" : ":")
	                       +  e.getComponent().getClass().getName()
	                       + "; Opposite component: " 
	                       + (e.getOppositeComponent() != null ?
	                          e.getOppositeComponent().getClass().getName() : "null")
	                       ); 
	    }

}
