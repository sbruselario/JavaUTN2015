package entidades;

import entidades.Trebejo;
import entidades.Posicion;

public class Alfil extends Trebejo {

	public Alfil(){
		setNombre('a');
	}
	
	public boolean isMovimientoValido (Posicion p, Trebejo trebejop){
		boolean resp=false;
		if(trebejop != null){
			if(trebejop.getColor().equals(this.getColor())==false){
				resp=(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()));
			}
		}
		else{
			resp=(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()));;
		}
		if(this.equals(trebejop)) resp = false;
		return resp;
	}

}