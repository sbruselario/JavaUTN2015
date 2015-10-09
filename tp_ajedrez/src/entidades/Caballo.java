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
		boolean retorno = false;
		if(trebejo != null){
			if(trebejo.getColor() != this.getColor()){
				if((Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==2)&&
						(Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1))
					retorno = true;
				else if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==2)&&
						(Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1))
					retorno = true;
				else retorno = false;
			}
		}
		else{
			if((Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==1))
				retorno = true;
			else if((Math.abs(this.getPosicion().getNumero() - posicion.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - posicion.getLetra())==1))
				retorno = true;
			else retorno = false;
		}
		if(this.equals(trebejo)) retorno = false;
		return retorno;
	}

}
