package entidades;

public abstract class Dama extends Trebejo {

	private static char nombre = 'd';

	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Dama.nombre = nombre;
	}


	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){

		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			//horizontal
			if(this.getPosicion().getNumero() == posicion.getNumero()){
				return true;

				//vertical
			}else if(this.getPosicion().getLetra() == posicion.getLetra()){
				return true;

				//diagonal
			}else if(this.getPosicion().getLetra() == posicion.getLetra()){
				return true;

			}else{ 
				return false;
			}
		}	
	}

}
