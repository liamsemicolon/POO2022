package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.DAOGeneral;
import modelo.Pizza;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

public class Panel extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel marco;

	/**
	 * Create the panel.
	 */
	public Panel() {
		setLayout(null);

		DAOGeneral c = new DAOGeneral();
		
		JLabel instructivo = new JLabel("enviar pizza");
		instructivo.setBounds(84, 310, 79, 14);
		add(instructivo);
		
		JTextField usuario = new JTextField();
		usuario.setBounds(20, 36, 208, 20);
		add(usuario);
		usuario.setColumns(10);
		
		JLabel txtUsuario = new JLabel("Tipo de pizza:");
		txtUsuario.setBounds(20, 11, 226, 14);
		add(txtUsuario);
		
		JLabel txtContra = new JLabel("Calidades posibles:");
		txtContra.setBounds(20, 67, 236, 14);
		add(txtContra);
		
		table = c.pedirTabla("calidades_pizza");
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(20, 92, 236, 173);
		add(scrollPane);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 0));
	        }
	    });
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza p = new Pizza(usuario.getText(), Integer.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
				c.cargarABD(p.getNombre(), p.getCalidadPizza());
			}
		});
		btnNewButton.setBounds(74, 325, 89, 23);
		add(btnNewButton);
		
		JLabel image = new JLabel("mm rica pizza!");
		image.setIcon(new ImageIcon("img\\pisa.png"));
		image.setBounds(256, 67, 456, 257);
		add(image);
		
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
