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

		boolean jugarDeNuevo = true;

		while (jugarDeNuevo) {
			int numAleatorio = random.nextInt(2);
			System.out.println("\nEmpieza " + nombreJugador[numAleatorio]);

			String matriz[][] = { { "·", "·", "·" }, { "·", "·", "·" }, { "·", "·", "·" }, };

			boolean continuar = true;
			int turno = numAleatorio; // Empieza el jugador aleatorio

			while (continuar) {
				System.out.println("Estos son las posiciones disponibles: \n");
				for (int i = 0; i < matriz.length; i++) { // primer for recorre las filas
					for (int j = 0; j < matriz[i].length; j++) { // el segundo recorre las columnas
						System.out.print("|" + matriz[i][j] + "|");
					}
					System.out.println("");
				}

				String ficha = (turno % 2 == 0) ? "x" : "o";
				System.out.println("\nEs el turno de " + nombreJugador[turno % 2] + " (" + ficha + ")");

				System.out.println("\nQue numero de fila quiere? ");
				int numFila = scanner.nextInt();
				System.out.println("" + numFila);

				if (numFila < 0 || numFila > 2) {
					System.out.println("Error: Fila no valida.");
					continue;
				}

				System.out.println("Que numero de columna quiere? ");
				int numColumna = scanner.nextInt();
				System.out.println("" + numColumna);

				if (numColumna < 0 || numColumna > 2) {
					System.out.println("Error: Columna no valida.");
					continue;
				}

				if (matriz[numFila][numColumna].equals("x") || matriz[numFila][numColumna].equals("o")) {
					System.out.println("Esta posicion esta ocupada. Elije otra. Gracias.");
				} else {
					matriz[numFila][numColumna] = ficha;
				}

				if ((matriz[0][0] == "x") && (matriz[0][1] == "x") && (matriz[0][2] == "x") ||

						(matriz[1][0] == "x") && (matriz[1][1] == "x") && (matriz[1][2] == "x") ||

						(matriz[2][0] == "x") && (matriz[2][1] == "x") && (matriz[2][2] == "x") ||

						(matriz[0][0] == "x") && (matriz[1][0] == "x") && (matriz[2][0] == "x") ||

						(matriz[0][1] == "x") && (matriz[1][1] == "x") && (matriz[2][1] == "x") ||

						(matriz[0][2] == "x") && (matriz[1][2] == "x") && (matriz[2][2] == "x") ||

						(matriz[0][0] == "x") && (matriz[1][1] == "x") && (matriz[2][2] == "x") ||

						(matriz[0][2] == "x") && (matriz[1][1] == "x") && (matriz[2][0] == "x")) {

					System.out.println("Gana el jugador " + nombreJugador[0]);
					continuar = false;
				}

				if ((matriz[0][0] == "o") && (matriz[0][1] == "o") && (matriz[0][2] == "o") ||

						(matriz[1][0] == "o") && (matriz[1][1] == "o") && (matriz[1][2] == "o") ||

						(matriz[2][0] == "o") && (matriz[2][1] == "o") && (matriz[2][2] == "o") ||

						(matriz[0][0] == "o") && (matriz[1][0] == "o") && (matriz[2][0] == "o") ||

						(matriz[0][1] == "o") && (matriz[1][1] == "o") && (matriz[2][1] == "o") ||

						(matriz[0][2] == "o") && (matriz[1][2] == "o") && (matriz[2][2] == "o") ||

						(matriz[0][0] == "o") && (matriz[1][1] == "o") && (matriz[2][2] == "o") ||

						(matriz[0][2] == "o") && (matriz[1][1] == "o") && (matriz[2][0] == "o")) {

					System.out.println("Gana el jugador " + nombreJugador[1]);
					continuar = false;
				}

				boolean empate = true;

				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						if (matriz[i][j].equals("·")) {
							empate = false; // Si encontramos una celda vacía, no es empate
							break;
						}
					}
					if (!empate)
						break; // Si ya encontramos una celda vacía, terminamos la búsqueda
				}

				if (empate) {
					System.out.println("Esto es empate");
					continuar = false; // Finalizamos el juego en caso de empate
				}

				turno++;

			}

			for (int i = 0; i < matriz.length; i++) { // primer for recorre las filas
				for (int j = 0; j < matriz[i].length; j++) { // el segundo recorre las columnas
					System.out.print("|" + matriz[i][j] + "|");
				}
				System.out.println("");
			}

			// Preguntar si quieren jugar de nuevo
			String respuesta[] = new String[2];
			System.out.println("\n¿Quieres jugar otra vez " + nombreJugador[0] + "?");
			respuesta[0] = scanner.next();
			System.out.println("\n¿Quieres jugar otra vez " + nombreJugador[1] + "?");
			respuesta[1] = scanner.next();

			if (respuesta[0].equalsIgnoreCase("no") || respuesta[1].equalsIgnoreCase("no")) {
				jugarDeNuevo = false;
				System.out.println("¡Gracias por jugar!");
			}

		}
	}

}
/*
 * 
 * Haya un empate debido a que no quedan mas huecos libres en el tablero.
 * 
 */