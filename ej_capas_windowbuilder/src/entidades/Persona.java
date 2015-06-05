package entidades;

public class Persona {
	
	    private int dni;
	    private String nombre;
	    private String apellido;
	    private String email;
	    
	    
	    //set y get autogenerados
		public int getDni() {
			return dni;
		}
		public void setDni(int dni) {
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
	    
		
			
		//constructor
		public Persona(int dni, String nombre, String apellido, String email){
			setDni(dni);
			setNombre(nombre);
			setApellido(apellido);
			setEmail(email);
		}
		
		
		
		
}
