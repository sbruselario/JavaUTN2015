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
		boolean retorno = false;

		if(trebejo!=null){
			if(trebejo.getColor() != this.getColor()){
				if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1) &&
						(this.getPosicion().getLetra() == posicion.getLetra()))
					retorno = true;
				else if((Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1) &&
						(this.getPosicion().getNumero() == posicion.getNumero()))
					retorno = true;
				else if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1) &&
						(Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1))
					retorno = true;
			}
			else{
				if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1) &&
						(this.getPosicion().getLetra() == posicion.getLetra()))
					retorno = true;
				else if((Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1) &&
						(this.getPosicion().getNumero() == posicion.getNumero()))
					retorno = true;
				else if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1) &&
						(Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1))
					retorno = true;
			}		
		}
		if(this.equals(trebejo)) retorno = false;
		return retorno;
	}

}
