package Warzone;

import java.util.ArrayList;

public class Main {

    static ArrayList <Jugador> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < CampoBatalla.NUM_TOTAL_JUGADORES; i++){
            Jugador t = new Jugador();
            listaJugadores.add(t);
            t.setName("Luchador " + i);
            t.start();
        }
    }

    public static void getCampeon1(ArrayList<Jugador> listaJugadores){


        int puntuacionMaxima = 0;

        for (Jugador jugador : listaJugadores
        ) {
            if (jugador.puntuacion > puntuacionMaxima) {
                puntuacionMaxima = jugador.puntuacion;
            }
        }
        for (Jugador jugador : listaJugadores
        ) {
            if(jugador.puntuacion == puntuacionMaxima)
                System.out.println("El "+jugador.getName()+" ha ganado con "+ jugador.getPuntuacion());
        }

    }

    public static void getCampeon2(ArrayList<Jugador> listaJugadores){
        listaJugadores.sort(Jugador::compareTo);
        System.out.println("El ganador es: "+ listaJugadores.get(listaJugadores.size()-1).getName()+" que ha conseguido "+ listaJugadores.get(listaJugadores.size()-1).getPuntuacion());
        /*
        ESTRUCTURA DE CONTROL
        for (Jugador jugador:listaJugadores
             ) {
            System.out.println(jugador.getName());
            System.out.println(jugador.puntuacion);
            System.out.println("--------");
        }
         */
    }
}
