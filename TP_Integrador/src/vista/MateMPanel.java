package vista;


import javax.swing.JScrollPane;

import dao.CategoriaDAO;
import dao.MaterialDAO;
import dao.PropuestaDAO;
import modelo.Material;
import modelo.Propuesta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JCheckBox;



public class MateMPanel extends MatePaneles {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtDesc;
	private JTextField txtMotiv;

	/**
	 * Create the panel.
	 */

	public MateMPanel(Material mSelec) {
		setLayout(null);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new PropCPanel());
				marco.validate();
			}
		});
		btnAtras.setBounds(483, 457, 89, 23);
		add(btnAtras);
	}
}
