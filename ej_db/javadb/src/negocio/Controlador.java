package negocio;
import java.sql.SQLException;
import java.util.ArrayList;




import db.DB;
import entidades.Persona;


public class Controlador {

	private DB basedatos = new DB();

	public String agregarPersona(Persona per) throws ClassNotFoundException, SQLException  {
		if (basedatos.buscarDni(per.getDni())==null){
			return basedatos.addPersona(per);
		} else {
			basedatos.updatePersona(per);
		}
		return null;
	}


	public Persona getPersona(String dni){
		return basedatos.buscarDni(dni);
	}


	public void delPersona(String dni) {
		basedatos.borrarPersona(dni);		
	}


}
