package paquete;

import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// array para almacenar nombres los jugadores
		String[] nombreJugador;
		nombreJugador = new String[2];

		// Solicitamos los nombres de los jugadores
		System.out.println("Nombre Jugador 1: ");
		nombreJugador[0] = scanner.next();
		System.out.println("Nombre Jugador 2: ");
		nombreJugador[1] = scanner.next();

		boolean jugarDeNuevo = true; // determina si el juego se debe repetir

		// Bucle principal
		while (jugarDeNuevo) {

			int numAleatorio = random.nextInt(2);
			System.out.println("\nEmpieza " + nombreJugador[numAleatorio]);

			// Inicializamos el tablero vacío
			String matriz[][] = { { "·", "·", "·" }, { "·", "·", "·" }, { "·", "·", "·" }, };

			boolean continuar = true; // boolean para continuar el juego
			int turno = numAleatorio; // turno inicial es el jugador aleatorio

			// bucle hasta que alguien gane o sea empate
			while (continuar) {
				// se muestra el estado actual del tablero
				System.out.println("Estos son las posiciones disponibles: \n");
				for (int i = 0; i < matriz.length; i++) { // recorremos las filas del tablero
					for (int j = 0; j < matriz[i].length; j++) { // recorremos las columnas de cada fila
						System.out.print("|" + matriz[i][j] + "|");
					}
					System.out.println(""); // salto de línea
				}

				// determinamos la ficha del jugador (X o O)
				String ficha = (turno % 2 == 0) ? "x" : "o";
				System.out.println("\nEs el turno de " + nombreJugador[turno % 2] + " (" + ficha + ")");

				// escoger fila
				System.out.println("\nQue numero de fila quiere? ");
				int numFila = scanner.nextInt();

				// validación fila seleccionada
				if (numFila < 0 || numFila > 2) {
					System.out.println("Error: Fila no valida.");
					continue; // si la fila es inválida, se pide de nuevo la entrada
				}

				// escoger columna
				System.out.println("Que numero de columna quiere? ");
				int numColumna = scanner.nextInt();

				// validación columna seleccionada
				if (numColumna < 0 || numColumna > 2) {
					System.out.println("Error: Columna no valida.");
					continue; // si la columna es inválida, se pide de nuevo la entrada
				}

				// verificamos si la celda ya está ocupada
				if (matriz[numFila][numColumna].equals("x") || matriz[numFila][numColumna].equals("o")) {
					System.out.println("Esta posicion esta ocupada. Elije otra. Gracias.");
				} else {
					// si está vacía, colocamos la ficha del jugador
					matriz[numFila][numColumna] = ficha;
				}

				// comprobamos si el jugador 1 ha ganado
				if ((matriz[0][0] == "x") && (matriz[0][1] == "x") && (matriz[0][2] == "x")
						|| (matriz[1][0] == "x") && (matriz[1][1] == "x") && (matriz[1][2] == "x")
						|| (matriz[2][0] == "x") && (matriz[2][1] == "x") && (matriz[2][2] == "x")
						|| (matriz[0][0] == "x") && (matriz[1][0] == "x") && (matriz[2][0] == "x")
						|| (matriz[0][1] == "x") && (matriz[1][1] == "x") && (matriz[2][1] == "x")
						|| (matriz[0][2] == "x") && (matriz[1][2] == "x") && (matriz[2][2] == "x")
						|| (matriz[0][0] == "x") && (matriz[1][1] == "x") && (matriz[2][2] == "x")
						|| (matriz[0][2] == "x") && (matriz[1][1] == "x") && (matriz[2][0] == "x")) {
					System.out.println("Gana el jugador " + nombreJugador[0]);
					continuar = false;

					// comprobamos si el jugador 2 ha ganado
					if ((matriz[0][0] == "o") && (matriz[0][1] == "o") && (matriz[0][2] == "o")
							|| (matriz[1][0] == "o") && (matriz[1][1] == "o") && (matriz[1][2] == "o")
							|| (matriz[2][0] == "o") && (matriz[2][1] == "o") && (matriz[2][2] == "o")
							|| (matriz[0][0] == "o") && (matriz[1][0] == "o") && (matriz[2][0] == "o")
							|| (matriz[0][1] == "o") && (matriz[1][1] == "o") && (matriz[2][1] == "o")
							|| (matriz[0][2] == "o") && (matriz[1][2] == "o") && (matriz[2][2] == "o")
							|| (matriz[0][0] == "o") && (matriz[1][1] == "o") && (matriz[2][2] == "o")
							|| (matriz[0][2] == "o") && (matriz[1][1] == "o") && (matriz[2][0] == "o")) {
						System.out.println("Gana el jugador " + nombreJugador[1]);
						continuar = false;
					}

					// verificamos si hay empate (cuando no quedan más espacios vacíos)
					boolean empate = true;
					for (int i = 0; i < matriz.length; i++) {
						for (int j = 0; j < matriz[i].length; j++) {
							if (matriz[i][j].equals("·")) {
								empate = false; // si encontramos una celda vacía ("·"), no es empate
								break;
							}
						}
						if (!empate)
							break; // terminamos la búsqueda de empates
					}

					// si no hay más celdas vacías, es empate
					if (empate) {
						System.out.println("Esto es empate");
						continuar = false; // terminamos el juego
					}

					// cambiamos el turno al siguiente jugador
					turno++;
				}

				// tablero final
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						System.out.print("|" + matriz[i][j] + "|");
					}
					System.out.println("");
				}

				// preguntamos a los jugadores si quieren jugar de nuevo
				String respuesta[] = new String[2];
				System.out.println("\n¿Quieres jugar otra vez " + nombreJugador[0] + "?");
				respuesta[0] = scanner.next();
				System.out.println("\n¿Quieres jugar otra vez " + nombreJugador[1] + "?");
				respuesta[1] = scanner.next();

				// si cualquiera de los jugadores responde "no", terminamos el juego
				if (respuesta[0].equalsIgnoreCase("no") || respuesta[1].equalsIgnoreCase("no")) {
					jugarDeNuevo = false;
					System.out.println("¡Gracias por jugar!");
				}
			}
		}

	}
}
