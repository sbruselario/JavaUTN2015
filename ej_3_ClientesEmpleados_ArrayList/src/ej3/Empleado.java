package ej3;

public class Empleado extends Persona {
	private String puesto;
	private String legajo;
	
	
	public String descrGral(){
		return super.descrGral() + puesto + legajo;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public String getLegajo() {
		return legajo;
	}


	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
}
