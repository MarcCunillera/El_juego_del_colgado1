package paquete1;

import java.util.Scanner;

public class El_juego_del_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables y arrays
		Scanner sc = new Scanner(System.in);
        int cantJugadors;

        // Normas del juego
        System.out.println("--------------------------");
        System.out.println("-  El juego del colgado  -");
        System.out.println("--------------------------");
        
        System.out.println("NORMAS DEL JUEGO:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-  El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego. -");
        System.out.println("-  Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda.                                                    -");
        System.out.println("-  El número máximo de intentos por jugador es 6.                                                                                    -");
        System.out.println("-  Si un jugador adivina correctamente una letra, esta se revela en su posición en la palabra secreta.                               -");
        System.out.println("-  Si un jugador se queda sin intentos, pierde la ronda.                                                                             -");
        System.out.println("-  El jugador que adivine toda la palabra primero o quien gane más rondas será el ganador.                                           -");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        
        
        // Preguntamos cuántos jugadores
        System.out.println("¿Cuántos jugadores son? (Máximo 5)");
        cantJugadors = sc.nextInt(); // Aqui se guarda la respuesta del jugador

        // Validamos el número de jugadores
        while (cantJugadors < 2 || cantJugadors > 5) { // Hacemos un while para que no pueda aver menos de dos jugadores y mas de cinco
            System.out.println("Mínimo 2 jugadores, máximo 5 jugadores.");
            System.out.println("¿Cuántos jugadores son?");
            cantJugadors = sc.nextInt();
        }
	}

}
