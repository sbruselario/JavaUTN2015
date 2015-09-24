package entidades;

public abstract class Alfil extends Trebejo {

	private static char nombre = 'a';

	public char getNombre() {
		return nombre;
	}

	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){
		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			return (Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()));
		}
	}

}