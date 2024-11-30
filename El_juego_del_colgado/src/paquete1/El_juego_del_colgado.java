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
        int[] victorias = null;
        String paraulaSecreta;
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
        
     // Jugar las rondas
     		for (int ronda = 1; ronda <= rondas; ronda++) {  // Bucle para jugar cada ronda
     		    System.out.println("\n--- Ronda " + ronda + " ---");  // Se imprime el número de ronda que toque 

     		    // El jugador elige la palabra secreta
     		    System.out.println("Elige la palabra secreta: ");  
     		    paraulaSecreta = sc.next();  // Se almacena la palabra secreta

     		    // Creamos una representación de la palabra secreta con guiones bajos
     		    char[] palabraOculta = new char[paraulaSecreta.length()];  // Creamos un array de caracteres con el mismo tamaño de la palabra secreta
     		    for (int i = 0; i < palabraOculta.length; i++) { 
     		        palabraOculta[i] = '_';  // Ponemos los guiones para sustituir la palabra
     		    }
     		    
     		    // Iniciamos el juego para esta ronda
    		    boolean palabraAdivinada = false;  // Variable para verificar si la palabra ha sido adivinada
    		    int intentosRestantes = 6;  // Inicializamos los intentos restantes (6 intentos por jugador)

    		    // Jugadores hacen sus intentos
    		    while (!palabraAdivinada && intentosRestantes > 0) {  // Mientras no se haya adivinado la palabra y queden intentos
    		        // Mostramos la palabra oculta
    		        System.out.print("Palabra secreta: ");
    		        for (char letra : palabraOculta) {  // Recorremos la palabra oculta
    		            System.out.print(letra + " ");  // Imprimimos cada letra (guion bajo o letra adivinada)
    		        }
    		        System.out.println();
    		        
    		     // Preguntamos a cada jugador por una letra mientras tengas vidas disponibles
	                for (int i = 0; i < nomsJugadors.length; i++) {
	                    if (vides[i] > 0) {  // Si el jugador tiene vidas restantes se printea la la frase de avajo
	                        System.out.println(nomsJugadors[i] + ", te quedan " + vides[i] + " vidas. Adivina una letra: ");
	                        char letraAdivinada = sc.next().charAt(0);  // almacenamos la letra adivinada 

	                        // Verificamos si la letra está en la palabra secreta
	                        boolean letraCorrecta = false; // le ponemos falso por si la letra no es correcta
	                        for (int j = 0; j < paraulaSecreta.length(); j++) {
	                            if (paraulaSecreta.charAt(j) == letraAdivinada && palabraOculta[j] == '_') { // Verifica si donde hay el guion se a adivinado la letra o no
	                                palabraOculta[j] = letraAdivinada;  // Si la letra es la que va en el guion se canvia el guion por la letra 
	                                letraCorrecta = true;  // indica  que la letra es correcta
	                            }
	                        }

	                        // Si la letra no es correcta, restamos una vida
	                        if (!letraCorrecta) {
	                            vides[i]--;  // Restamos una vida al jugador
	                            System.out.println("¡Letra incorrecta! Te quedan " + vides[i] + " vidas."); // Printamos esto por pantalla
	                        }
	                        
	                     // Verificamos si todas las letras de la palabra fueron adivinados
	                        palabraAdivinada = true;  // Inicializamos como si la uvieramos adivinada
	                        for (char letraOculta : palabraOculta) {
	                            if (letraOculta == '_') {  // Mira si hay algún guion bajo y si hay alguno la palabra no está adivinada
	                                palabraAdivinada = false;  // Marcamos como no adivinada
	                                break; // Cerramos el bucle
	                            }
	                        }

	                        // Si alguien adivina la palabra, terminamos la ronda
	                        if (palabraAdivinada) {
	                            victorias[i]++;  // Incrementamos la victoria del jugador que adivinó la palabra
	                            System.out.println(nomsJugadors[i] + " ha adivinado la palabra!");
	                            break;  // Terminamos el bucle de jugadores
	                        }

	                        // Si un jugador se queda sin intentos, le decimos que no adivinó la palabra y terminamos la ronda para ese jugador
	                        if (vides[i] == 0) {
	                            System.out.println(nomsJugadors[i] + " no ha adivinado la palabra y ha agotado sus intentos.");
	                            palabraAdivinada = true;  // Finalizamos la ronda
	                            break;  // Terminamos el bucle de jugadores
	                        }
	                    }
    		    
	                }
    		    }
    		    
    		 // Al final de la ronda, mostramos el estado de la palabra secreta
	            System.out.print("Palabra secreta final: ");
	            for (char letra : palabraOculta) {  // Mostramos la palabra completa
	                System.out.print(letra + " ");
	            }
	            System.out.println();
	        }

	        // Al final del juego, contamos las victoria i guardamos el nombre del jugador
	        int maxVictorias = 0;
	        String ganador = "";
	        for (int i = 0; i < victorias.length; i++) {
	            if (victorias[i] > maxVictorias) {
	                maxVictorias = victorias[i];  // Actualizamos el máximo de victorias que tiene el jugador
	                ganador = nomsJugadors[i];  // Guardamos el nombre del ganador para mostrarlo al print de avajo
	            }
	        }
	        
//	        Hacemos un print por pantalla del ganador y con cuantas victorias
	        System.out.println("\nEl ganador del juego es: " + ganador + " con " + maxVictorias + " victorias.");  // Se imprime el nombre del ganador y su número de victorias

	        sc.close();  // Cerramos el objeto Scanner

	}
}
