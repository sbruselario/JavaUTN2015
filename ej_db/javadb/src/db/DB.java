package db;

import java.sql.*;
import java.util.ArrayList;

import entidades.Persona;

public class DB {


	//configuración para la conexión
	String dbDriver="com.mysql.jdbc.Driver";
	String host="localhost";
	String port="3306";
	String user="javaapp";
	String pass="javaapp";
	String db="java";


	//para agregar una persona a la db
	public void add(String dni, String nombre, String apellido, String email) throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		PreparedStatement stmt = conn.prepareStatement("insert into personas(dni, nombre, apellido, email) values (?,?,?,?)");
		stmt.setString(1, dni);
		stmt.setString(2, nombre);
		stmt.setString(3, apellido);
		stmt.setString(4, email);
		stmt.execute();
		stmt.close();
		conn.close();


	}

	//para leer todas las personas de la db
	public ArrayList<Persona> getAll() throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+
				host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from personas;");

		ArrayList<Persona> listado = new ArrayList<Persona>();

		while(rs.next()){
			String id= rs.getString("id");
			String dni= rs.getString("dni");
			String nombre=rs.getString("nombre");
			String apellido=rs.getString("apellido");
			String email=rs.getString("email");

			listado.add(new Persona(id,dni,nombre,apellido,email));

		}

		rs.close();
		stmt.close();
		conn.close();

		return listado;
	}



	//para saber el id del último INSERT: SELECT @@identity AS id
	public String getId(String dni) throws SQLException, ClassNotFoundException{
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * from personas where dni = " + dni);
		while(rs.next()){
			int id= rs.getInt("id");
			return String.valueOf(id);
		}
		rs.close();
		stmt.close();
		conn.close();
		return "error";
	}


}
