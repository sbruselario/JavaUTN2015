package ej3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Persona> listado  = new ArrayList<Persona>();
		Scanner s=new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			System.out.println("Es cliente o empleado? (c/e)");
	
			String opcion = new String();
			opcion = s.nextLine();
			
			
			//omito el ingreso de datos por teclado 
			
			if (opcion.equalsIgnoreCase("e")){
				//lo agrego como empleado
				Persona per = new Empleado();
				per.setApellido("Bar");
				per.setNombre("Luis");
				per.setDni("123456");

				((Empleado)per).setLegajo("40444");
				((Empleado)per).setPuesto("Operario");
				
				listado.add((Empleado)per);
					
			}
			
			
			
			if  (opcion.equalsIgnoreCase("c"))
			{
				//lo agrego como cliente
				Persona per = new Cliente();
				per.setApellido("Perez");
				per.setNombre("Juan");
				per.setDni("40123456");

				((Cliente)per).setCuit("a-40123456-1");
				((Cliente)per).setDireccion("Zeballos 1341");
				
				
				listado.add((Cliente)per);
			
			
			}
		
			
		
		}
		
		System.out.println("\nListado:");
		for (int i = 0; i <= 1; i++) {
			System.out.println(listado.get(i).descrGral());
		//	System.out.println("\n");
			
		}
	
	
		
		s.close();
	}

}


/*
string.equals("valor")
string.equalsIgnoreCase("Valor")


*/