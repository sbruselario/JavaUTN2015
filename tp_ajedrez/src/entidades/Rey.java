package entidades;

import entidades.Trebejo;
import entidades.Posicion;

public class Rey extends Trebejo {

	public Rey(){
		setNombre('r');
	}
	
	public boolean isMovimientoValido(Posicion p,  Trebejo trebejop){
		boolean resp = false;
		if(trebejop != null){
			if(trebejop.getColor().equals(this.getColor())==false){
				if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==1) &&
					(this.getPosicion().getNumero() == p.getNumero()))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
			}
			else{
				if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
						(this.getPosicion().getLetra() == p.getLetra()))
						resp = true;
					else if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==1) &&
						(this.getPosicion().getNumero() == p.getNumero()))
						resp = true;
					else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
						(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
						resp = true;
			}		
		}
		if(this.equals(trebejop)) resp = false;
		return resp;
	}

}
