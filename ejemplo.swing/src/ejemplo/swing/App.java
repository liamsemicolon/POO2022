package ejemplo.swing;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class App {
	public static void main(String[] args) {
		JFrame polo = new JFrame("LA MÁQUINA DE HACER PIZZAS");
		ImageIcon icon = new ImageIcon("C:\\Users\\lruiz\\eclipse-workspace\\ejemplo.swing\\src\\ejemplo\\swing\\img\\icon.png");
		polo.setIconImage(icon.getImage());
		polo.setBounds(0,0,620,450);
		polo.setVisible(true);
		polo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		polo.setContentPane(new Panel());
		polo.validate();
	}
}
