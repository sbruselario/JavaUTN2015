package entidades;

public class Dama extends Trebejo {

	private static char nombre = 'd';

	public Dama(String id, char color, Posicion posicion, boolean eliminado) {
		super( id,  color,  posicion,  eliminado);
	}

	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Dama.nombre = nombre;
	}


	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){

		boolean retorno = false;
		
		if(trebejo != null){
			if(trebejo.getColor() != this.getColor()){
				if(Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()))
					retorno = true;
				else if((this.getPosicion().getNumero() == posicion.getNumero())||
					(this.getPosicion().getLetra() == posicion.getLetra()))
					retorno = true;
				else retorno = false;
			}
		}
		else{
			if(Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()))
				retorno = true;
				else if((this.getPosicion().getNumero() == posicion.getNumero())||
					(this.getPosicion().getLetra() == posicion.getLetra()))
					retorno = true;
				else retorno = false;			
		}
		if(this.equals(trebejo)) retorno = false;
		return retorno;		
	}

}
