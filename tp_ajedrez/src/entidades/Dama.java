package entidades;

public abstract class Dama extends Trebejo {

	private static char nombre = 'd';

	public boolean isMovimientoValido (Posicion posicion, Trebejo trebejo){

		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			if(Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra())){
				return true;
			}else if((this.getPosicion().getNumero() == posicion.getNumero())||
					(this.getPosicion().getLetra() == posicion.getLetra())){
				return true;
			}else{ 
				return false;
			}
		}	
	}

	public static char getNombre() {
		return nombre;
	}
}
