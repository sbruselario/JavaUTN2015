package entidades;

public abstract class Trebejo {

	private String id;
	private String color;
	private Posicion posicion; 
	private boolean eliminado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public boolean isEliminada() {
		return eliminado;
	}

	public void setEliminada(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public abstract boolean movimientoValido(Posicion destino, Trebejo pieza);

	public void mover(Posicion pos){
		this.posicion = pos;
	}
}
