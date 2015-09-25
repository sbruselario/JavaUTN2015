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
}
