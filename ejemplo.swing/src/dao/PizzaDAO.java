package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pizza;

public class PizzaDAO extends DAOGeneral {
	
	public PizzaDAO(){
		super();
	}
	
	public void cargarABD(Pizza p) {
		Connection c = empezarConexion();
		try {
			PreparedStatement pstmt =c.prepareStatement("insert into pizzas(tipo_pizza, id_calidad_pizza) values (?,?)");
			pstmt.setString(1, p.getNombre());
			pstmt.setInt(2, p.getCalidadPizza());
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
	
	public ArrayList<Pizza> guardarPizzas(){
		ResultSet rs = pedirTabla("pizzas");
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnas = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
