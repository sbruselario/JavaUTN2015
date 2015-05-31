package clase;

public class Particular extends Auto {

	int puertas;

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	public String toString(){
		return "Particular "+ this.getMarca() + " - " + this.getPuertas(); 
}

	public boolean esParticular(){
		return true;
	}
}
