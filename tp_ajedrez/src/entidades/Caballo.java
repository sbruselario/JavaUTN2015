package entidades;

import entidades.Trebejo;
import entidades.Posicion;

public class Caballo extends Trebejo {

	public Caballo(){
		setNombre('c');
	}
	
	public boolean isMovimientoValido(Posicion p, Trebejo trebejop){
		boolean resp = false;
		if(trebejop != null){
			if(trebejop.getColor().equals(this.getColor())==false){
				if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - p.getNumero())==1))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
				else resp = false;
			}
		}
		else{
			if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - p.getNumero())==1))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
				else resp = false;
		}
		if(this.equals(trebejop)) resp = false;
		return resp;
	}


}
