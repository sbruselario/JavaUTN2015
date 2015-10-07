package entidades;

public class Alfil extends Trebejo {

	private static char nombre = 'a';

	public Alfil(String id, char color, Posicion posicion, boolean eliminado) {
		super( id,  color,  posicion,  eliminado);
	}
	
	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Alfil.nombre = nombre;
	}


	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){
		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			//diagonal
			return (Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()));
		}
	}

}