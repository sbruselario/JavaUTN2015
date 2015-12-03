package datos;

import entidades.*;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;
import datos.*;


public class DBpartidas {


	public static Trebejo[] getTrebejos(){
		Trebejo[] trebejos= new Trebejo[32];
		ResultSet rs;
		Connection conexion;
		conexion = FactoryConexion.getInstancia().getConexion();
		String sql="select * from trebejos;";
		try {
			Statement comando = conexion.createStatement();
			rs = comando.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				Trebejo t = null;
				String tipoTrebejo = rs.getString(2);
				if(tipoTrebejo.equals("p")) t = new Peon();
				if(tipoTrebejo.equals("r")) t = new Rey();
				if(tipoTrebejo.equals("d")) t = new Dama();
				if(tipoTrebejo.equals("a")) t = new Alfil();
				if(tipoTrebejo.equals("c")) t = new Caballo();
				if(tipoTrebejo.equals("t")) t = new Torre();

				t.setidTrebejo(rs.getInt(1));
				t.setColor(rs.getString(3));
				trebejos[i]=t;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
		return trebejos;

	}


	public static Partida buscarPartida(int id){
		Connection conexion;
		Partida partida = new Partida();
		conexion = FactoryConexion.getInstancia().getConexion();
		String sql1="select * from partidas where idPartida = ?";
		String sql2="select idTrebejo, estado, letra, numero from trebejos_partidas where idPartida = ?";
		try {
			PreparedStatement comando = conexion.prepareStatement(sql1);
			comando.setInt(1, id);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				int idPartida = rs.getInt(1);
				int dniJugador1 = rs.getInt(2);
				int dniJugador2 = rs.getInt(3);
				char turno = rs.getString(4).toCharArray()[0];

				partida.setIdPartida(idPartida);
				partida.setJ1(DBjugadores.buscarJugador(dniJugador1));
				partida.setJ2(DBjugadores.buscarJugador(dniJugador2));
				partida.setTurno(turno);
				Trebejo[] trebejos = new Trebejo[32];
				trebejos = DBpartidas.getTrebejos();
				partida.setTrebejos(trebejos);
				Connection conexion2 = FactoryConexion.getInstancia().getConexion();
				PreparedStatement comando2 = conexion2.prepareStatement(sql2);
				comando2.setInt(1, id);
				ResultSet rs2= comando2.executeQuery();
				while(rs2.next())
				{
					int idTrebejo = rs2.getInt(1);
					boolean estado = rs2.getInt(2)==1;
					char letra = rs2.getString(3).toCharArray()[0];
					int numero = rs2.getInt(4);
					Trebejo trebejo = partida.buscarTrebejo(idTrebejo);
					Posicion pos = new Posicion();
					pos.setLetra(letra);
					pos.setNumero(numero);
					trebejo.setPosicion(pos);
					trebejo.setEstado(estado);
					partida.updateTrebejo(trebejo);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		FactoryConexion.getInstancia().releaseConexion();
		FactoryConexion.getInstancia().releaseConexion();
		return partida;
	}



	public static void setTurno(int idPartida, char turno) {
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		String sql="update partidas set turno = ? where idPartida = ?";
		try {
			PreparedStatement comando = conexion.prepareStatement(sql);
			comando.setString(1, Character.toString(turno));
			comando.setInt(2, idPartida);
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();		
	}	

	public static Posicion getPosicion(int idTrebejo, int idPartida) {
		Posicion p = new Posicion();
		String sql = "select letra, numero from trebejos_partidas where (idTrebejo = ? and idPartida = ?); ";
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setInt(1, idTrebejo);
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


	public static Partida nuevaPartida(Partida partidaActual) {
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		String sql = "insert into partidas (dniJugador1, dniJugador2) values (?,?);";
		String insert = "insert into trebejos_partidas (idTrebejo, idPartida, letra, numero) values (?,?,?,?);";
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
			for (Trebejo trebejo : partidaActual.getTrebejos()) {
				comando = conexion.prepareStatement(insert);
				comando.setInt(1, trebejo.getidTrebejo());
				comando.setInt(2, partidaActual.getIdPartida());
				comando.setString(3, Character.toString(trebejo.getPosicion().getLetra()));
				comando.setInt(4, trebejo.getPosicion().getNumero());
				comando.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
		return partidaActual;	
	}

	public static void eliminarTrebejo(int idPartida, Trebejo trebejop) {
		String sql="update trebejos_partidas set estado = '0', numero = '9', letra = '9' where ((idPartida = ?) and (idTrebejo = ?))";
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = conexion.prepareStatement(sql);
			comando.setInt(1, idPartida);
			comando.setInt(2, trebejop.getidTrebejo());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();

	}

	public static void moverTrebejo(int idPartida, int idTrebejo, Posicion p) {
		String sql = "update trebejos_partidas set letra = ?, numero = ? where idTrebejo = ? and idPartida = ?";
		Connection conexion = FactoryConexion.getInstancia().getConexion();
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setString(1, Character.toString(p.getLetra()));
			comando.setInt(2, p.getNumero());
			comando.setInt(3, idTrebejo);
			comando.setInt(4, idPartida);
			comando.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoryConexion.getInstancia().releaseConexion();
	}

	public static ArrayList<Partida> buscarPartidas(int dni1, int dni2){
		Connection conexion;
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		String sql = "select idPartida, turno from partidas where (dniJugador1 = ? and dniJugador2 = ? ) or (dniJugador2 = ? and dniJugador1 = ? );";

		try {
			conexion = FactoryConexion.getInstancia().getConexion(); 
			PreparedStatement com = conexion.prepareStatement(sql);
			com.setInt(1, dni1);
			com.setInt(2, dni2);
			com.setInt(3, dni1);
			com.setInt(4, dni2);
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


}
