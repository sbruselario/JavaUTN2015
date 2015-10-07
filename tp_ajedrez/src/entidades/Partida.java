package entidades;

public class Partida {

	private int idPartida;
	private Jugador jugador1;
	private Jugador jugador2;
	private char turno;
	private Trebejo[] trebejos = new Trebejo[32];


	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	public char getTurno() {
		return turno;
	}
	public void setTurno(char turno) {
		this.turno = turno;
	}
	public Trebejo[] getTrebejos() {
		return trebejos;
	}
	public void setTrebejos(Trebejo[] trebejos) {
		this.trebejos = trebejos;
	}




}
