package ejemplo.swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/pizzeria_don_pepe";
	private String usr = "root";
	private String pass = "admin";
	
	public JTable pedirTabla() {
		Connection c = null;
		JTable tabla = new JTable();
		 Object [] fila = new Object[2];
		try {
			c = DriverManager.getConnection(url, usr, pass);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from calidades_pizza");
			DefaultTableModel modelo = new DefaultTableModel();
			tabla = new JTable(modelo);
			modelo.addColumn("id");
			modelo.addColumn("calidad");
			while (rs.next()) {
			   for (int i=0;i<2;i++)
			      fila[i] = rs.getObject(i+1);
			   modelo.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		tabla.setRowSelectionAllowed(true);
		tabla.setRowSelectionInterval(0, 0);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
		return tabla;
	}
	
	public void cargarABD(String tP, int cP) {
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
			PreparedStatement pstmt =c.prepareStatement("insert into pizzas(tipo_pizza, id_calidad_pizza) values (?,?)");
			pstmt.setString(1, tP);
			pstmt.setInt(2, cP);
			int filasAfectadas = pstmt.executeUpdate();
			if (filasAfectadas == 1) {
				System.out.println("Se pudo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		} 
	}
	
}
