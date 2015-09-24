package entidades;

public abstract class Caballo extends Trebejo {

	private static char nombre = 'c';

	public char getNombre() {
		return nombre;
	}

	public boolean isMovimientoValido(Posicion posicion, Trebejo trebejo){
		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			if((Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1)){
				return true;
			}else if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1)){
				return true;
			}else{ 
				return false;
			}
		}
	}

}
