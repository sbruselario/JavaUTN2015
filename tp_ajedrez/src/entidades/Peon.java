package entidades;

import entidades.Trebejo;
import entidades.Posicion;

public class Peon extends Trebejo {

	public Peon(){
		setNombre('p');
	}

	public boolean isMovimientoValido(Posicion p, Trebejo Trebejop){
		boolean resp=false;
		if(Trebejop!=null){ 						
			if(Trebejop.getColor().equals(this.getColor())==false){ 	
				if((this.getColor().equals("b"))&&(Trebejop.getColor().equals("n"))){
					if((Math.abs(this.getPosicion().getLetra()-p.getLetra())==1)&&(this.getPosicion().getNumero() - p.getNumero() == (-1)))
						resp=true;
				}
				if((this.getColor().equals("n"))&&(Trebejop.getColor().equals("b"))){
					if((Math.abs(this.getPosicion().getLetra()-p.getLetra())==1)&&(this.getPosicion().getNumero() - p.getNumero() ==(1)))
						resp = true;
				}
			}
		}
		else{											
			if(this.getPosicion().getLetra()==p.getLetra()){
				if((this.getColor().equals("b"))&&(this.getPosicion().getNumero() - p.getNumero() == -1))
					resp = true;
				if((this.getColor().equals("n"))&&(this.getPosicion().getNumero() - p.getNumero() == 1))
					resp = true;
			}
		}
		if(this.equals(Trebejop)) resp = false;
		return resp;
	}
}


