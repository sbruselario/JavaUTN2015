package entidades;

public class Persona {

	private String id;
	private String dni;
	private String nombre;
	private String apellido;
	private String email;



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}




	public Persona(String id, String dni, String nombre, String apellido, String email){
		setId(id);
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
	}

	public Persona() {
		// TODO Auto-generated constructor stub
	}


}
