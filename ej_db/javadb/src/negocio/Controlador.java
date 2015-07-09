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

		//primero ingreso la nueva persona en la db
		basedatos.add(dni, nombre, apellido, email);
		//le pido a la db que me devuelva el id 
		String id = basedatos.getId(dni);
		//lo agrego al arraylist local
		catp.addPersona(id, dni, nombre, apellido, email);
		//retorno el id
		return id;

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



}
