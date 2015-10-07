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

}
