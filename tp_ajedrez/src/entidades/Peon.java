package entidades;

public class Peon extends Trebejo {

	private static char nombre = 'p';

	public Peon(String id, char color, Posicion posicion, boolean eliminado) {
		super( id,  color,  posicion,  eliminado);
	}

	public static char getNombre() {
		return nombre;
	}

	public static void setNombre(char nombre) {
		Peon.nombre = nombre;
	}

	public boolean movimientoValido (Posicion posicion, Trebejo trebejo){

		boolean retorno = false;

		if(trebejo != null){ 							
			if(trebejo.getColor() != this.getColor()){ 	
				if((this.getColor() == 'b') && (trebejo.getColor() == 'n')){
					if((Math.abs(this.getPosicion().getLetra()-posicion.getLetra())==1)&&(this.getPosicion().getNumero() - posicion.getNumero() == (-1)))
						retorno=true;
				}
				if((this.getColor() == 'n')&&(trebejo.getColor() == 'b')){
					if((Math.abs(this.getPosicion().getLetra()-posicion.getLetra())==1)&&(this.getPosicion().getNumero() - posicion.getNumero() ==(1)))
						retorno = true;
				}
			}
		}
		else{
			if(this.getPosicion().getLetra()==posicion.getLetra()){
				if((this.getColor() == 'b')&&(this.getPosicion().getNumero() - posicion.getNumero() == -1))
					retorno = true;
				if((this.getColor() == 'n')&&(this.getPosicion().getNumero() - posicion.getNumero() == 1))
					retorno = true;
			}
		}
		if(this.equals(trebejo)) retorno = false;
		return retorno;
	}
}


