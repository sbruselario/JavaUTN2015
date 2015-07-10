package datos;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Spring;

import db.DB;
import entidades.Persona;


public class CatPersonas {

	//ArrayList donde voy a guardar las personas
	public static ArrayList<Persona> personas = new ArrayList<Persona>();
	private DB basedatos = new DB();


	//agrego la persona al ArrayList local
	public String addPersona(String id, String dni, String nombre, String apellido, String email) throws ClassNotFoundException, SQLException{
		if (this.buscarPersona(dni)==null){
			Persona per = new Persona(id, dni, nombre, apellido, email);
			personas.add(per);
			return basedatos.add(per);
		} else {
			this.updatePersona(this.buscarPersona(dni), nombre, apellido, email);
		}
		return id;

	}

	public void updatePersona(Persona per, String nombre, String apellido, String email) {
		per.setApellido(apellido);
		per.setNombre(nombre);
		per.setEmail(email);
		basedatos.update(per);
	}


	public void addPersona(Persona per){
		personas.add(per);		
	}


	//busco una persona en el ArrayList local
	public Persona buscarPersona(String dni){
		for(Persona p: personas){
			if (p.getDni().equals(dni)){
				return (Persona)p;
			}
		}
		return null; //null por si no encuentra persona
	}


	public void limpiarListado(){
		personas.clear();
	}

	public void eliminarPersona(String dni) {
		if (this.buscarPersona(dni)!=null){
			basedatos.borrar(this.buscarPersona(dni));
		}

	}



}
