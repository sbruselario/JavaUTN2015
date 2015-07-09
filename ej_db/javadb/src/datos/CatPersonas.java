package datos;

import java.util.ArrayList;
import entidades.Persona;


public class CatPersonas {

	//ArrayList donde voy a guardar las personas
	public static ArrayList<Persona> personas = new ArrayList<Persona>();



	//agrego la persona al ArrayList local
	public void addPersona(String id, String dni, String nombre, String apellido, String email){
		Persona per = new Persona(id, dni, nombre, apellido, email);
		personas.add(per);		
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



}
