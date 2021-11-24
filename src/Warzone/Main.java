package Warzone;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList <Jugador> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 15; i++){
            Jugador t = new Jugador();
            listaJugadores.add(t);
            t.setName("Luchador " + i);
            t.start();
        }
        //getCampeon2(listaJugadores);
    }

    public static void getCampeon1(ArrayList<Jugador> listaJugadores){

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

    public static void getCampeon2(ArrayList<Jugador> listaJugadores){
        listaJugadores.sort(Jugador::compareTo);
        System.out.println("El ganador es: "+ listaJugadores.get(-1).getName()+" que ha conseguido "+listaJugadores.get(-1).getPuntuacion());
    }
}
