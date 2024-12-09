package paquete;

import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		String[] nombreJugador;
		nombreJugador = new String[2];
		
		System.out.println("Nombre Jugador 1: ");
		nombreJugador[0] = scanner.next();
		System.out.println("Nombre Jugador 2: ");
		nombreJugador[1] = scanner.next();
				
		int numAleatorio = random.nextInt(2);
	
		if(numAleatorio == 0) {
			System.out.println("\nEmpieza " + nombreJugador[0]);
		}else if(numAleatorio == 1) {
			System.out.println("\nEmpieza " + nombreJugador[1]);
		}
		
		String matriz[][] = {{"·","·","·"},
							 {"·","·","·"},
							 {"·","·","·"},};
		
		boolean continuar = true;
		int turno = numAleatorio; // Empieza el jugador aleatorio

		while(continuar) {
			System.out.println("Estos son las posiciones disponibles: \n");
			for (int i = 0; i < matriz.length; i++) {	// primer for recorre las filas	
			     for (int j = 0; j < matriz[i].length; j++) { // el segundo recorre las columnas
			          System.out.print( "|"+matriz[i][j]+"|");
			     }
			       System.out.println("");
			}
			
			String ficha = (turno % 2 == 0) ? "x" : "o";
			System.out.println("\nEs el turno de " + nombreJugador[turno % 2] + " (" + ficha + ")");
						
		    System.out.println("\nQue numero de fila quiere? ");
  			int numFila = scanner.nextInt();
  			System.out.println(""+ numFila);
  			
  			if(numFila < 0 || numFila > 2) {
	  			System.out.println("Error: Fila no valida.");
	  			continue;
	  		}
	  			
	  		System.out.println("Que numero de columna quiere? ");
  			int numColumna = scanner.nextInt();			
  			System.out.println(""+ numColumna);
	  		
	  		if(numColumna < 0 || numColumna > 2) {
	  			System.out.println("Error: Columna no valida.");
	  			continue;
	  		}
	  			
	  		if(matriz[numFila][numColumna].equals("x") || matriz[numFila][numColumna].equals("o")) {
	  			System.out.println("Esta posicion esta ocupada. Elije otra. Gracias.");
	  		}else {
	  			matriz[numFila][numColumna] = ficha;
	  		}	  		
  			            
            if((matriz[0][0] == "x") && (matriz[0][1] == "x") && (matriz[0][2] == "x") || 
               (matriz[0][0] == "o") && (matriz[0][1] == "o") && (matriz[0][2] == "o") ) {
            	System.out.println("Ganaste");
            	continuar = false;
            }
            
            if((matriz[1][0] == "x") && (matriz[1][1] == "x") && (matriz[1][2] == "x") || 
               (matriz[1][0] == "o") && (matriz[1][1] == "o") && (matriz[1][2] == "o") ) {
               System.out.println("Ganaste");
               continuar = false;
            }
            
            if((matriz[2][0] == "x") && (matriz[2][1] == "x") && (matriz[2][2] == "x") || 
               (matriz[2][0] == "o") && (matriz[2][1] == "o") && (matriz[2][2] == "o") ) {
               System.out.println("Ganaste");
               continuar = false;
               
            }
            if((matriz[0][0]== "x") && (matriz[1][0]== "x") && (matriz[2][0]== "x") || 
               (matriz[0][0]== "o") && (matriz[1][0]== "o") && (matriz[2][0]== "o")){
               System.out.println("Ganaste");
               continuar = false;
               
            }
            if((matriz[0][1]== "x") && (matriz[1][1]== "x") && (matriz[2][1]== "x") ||
               (matriz[0][1]== "o") && (matriz[1][1]== "o") && (matriz[2][1]== "o")	){
               System.out.println("Ganaste");
               continuar = false;
               
            }
            if((matriz[0][2]== "x") && (matriz[1][2]== "x") && (matriz[2][2]== "x") ||
               (matriz[0][2]== "o") && (matriz[1][2]== "o") && (matriz[2][2]== "o")){
               System.out.println("Ganaste");
               continuar = false;
               
            }
            if((matriz[0][0]== "x") && (matriz[1][1]== "x") && (matriz[2][2]== "x") ||
               (matriz[0][0]== "o") && (matriz[1][1]== "o") && (matriz[2][2]== "o")){
               System.out.println("Ganaste");
               continuar = false;
               
            }
            if((matriz[0][2]== "x") && (matriz[1][1]== "x") && (matriz[2][0]== "x") || 
               (matriz[0][2]== "o") && (matriz[1][1]== "o") && (matriz[2][0]== "o")){
	           System.out.println("Ganaste");
	           continuar = false;
            }
            
            turno++;

		}
	  	 	for (int i = 0; i < matriz.length; i++) {	// primer for recorre las filas	
			     for (int j = 0; j < matriz[i].length; j++) { // el segundo recorre las columnas
			          System.out.print( "|"+matriz[i][j]+"|");
			     }
			       System.out.println("");
	  	 	}
		 
	}

}

/*

Programar el juego "tres en raya" en java donde dos jugadores irán posicionando sus piezas en un tablero con 9 casillas que forman un cuadrado de 3x3. 
Para esto hará falta usar matrices.

Reglas del juego:

El juego preguntará los nombres del jugador 1 y del jugador 2.
Se lanzará una "moneda" (se escoge aleatoriamente) para elegir quien empezara primero, el jugador 1 o el jugador 2.
Los dos jugadores irán poniendo las fichas hasta que:
Uno de los dos jugadores haya conseguido poner 3 fichas en línea, ya sea horizontalmente, verticalmente o diagonalmente.
Haya un empate debido a que no quedan mas huecos libres en el tablero.
Cuando termina el juego se preguntara si quieren echar la revancha o finalizar el juego.

Instrucciones:

Hay que dejar bien claro a que jugador le toca poner ficha.
Cada vez que un jugador ponga una ficha mostraremos que posiciones siguen vacías y cuales están ocupadas
Si el jugador intenta poner ficha donde ya hay una puesta, saldrá un mensaje de error y le pedirá que la ponga en otra parte.
Cuando un jugador gana saldrá el nombre del ganador.
Con que un solo jugador no quiera la revancha valdrá para terminar el juego

*/
