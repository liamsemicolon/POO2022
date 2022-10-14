package ejemplo.swing;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Pesta�as extends JPanel {

	/**
	 * Create the panel.
	 */
	public Pesta�as() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel p1 = new Panel();
		JPanel p2 = new GestorPizzas();
		
		tabbedPane.add("A�adir pizzas", p1);
		tabbedPane.add("Gestionar Pizzas", p2);
		tabbedPane.setBounds(0,0,620,450);
	}

}
