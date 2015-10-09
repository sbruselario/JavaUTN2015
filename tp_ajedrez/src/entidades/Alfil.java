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
		boolean retorno = false;
		if(trebejo != null){
			if(trebejo.getColor() != (this.getColor()) ){
				retorno=(Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
						Math.abs(this.getPosicion().getLetra() - posicion.getLetra()));
			}
		}
		else{
			retorno=(Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()));;
		}
		if(this.equals(trebejo)) retorno = false;
		return retorno;
	}

}