package pruebabd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/pizzeria_don_pepe";
		String usr = "root";
		String pass = "admin";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
			Statement stmt =c.createStatement();
			int filasAfectadas = stmt.executeUpdate("insert into pizzas (tipo_pizza, id_calidad_pizza) VALUES ('pisa virtual', 1)");
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
//eze estuvo aqui X,D