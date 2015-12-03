package entidades;

import entidades.Trebejo;
import entidades.Posicion;

public class Dama extends Trebejo {

	public Dama(){
		setNombre('d');
	}
	
	public boolean isMovimientoValido (Posicion p, Trebejo trebejop){
		boolean resp = false;	
		if(trebejop != null){
			if(trebejop.getColor().equals(this.getColor())==false){
				if(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()))
					resp = true;
				else if((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else resp = false;
			}
		}
		else{
			if(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()))
					resp = true;
				else if((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else resp = false;			
		}
		if(this.equals(trebejop)) resp = false;
		return resp;		
	}

}
