package entidades;

public class Posicion {

	private int numero;
	private char letra;

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}

	public  Posicion (char letra, int numero){
		this.setLetra(letra);
		this.setNumero(numero);
	}


	public boolean equals(Posicion posicion){
		return (this.getLetra() == posicion.getLetra()) && (this.getNumero() == posicion.getNumero());
	}

	public boolean dentroTablero(){
		if((this.letra >= 'a')&&(this.letra <= 'h')){
			if((this.numero >= 1)&&(this.numero <= 8)){
				return true;
			}else{ 
				return false;
			}
		}else{ 
			return false;
		}	 
	}


}
