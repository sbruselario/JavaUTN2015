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
		boolean retorno = false;

		if(trebejo!=null){
			if(trebejo.getColor() != this.getColor())
				retorno=((this.getPosicion().getNumero() == posicion.getNumero())||(this.getPosicion().getLetra() == posicion.getLetra()));
		}
		else{
			retorno=((this.getPosicion().getNumero() == posicion.getNumero())||
					(this.getPosicion().getLetra() == posicion.getLetra()));
		}
		if(this.equals(trebejo)) retorno = false;
		return retorno;
	}
}
