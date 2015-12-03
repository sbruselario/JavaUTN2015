package entidades;

import entidades.Jugador;
import entidades.Trebejo;
import entidades.Posicion;
import datos.DBpartidas;

public class Partida {

	private Trebejo[] Trebejos= new Trebejo[32];
	private int idPartida;
	private Jugador j1;
	private Jugador j2;
	private char turno;

	public void iniciarPartida(){
		Trebejos = DBpartidas.getTrebejos();
	}

	public Trebejo[] getTrebejos() {
		return Trebejos;
	}

	public void setTrebejos(Trebejo[] Trebejos) {
		this.Trebejos = Trebejos;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public void acomodarTrebejos() {
		for (Trebejo Trebejo : Trebejos) {
			Trebejo.setPosicion(DBpartidas.getPosicion(Trebejo.getidTrebejo(), idPartida));
		}

	}
	public void acomodarTrebejosPosicionInicial(){
		for (Trebejo Trebejo : Trebejos) {
			Trebejo.setPosicion(DBpartidas.getPosicion(Trebejo.getidTrebejo(), 0));
		}
	}

	public Trebejo buscarTrebejoEn(Posicion p) {
		Trebejo Trebejop = null;
		for (Trebejo Trebejo : Trebejos) {
			if(Trebejo.getPosicion().equals(p)){
				Trebejop = Trebejo;
			}
		}
		return Trebejop;
	}

	public Trebejo buscarTrebejo(int idTrebejo) {
		Trebejo Trebejobuscado = null;
		for (Trebejo Trebejo : Trebejos) {
			if(Trebejo.getidTrebejo()==idTrebejo){
				Trebejobuscado = Trebejo;
				break;
			}
		}
		return Trebejobuscado;
	}

	public void updateTrebejo(Trebejo t) {
		for (Trebejo Trebejo : Trebejos) {
			if(t.getidTrebejo()==Trebejo.getidTrebejo()){
				Trebejo = t;
				break;
			}
		}

	}







}
