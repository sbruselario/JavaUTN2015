package datos;

import entidades.Jugador;
import java.sql.*;

public class DBjugadores {


	//para agregar un jugador a la db 
	public String addJugador(Jugador jugador) throws ClassNotFoundException, SQLException{

		ResultSet rs=null;
		PreparedStatement stmt=null;

		try {
			stmt = FactoryConexion.getInstancia().getConexion().prepareStatement(
					"insert into jugadores(dni, nombre, apellido) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, jugador.getDni());
			stmt.setString(2, jugador.getNombre());
			stmt.setString(3, jugador.getApellido());
			stmt.execute();

			rs=stmt.getGeneratedKeys();

			if(rs!=null && rs.next()){
				return (rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConexion();
		}
		return null;
	}


	//para actualizar los datos de un jugador 
	public void updateJugador(Jugador nJugador){
		Jugador jugador = this.buscarDni(nJugador.getDni());
		jugador.setNombre(nJugador.getNombre());
		jugador.setApellido(nJugador.getApellido());
		PreparedStatement stmt=null;

		try {
			stmt = FactoryConexion.getInstancia().getConexion().prepareStatement(
					"update jugadores set nombre = ?, apellido = ? where dni = ? ;");
			stmt.setString(4, jugador.getDni());
			stmt.setString(1, jugador.getNombre());
			stmt.setString(2, jugador.getApellido());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			FactoryConexion.getInstancia().releaseConexion();
		}
	}



	//para buscar un jugador por dni 
	public Jugador buscarDni(String dni){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Jugador jugador=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConexion().prepareStatement(
					"select id, dni, nombre, apellido from jugadores where dni = ?");
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				jugador = new Jugador(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConexion();
		}
		return jugador;
	}



}
