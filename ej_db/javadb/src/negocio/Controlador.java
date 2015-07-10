package negocio;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.CatPersonas;
import db.DB;
import entidades.Persona;



public class Controlador {

	private CatPersonas catp = new CatPersonas();
	private DB basedatos = new DB();


	public String agregarPersona(String dni, String nombre, String apellido, String email) throws ClassNotFoundException, SQLException {
		if (catp.buscarPersona(dni) == null) {
			return catp.addPersona(null, dni, nombre, apellido, email);
		} else {

			catp.updatePersona(catp.buscarPersona(dni), nombre, apellido, email);
		}
		return null;

	}


	public Persona getPersona(String dni){
		return catp.buscarPersona(dni);
	}


	public void getAll() throws ClassNotFoundException, SQLException{
		catp.limpiarListado();
		ArrayList<Persona> listado = basedatos.getAll();
		for (Persona p: listado) {
			catp.addPersona(p);			
		}
	}


	public void delPersona(String dni) {
		catp.eliminarPersona(dni);		
	}



}
