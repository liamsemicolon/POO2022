package ejemplo.swing;
import javax.swing.JFrame;
public class App {
	public static void main(String[] args) {
		JFrame polo = new JFrame();
		polo.setBounds(0,0,800,600);
		polo.setVisible(true);
		polo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		polo.setContentPane(new Panel());
		polo.validate();
		
	}
}
