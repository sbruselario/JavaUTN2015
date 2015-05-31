package ej3;

public class Cliente extends Persona {
	private String cuit;
	private String direccion;
	
	public String descrGral(){
		return super.descrGral() + cuit + direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
