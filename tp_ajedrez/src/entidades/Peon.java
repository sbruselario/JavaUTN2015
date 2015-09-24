package entidades;

public abstract class Peon extends Trebejo {

	private static char nombre = 'p';

	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Peon.nombre = nombre;
	}

	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){

		//veo si es del mismo color
		if(trebejo.getColor() == this.getColor()) {
			return false;

			//adelanta una posición si no hay trebejo adelante
		}else if (this.getPosicion().getLetra() == posicion.getLetra() && 
				Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 1 &&
				trebejo == null){
			return true;

			//come trebejo 
		}else if (this.getColor() != trebejo.getColor() &&
				Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 1 &&
				Math.abs(this.getPosicion().getLetra() - posicion.getLetra()) == 1){
			return true;

			//false
		}else{
			return false;
		}
	}
}


