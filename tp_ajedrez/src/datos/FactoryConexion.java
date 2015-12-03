package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConexion {


	//configuración para la conexión
	String dbDriver="com.mysql.jdbc.Driver";
	String host="192.168.1.3";
	String port="3306";
	String user="javaapp";
	String pass="javaapp";
	String db="java_ajedrez";

	private Connection conn;
	private int cantConexiones;


	private FactoryConexion(){
		try {
			Class.forName(dbDriver);
			conn=null;
			cantConexiones=0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	private static FactoryConexion instancia;
	public static FactoryConexion getInstancia(){
		if (instancia==null){
			instancia = new FactoryConexion();
		}
		return instancia;
	}


	public Connection getConexion(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass);
				cantConexiones++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


	public void releaseConexion(){
		try {
			cantConexiones--;
			if(cantConexiones==0){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}