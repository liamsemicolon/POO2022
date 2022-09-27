package ejemplo.swing;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JList;

public class Panel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Panel() {
		setLayout(null);

		
		JLabel instructivo = new JLabel("enviar pisa");
		instructivo.setBounds(55, 151, 201, 14);
		add(instructivo);
		
		JTextField usuario = new JTextField();
		usuario.setBounds(55, 47, 86, 20);
		add(usuario);
		usuario.setColumns(10);
		
		JLabel txtUsuario = new JLabel("Usuario:");
		txtUsuario.setBounds(55, 22, 117, 14);
		add(txtUsuario);
		
		JLabel txtContra = new JLabel("Contraseña:");
		txtContra.setBounds(55, 74, 86, 14);
		add(txtContra);
		
		DefaultListModel<String> elementos = new DefaultListModel<String>();
		elementos.addElement("Horrible");
		elementos.addElement("Malisima");
		elementos.addElement("Mala");
		elementos.addElement("No tan mala");
		elementos.addElement("Normal");
		elementos.addElement("No tan buena");
		elementos.addElement("Buena");
		elementos.addElement("Buenisima");
		elementos.addElement("Envio de Dios");
		JList<String> list = new JList<String>(elementos);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setBounds(55, 137, 43, -17);
		add(list);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(83, 172, 89, 23);
		add(btnNewButton);

	}
}
