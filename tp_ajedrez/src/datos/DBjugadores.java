package datos;

import entidades.Jugador;
import datos.FactoryConexion;
import java.sql.*;



public class DBjugadores {

	public static Jugador buscarJugador(int dni){
		Jugador jugador = new Jugador();
		Connection con;
		con = FactoryConexion.getInstancia().getConexion();
		String sql = "select * from jugadores where dni = ?";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, dni);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				jugador.setDni(rs.getInt(1));
				jugador.setNombre(rs.getString(2));
				jugador.setApellido(rs.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
		return jugador;
	}

	public static void registrarJugador(Jugador jugador){
		Connection con;
		con = FactoryConexion.getInstancia().getConexion();
		String sql = "insert into jugadores (dni, nombre, apellido)" +
				"values (" + jugador.getDni() + ", '" + jugador.getNombre() + "', '" + jugador.getApellido() + "');";
		try {
			Statement comando = con.createStatement();
			comando.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
	}




}
