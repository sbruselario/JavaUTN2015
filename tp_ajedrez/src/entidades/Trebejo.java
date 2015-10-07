package entidades;

public abstract class Trebejo {

	private String id;
	private char color;
	private Posicion posicion; 
	private boolean eliminado;

	public Trebejo(String id, char color, Posicion posicion, boolean eliminado) {
		this.setId(id); 
		this.setColor(color);
		this.setPosicion(posicion);
		this.setEliminado(eliminado);
	}
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public abstract boolean movimientoValido(Posicion destino, Trebejo pieza);

	public void mover(Posicion pos){
		this.posicion = pos;
	}
	
	


	
	
}
