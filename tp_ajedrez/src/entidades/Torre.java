package entidades;

import entidades.Trebejo;
import entidades.Posicion;

public class Torre extends Trebejo {

	public Torre(){
		setNombre('t');
	}

	public boolean isMovimientoValido (Posicion p, Trebejo trebejop){
		boolean resp = false;
		if(trebejop != null){
			if(trebejop.getColor().equals(this.getColor())==false)
				resp=((this.getPosicion().getNumero() == p.getNumero())||(this.getPosicion().getLetra() == p.getLetra()));
		}
		else{
			resp=((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()));
		}
		if(this.equals(trebejop)) resp = false;
		return resp;
	}	
}
