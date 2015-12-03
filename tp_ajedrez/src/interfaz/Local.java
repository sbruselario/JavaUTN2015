package interfaz;

import java.util.Scanner;
import entidades.*;
import negocio.*;

public class Local {
	static Scanner s=new Scanner(System.in);
	private static int id;
	private static Controlador controlador = new Controlador();
	private static Jugador j1;
	private static Jugador j2;
	private static String ganador = null;

	public static void cargar(int d1, int d2, int idPartida) {
		id = idPartida;
		j1=controlador.buscarJugador(d1);
		j2=controlador.buscarJugador(d2);
		try {
			if(id==0){
				controlador.nuevaPartida(j1.getDni(), j2.getDni());
				controlador.getPartidaActual().getTrebejos();
				System.out.println("Blancas");
				
			}
			else{
				controlador.buscarPartida(id);
				controlador.getPartidaActual().getTrebejos();
				ActualizarTurno();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		
	
	protected static void ActualizarTurno() {
		if(controlador.getPartidaActual().getTurno()=='b') System.out.println("Blancas");
		if(controlador.getPartidaActual().getTurno()=='n') System.out.println("Negras");
	}
	protected static void Mover(){
		System.out.println("idTrebejo:");
		int idTrebejo = Integer.parseInt(s.nextLine());
		System.out.println("Mover a... (Letra):");
		char letra = s.nextLine().toCharArray()[0];
		System.out.println("Mover a... (Numero):");
		int numero = Integer.parseInt(s.nextLine());
		Posicion p = new Posicion();
		p.setLetra(letra);
		p.setNumero(numero);
		if(controlador.moverTrebejo(idTrebejo, p)){
			controlador.getPartidaActual().getTrebejos();
			ActualizarTurno();
			System.out.println("Movimiento realizado.");
			MostrarGanador();
		}
		else System.out.println("El movimiento no se realizo.");
	}

	protected static void MostrarGanador() {
		ganador = controlador.getGanador();
		if(ganador != null){
			if(ganador.equals("Blancas")){
				System.out.println("Gano: Blancas");
			}
			else if (ganador.equals("Negras")){
				System.out.println("Gano: Negras");
			}
		}
		
	}
	
	

}
