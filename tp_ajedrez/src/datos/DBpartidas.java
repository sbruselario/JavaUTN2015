package datos;

import entidades.*;
import java.sql.*;

public class DBpartidas {

	//int idpartida  string dnij1  string dnij2 char color1  char color2

	//falta buscarPartidapendiente

	public static Trebejo[] getTrebejos(int idpartida){
		Trebejo[] trebejos= new Trebejo[32];
		ResultSet rs;
		Connection conexion;
		conexion = FactoryConexion.getInstancia().getConexion();
		String sql="select * from trebejos where idpartida = " + idpartida + ";";
		try {
			Statement comando = conexion.createStatement();
			rs = comando.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				Trebejo trebejo = null;
				//1int idpartida - 2char posletra - 3int posnum - 4string idtrebejo - 5char color - 6boolean eliminado
				String tipoPieza = rs.getString(4);
				if(tipoPieza.equals("p")) trebejo = new Peon(rs.getString(4).toString(), rs.getString(5).charAt(0), new Posicion((rs.getString(2).charAt(0)), Integer.parseInt(rs.getString(3).toString())), Boolean.parseBoolean(rs.getString(6)));
				if(tipoPieza.equals("r")) trebejo = new Rey(rs.getString(4).toString(), rs.getString(5).charAt(0), new Posicion((rs.getString(2).charAt(0)), Integer.parseInt(rs.getString(3).toString())), Boolean.parseBoolean(rs.getString(6)));
				if(tipoPieza.equals("d")) trebejo = new Dama(rs.getString(4).toString(), rs.getString(5).charAt(0), new Posicion((rs.getString(2).charAt(0)), Integer.parseInt(rs.getString(3).toString())), Boolean.parseBoolean(rs.getString(6)));
				if(tipoPieza.equals("a")) trebejo = new Alfil(rs.getString(4).toString(), rs.getString(5).charAt(0), new Posicion((rs.getString(2).charAt(0)), Integer.parseInt(rs.getString(3).toString())), Boolean.parseBoolean(rs.getString(6)));
				if(tipoPieza.equals("c")) trebejo = new Caballo(rs.getString(4).toString(), rs.getString(5).charAt(0), new Posicion((rs.getString(2).charAt(0)), Integer.parseInt(rs.getString(3).toString())), Boolean.parseBoolean(rs.getString(6)));
				if(tipoPieza.equals("t")) trebejo = new Torre(rs.getString(4).toString(), rs.getString(5).charAt(0), new Posicion((rs.getString(2).charAt(0)), Integer.parseInt(rs.getString(3).toString())), Boolean.parseBoolean(rs.getString(6)));

				trebejos[i]=trebejo;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();

		return trebejos;
	}



	public static void setTurno(int idPartida, char turno) {
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		String sql="update partidas set turno = ? where idPartida = ? ;";
		try {
			PreparedStatement command = conexion.prepareStatement(sql);
			command.setString(1, Character.toString(turno));
			command.setInt(2, idPartida);
			command.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();		
	}


}
