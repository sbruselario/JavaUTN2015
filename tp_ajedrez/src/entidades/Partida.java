package entidades;

import datos.DBpartidas;

public class Partida {

	private Trebejo[] piezas= new Trebejo[32];
	private int idPartida;
	private Jugador j1;
	private Jugador j2;
	private char turno;

	public void iniciarPartida(){
		piezas = DBpartidas.getTrebejos();
	}

	public Trebejo[] getPiezas() {
		return piezas;
	}

	public void setPiezas(Trebejo[] piezas) {
		this.piezas = piezas;
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

	public Trebejo buscarPiezaEn(Posicion p) {
		Trebejo piezaenp = null;
		for (Trebejo pieza : piezas) {
			if(pieza.getPosicion().equals(p)){
				piezaenp=pieza;
			}
		}
		return piezaenp;
	}

	public Trebejo buscarPieza(int idPieza) {
		Trebejo piezabuscada = null;
		for (Trebejo pieza : piezas) {
			if(pieza.getId() == idPieza){
				piezabuscada = pieza;
				break;
			}
		}
		return piezabuscada;
	}

	public void updatePieza(Trebejo pi) {
		for (Trebejo pieza : piezas) {
			if(pi.getId()==pieza.getId()){
				pieza = pi;
				break;
			}
		}

	}
	public void acomodarPiezas() {
		for (Trebejo pieza : piezas) {
			pieza.setPosicion(DBpartidas.getPosicion(pieza.getId(), idPartida));
		}

	}
	public void acomodarPiezasPosicionInicial(){
		for (Trebejo pieza : piezas) {
			pieza.setPosicion(DBpartidas.getPosicion(pieza.getId(), 0));
		}
	}







}
