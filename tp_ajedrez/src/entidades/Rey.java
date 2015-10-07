package entidades;

public class Rey extends Trebejo {

	private static char nombre = 'r';

	public Rey(String id, char color, Posicion posicion, boolean eliminado) {
		super( id,  color,  posicion,  eliminado);
	}
	
	
	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Rey.nombre = nombre;
	}


	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){
		if(trebejo.getColor() == this.getColor()) {
			return false;
		}else{
			//en todas las direcciones, de a una posición
			if (Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 1 &&
					this.getPosicion().getLetra() == posicion.getLetra()){
				return true;
			}else if (this.getPosicion().getNumero() == posicion.getNumero()  &&
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()) == 1){
				return true;
			}else if (Math.abs(this.getPosicion().getNumero() - posicion.getNumero()) == 1 &&
					Math.abs(this.getPosicion().getLetra() - posicion.getLetra()) == 1){
				return true;
			}else{
				return false;
			}
		}
	}

}
