package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ej2();
	}
	
	
	public static void ej2(){
		
		ArrayList<Integer> listaNros = new ArrayList<Integer>();
		int nro=0;	
		
		//int[] listaNros = new int[20];
		System.out.println("Ingrese primer numero.");
		Scanner s=new Scanner(System.in);
		
		try{ //c�digo que puede fallar
			 nro =Integer.parseInt( s.nextLine() );
		}
		catch (NumberFormatException nfe){
			System.out.println(nfe.getMessage());
			System.exit(1);
		}
	////	catch (Exception e)
	////	{
			//c�digo del manejo de la excepci�n 'e'
			//pueden haber m�s de un catch
			//primero poner los catch espec�ficos y al final uno gen�rico
	////	}
	////	finally{
			//c�digo que siempre se ejecuta al final
			//para cerrar conexiones, sockets, etc
	////	}
		
		
		
		//int c=0;
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Ingrese nuevo numero.");
			int nuevoNro = Integer.parseInt(s.nextLine());
			if (nuevoNro> nro)
			{
				listaNros.add(nuevoNro);
				//c++;
			}
		}
		
		//listaNros.get
		System.out.println(listaNros.get(listaNros.size() -1)); //el �ltimo elemento de los mayores
		
		System.out.println("\nLista:");
		for (int n : listaNros) {
			System.out.println(n);
		}
		
		s.close();
		
	}

}
