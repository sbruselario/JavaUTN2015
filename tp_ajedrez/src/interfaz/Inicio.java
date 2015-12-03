package interfaz;

import java.util.Scanner;

import negocio.Controlador;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//s.nextLine()
				Scanner s = new Scanner(System.in);
				
				System.out.println("Desea registrar un nuevo jugador? (s/n)");
				String opcion = s.nextLine();
				while (opcion.equals("s")) {
					Registrar.nuevo();
					System.out.println("Desea registrar un nuevo jugador? (s/n)");
					s.nextLine();
				}
				
				System.out.println("---INICIANDO NUEVA PARTIDA---");
				
				System.out.println("Ingrese DNI del jugador 1:");
				String dni1 = s.nextLine();
				System.out.println("Ingrese DNI del jugador 2:");
				String dni2 = s.nextLine();
				
				System.out.println("Creando partida nueva...");
				int idPartida = 0;
				Local.cargar(Integer.parseInt(dni1), Integer.parseInt(dni2), idPartida);
				
				while (Controlador.getGanador() == null) {
					Local.Mover();
				}		
	}

}
