package entidades;

public class Torre extends Trebejo {

	private static char nombre = 't';

	public Torre(String id, char color, Posicion posicion, boolean eliminado) {
		super( id,  color,  posicion,  eliminado);
	}

	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Torre.nombre = nombre;
	}

	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){
		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			//cuando el número o la letra coinciden 
			return ((this.getPosicion().getNumero() == posicion.getNumero()) ||
					(this.getPosicion().getLetra() == posicion.getLetra()));
		}
	}
}
