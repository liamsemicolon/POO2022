package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOGeneral {
	private String url = "jdbc:mysql://localhost:3306/pizzeria_don_pepe";
	private String usr = "root";
	private String pass = "admin";
	
	public DAOGeneral(){}
	
	protected Connection empezarConexion() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(getUrl(), getUsr(), getPass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet pedirTabla(String nombreTabla) {
		Connection c = empezarConexion();
		String query = String.format("select * from %s", nombreTabla);
		ResultSet rs = null;
		try {
			Statement stmt =c.createStatement();
			rs = stmt.executeQuery(query);
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
		return rs;
	}

	public String getUrl() {
		return url;
	}

	public String getUsr() {
		return usr;
	}

	public String getPass() {
		return pass;
	}
}
