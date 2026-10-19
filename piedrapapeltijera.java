import java.util.Random;
import java.util.Scanner;

public class piedrapapeltijera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] opciones = {"piedra", "papel", "tijera"};
        int puntosJugador = 0;
        int puntosMaquina = 0;

        System.out.println("¡Piedra, papel o tijera! Serán 3 jugadas.");

        for (int jugada = 1; jugada <= 3; jugada++) {
            String eleccion;
            do {
                System.out.print("Jugada " + jugada + " - Elige piedra, papel o tijera: ");
                eleccion = sc.nextLine().trim().toLowerCase();
                if (!eleccion.equals("piedra") && !eleccion.equals("papel")
                        && !eleccion.equals("tijera")) {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } while (!eleccion.equals("piedra") && !eleccion.equals("papel")
                    && !eleccion.equals("tijera"));

            String eleccionMaquina = opciones[random.nextInt(opciones.length)];
            System.out.println("La máquina eligió: " + eleccionMaquina);

            if (eleccion.equals(eleccionMaquina)) {
                System.out.println("¡Empate!");
            } else if ((eleccion.equals("piedra") && eleccionMaquina.equals("tijera"))
                    || (eleccion.equals("papel") && eleccionMaquina.equals("piedra"))
                    || (eleccion.equals("tijera") && eleccionMaquina.equals("papel"))) {
                System.out.println("¡Ganaste esta jugada!");
                puntosJugador++;
            } else {
                System.out.println("La máquina gana esta jugada.");
                puntosMaquina++;
            }
            System.out.println("Marcador: tú " + puntosJugador + " - " + puntosMaquina + " máquina\n");
        }

        System.out.println("--- Resultado final ---");
        if (puntosJugador > puntosMaquina) {
            System.out.println("¡Ganaste la partida!");
        } else if (puntosJugador < puntosMaquina) {
            System.out.println("La máquina ganó la partida.");
        } else {
            System.out.println("La partida terminó en empate.");
        }

        sc.close();
    }
}
