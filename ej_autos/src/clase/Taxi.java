package clase;

public class Taxi extends Auto {

	private String chapa;

	public String getChapa() {
		return chapa;
	}

	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
	
	public String toString(){
		return "Taxis "+ this.getMarca() + " - " + this.getChapa(); 
}
}
