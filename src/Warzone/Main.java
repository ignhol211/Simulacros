package Warzone;

import java.util.ArrayList;

public class Main {

    static final int NUMERO_JUGADORES = 10;
    static Integer jugadoresEnCola = 0;
    static ArrayList <Jugador> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 15; i++){
            Jugador t = new Jugador();
            listaJugadores.add(t);
            t.setName("Luchador " + i);
            t.start();
        }

        //getCampeon(listaJugadores);

    }

    public static void getCampeon(ArrayList<Jugador> listaJugadores){

        int puntuacionMaxima = 0;

        for (Jugador jugador : listaJugadores
        ) {
            if (Jugador.getPuntuacion() > puntuacionMaxima) {
                puntuacionMaxima = Jugador.getPuntuacion();
            }
        }
        for (Jugador jugador : listaJugadores
        ) {
            if(Jugador.getPuntuacion() == puntuacionMaxima)
                System.out.println("El "+jugador.getName()+" ha ganado");
        }

    }
}
