package datos;

import java.util.ArrayList;
import entidades.Persona;


public class CatPersonas {

	//ArrayList donde voy a guardar las personas
	public static ArrayList<Persona> personas = new ArrayList<Persona>();


	public void agregarPersona(int dni,String nombre, String apellido, String email){
		Persona per = new Persona(dni, nombre, apellido, email);
		personas.add(per);
	}

	public void actualizarPersona(int dni,String nombre, String apellido, String email){
		for (Persona persona : personas) {
			if (persona.getDni() == dni){
				persona.setApellido(apellido);
				persona.setEmail(email);
				persona.setNombre(nombre);
				break;
			}
		}
	}

	public boolean quitarPersona(int dni){
		for (Persona persona : personas) {
			if (persona.getDni() == dni){
				personas.remove(persona);
				return true;
			}
		}
		return false;
	}

	public Persona buscarPersona(int dni){
		for(Persona p: personas){
			if (p.getDni() == dni){
				return (Persona)p;
			}
		}
		return null; //null por si no encuentra persona
	}


}
