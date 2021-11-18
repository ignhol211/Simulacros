package Warzone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static final int NUMERO_JUGADORES = 10;
    static Integer jugadoresEnCola = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 15; i++){
            Jugador t = new Jugador();
            t.setName("Luchador " + i);
            t.start();
        }

        getCampeon(CampoBatalla.listaJugadores);

    }

    public static void getCampeon(ArrayList<Jugador> listaJugadores){

    }

}