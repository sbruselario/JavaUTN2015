package negocio;

import java.sql.*;

import datos.*;
import entidades.*;

import java.util.ArrayList;


public class Controlador {


private static Partida partidaActual;
	
	public Jugador buscarJugador(int dni){
		return DBjugadores.buscarJugador(dni);
	}
	
	public ArrayList<Partida> buscarPartidas(int dni1, int dni2){
		return DBpartidas.buscarPartidas(dni1, dni2);
	}
	protected void pasarTurno(){
		if(partidaActual.getTurno()=='b'){
			partidaActual.setTurno('n');
			DBpartidas.setTurno(partidaActual.getIdPartida(), partidaActual.getTurno());
		}
		else if(partidaActual.getTurno()=='n'){
			partidaActual.setTurno('b');
			DBpartidas.setTurno(partidaActual.getIdPartida(), partidaActual.getTurno());
		}
	}

	public boolean moverTrebejo(int idTrebejo, Posicion p) {

		boolean resp = false;
		Trebejo Trebejoenp=partidaActual.buscarTrebejoEn(p);
		Trebejo TrebejoActual = partidaActual.buscarTrebejo(idTrebejo);
		if((p.isDentroTablero())&&(TrebejoActual.isMovimientoValido(p, Trebejoenp))&&(TrebejoActual.getColor().equals(Character.toString(partidaActual.getTurno())))){
			TrebejoActual.setPosicion(p);
			partidaActual.updateTrebejo(TrebejoActual);
			DBpartidas.moverTrebejo(partidaActual.getIdPartida(), TrebejoActual.getidTrebejo(), p);
			pasarTurno();
			resp = true;
		}
		if(Trebejoenp!=null){
			if(Trebejoenp.getPosicion().equals(TrebejoActual.getPosicion())){
				Trebejoenp.setEstado(false);
				Trebejoenp.getPosicion().setLetra('9');
				Trebejoenp.getPosicion().setNumero(9);
				partidaActual.updateTrebejo(Trebejoenp);
				DBpartidas.eliminarTrebejo(partidaActual.getIdPartida(), Trebejoenp);
			}
		}
		return resp;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public void nuevaPartida(int dni1, int dni2) {
		partidaActual = new Partida();
		partidaActual.setJ1(DBjugadores.buscarJugador(dni1));
		partidaActual.setJ2(DBjugadores.buscarJugador(dni2));
		partidaActual.setTrebejos(DBpartidas.getTrebejos());
		partidaActual.acomodarTrebejosPosicionInicial();
		partidaActual = DBpartidas.nuevaPartida(partidaActual);
	}

	public static String getGanador() {
		if(partidaActual.buscarTrebejo(17).isEstado()==false) return "Negras";
		else if(partidaActual.buscarTrebejo(18).isEstado()==false) return "Blancas";
		else return null;
	}

	public void buscarPartida(int idPartida) {
		setPartidaActual(DBpartidas.buscarPartida(idPartida));
	}

	public static void setPartidaActual(Partida partidaActual) {
		Controlador.partidaActual = partidaActual;
	}



}
