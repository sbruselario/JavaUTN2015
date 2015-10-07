package entidades;

public class Caballo extends Trebejo {

	private static char nombre = 'c';

	public Caballo(String id, char color, Posicion posicion, boolean eliminado) {
		super( id,  color,  posicion,  eliminado);
	}
	
	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Caballo.nombre = nombre;
	}

	public boolean movimientoValido(Posicion posicion, Trebejo trebejo){
		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			if((Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==2) &&
					(Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 1)){
				return true;
			}else if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 2) &&
					(Math.abs(this.getPosicion().getLetra() - posicion.getLetra()) == 1)){
				return true;
			}else{ 
				return false;
			}
		}
	}

}
