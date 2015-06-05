package negocio;

import interfaz.Interfaz;
import datos.CatPersonas;
import entidades.Persona;

public class Controlador {
	
	static CatPersonas catp = new CatPersonas();
	
	public void agregarPersona(int dni, String nombre, String apellido, String email){
		CatPersonas.agregarPersona(dni, nombre, apellido, email);
	}
	
	public boolean quitarPersona(int dni){
		return catp.quitarPersona(dni);
	
	}
	
	public Persona buscarPersona(int dni){
		return catp.buscarPersona(dni);
	}

}
