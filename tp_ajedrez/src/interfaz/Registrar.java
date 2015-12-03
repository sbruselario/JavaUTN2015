package interfaz;

import java.util.Scanner;
import datos.*;
import entidades.*;


public class Registrar {

	public static void nuevo() {
		Scanner s=new Scanner(System.in);

		Jugador j = new Jugador();
		System.out.println("Ingrese DNI jugador:");
		j.setDni(Integer.parseInt(s.nextLine()));
		System.out.println("Ingrese nombre jugador:");
		j.setNombre(s.nextLine());
		System.out.println("Ingrese apellido jugador:");
		j.setApellido(s.nextLine());
		DBjugadores.registrarJugador(j);
	}

}
