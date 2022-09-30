package ejemplo.swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Conexion {
	
	public JTable pedirTabla() {
		String url = "jdbc:mysql://localhost:3306/pizzeria_don_pepe";
		String usr = "root";
		String pass = "admin";
		Connection c = null;
		JTable tabla = new JTable();
		 Object [] fila = new Object[2];
		try {
			c = DriverManager.getConnection(url, usr, pass);
			Statement stmt =c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from calidades_pizza");
			DefaultTableModel modelo = new DefaultTableModel();
			tabla = new JTable(modelo);
			tabla.setEnabled(false);
			tabla.setFillsViewportHeight(true);
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
		return tabla;
	}
	
	public void cargarABD(String tP, int cP) {
		String url = "jdbc:mysql://localhost:3306/pizzeria_don_pepe";
		String usr = "root";
		String pass = "admin";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
			Statement stmt =c.createStatement();
			int filasAfectadas = stmt.executeUpdate("insert into pizzas (tipo_pizza, id_calidad_pizza) VALUES ('" + tP + "', " + cP + ")");
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
