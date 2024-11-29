package paquete1;

import java.util.Random;
import java.util.Scanner;

public class El_juego_del_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
        int cantJugadors;
        int rondas;
        int[] vides;
        String[] nomsJugadors;
        
        
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
        
     // Inicializamos arrays
        nomsJugadors = new String[cantJugadors];
        vides = new int[cantJugadors];

        // Pedimos los nombres de los jugadores
        for (int i = 0; i < nomsJugadors.length; i++) { 
            System.out.println("Introduce el nombre del jugador " + (i + 1) + ":"); // Ponemos esto para pedir el nombre de un jugador mas 1
            nomsJugadors[i] = sc.next();
        }

        // Mostramos los nombres de los jugadores
        System.out.println("Los jugadores son:"); 
        for (String jugadorNombre : nomsJugadors) { // Ponemos esto para que despues se printen los nombres por pantalla 
            System.out.println(jugadorNombre);
        }

        // Preguntamos cuántas rondas jugar
        System.out.println("¿Cuántas rondas quieres jugar?");
        rondas = sc.nextInt();

        // Inicializamos las vidas de los jugadores
        for (int i = 0; i < vides.length; i++) {  // Cremos un array para almacenar las vidas
            vides[i] = 6;
        }
	}

}
