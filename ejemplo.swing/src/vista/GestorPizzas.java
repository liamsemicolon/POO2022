package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GestorPizzas extends JPanel {

	/**
	 * Create the panel.
	 */
	public GestorPizzas() {
		
		
		
		
		
		
		JButton siguiente = new JButton("Gestor de Pizzas");
		siguiente.setBounds(266, 325, 194, 23);
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
			}
		});
		add(siguiente);
	}

}
