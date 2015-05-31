package clase;

public class Remis extends Auto {
 private String localidad;

public String getLocalidad() {
	return localidad;
}

public void setLocalidad(String localidad) {
	this.localidad = localidad;
}
 
public String toString(){
		return "Remis "+ this.getMarca() + " - " + this.getLocalidad(); 
}

}
