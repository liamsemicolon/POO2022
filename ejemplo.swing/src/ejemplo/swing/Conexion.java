package ejemplo.swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	String tipoPizza;
	int calidadPizza;
	
	Conexion(String tP, int cP){
		setTipoPizza(tP);
		setCalidadPizza(cP);
	}
	
	public void cargarABD() {
		String url = "jdbc:mysql://localhost:3306/pizzeria_don_pepe";
		String usr = "root";
		String pass = "admin";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
			Statement stmt =c.createStatement();
			int filasAfectadas = stmt.executeUpdate("insert into pizzas (tipo_pizza, id_calidad_pizza) VALUES ('" + getTipoPizza() + "', " + getCalidadPizza() + ")");
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
	
	public String getTipoPizza() {
		return tipoPizza;
	}

	public void setTipoPizza(String tipoPizza) {
		this.tipoPizza = tipoPizza;
	}

	public int getCalidadPizza() {
		return calidadPizza;
	}

	public void setCalidadPizza(int calidadPizza) {
		this.calidadPizza = calidadPizza;
	}
	
}
