package datos;

import entidades.*;

import java.sql.*;
import java.util.ArrayList;

public class DBpartidas {

	//int idpartida  string dnij1  string dnij2 char color1  char color2
	//falta corregir algunas cosas

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


	public static ArrayList<Partida> buscarPartidas(String dni1, String dni2){
		Connection conexion;
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		String sql = "select idPartida, turno from partidas where (dniJ1 = ? and dniJ2 = ? ) or (dniJ2 = ? and dniJ1 = ? );";

		try {
			conexion = FactoryConexion.getInstancia().getConexion(); 
			PreparedStatement com = conexion.prepareStatement(sql);
			com.setString(1, dni1);
			com.setString(2, dni2);
			com.setString(3, dni1);
			com.setString(4, dni2);
			ResultSet rs= com.executeQuery();
			while(rs.next()){
				Partida p = new Partida();
				p.setIdPartida(rs.getInt("idPartida"));
				p.setTurno(rs.getString("turno").toCharArray()[0]);
				partidas.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FactoryConexion.getInstancia().releaseConexion();
		return partidas;
	}



	public static Partida buscarPartida(int id){
		Connection conexion;
		Partida partida = new Partida();
		conexion = FactoryConexion.getInstancia().getConexion();
		String sql1="select * from partidas where idPartida = ?";
		String sql2="select idPieza, estado, letra, numero from piezas_partidas where idPartida = ?";
		try {
			PreparedStatement comando = conexion.prepareStatement(sql1);
			comando.setInt(1, id);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				int idPartida = rs.getInt(1);
				String dniJugador1 = rs.getString(2);
				String dniJugador2 = rs.getString(3);
				char turno = rs.getString(4).toCharArray()[0];

				partida.setIdPartida(idPartida);
				partida.setJ1(DBjugadores.buscarDni(dniJugador1));
				partida.setJ2(DBjugadores.buscarDni(dniJugador2));
				partida.setTurno(turno);
				Trebejo[] piezas = new Trebejo[32];
				piezas = DBpartidas.getPiezas();
				partida.setPiezas(piezas);
				Connection conexion2 = FactoryConexion.getInstancia().getConexion();
				PreparedStatement comando2 = conexion2.prepareStatement(sql2);
				comando2.setInt(1, id);
				ResultSet rs2= comando2.executeQuery();
				while(rs2.next())
				{
					int idPieza = rs2.getInt(1);
					boolean estado = rs2.getInt(2)==1;
					char letra = rs2.getString(3).toCharArray()[0];
					int numero = rs2.getInt(4);
					Trebejo pieza = partida.buscarPieza(idPieza);
					Posicion pos = new Posicion();
					pos.setLetra(letra);
					pos.setNumero(numero);
					pieza.setPosicion(pos);
					pieza.setEliminado(estado);
					partida.updatePieza(pieza);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		FactoryConexion.getInstancia().releaseConexion();

		return partida;
	}






	public static Partida nuevaPartida(Partida partidaActual) {
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		String sql = "insert into partidas (dniJugador1, dniJugador2) values (?,?);";
		String insert = "insert into piezas_partidas (idPieza, idPartida, letra, numero) values (?,?,?,?);";
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setInt(1, partidaActual.getJ1().getDni());
			comando.setInt(2, partidaActual.getJ2().getDni());
			comando.executeUpdate();
			ResultSet rs = comando.getGeneratedKeys();
			rs.next();
			partidaActual.setIdPartida(rs.getInt(1));
			partidaActual.setTurno('b');
			for (Pieza pieza : partidaActual.getPiezas()) {
				comando = conexion.prepareStatement(insert);
				comando.setInt(1, pieza.getIdPieza());
				comando.setInt(2, partidaActual.getIdPartida());
				comando.setString(3, Character.toString(pieza.getPosicion().getLetra()));
				comando.setInt(4, pieza.getPosicion().getNumero());
				comando.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
		return partidaActual;	
	}
	public static Posicion getPosicion(int idPieza, int idPartida) {
		Posicion p = new Posicion();
		String sql = "select letra, numero from piezas_partidas where (idPieza = ? and idPartida = ?); ";
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setInt(1, idPieza);
			comando.setInt(2, idPartida);
			ResultSet rs = comando.executeQuery();
			rs.next();
			p.setLetra(rs.getString("letra").toCharArray()[0]);
			p.setNumero(rs.getInt("numero"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
		return p;
	}







}
