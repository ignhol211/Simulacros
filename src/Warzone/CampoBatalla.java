package Warzone;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class CampoBatalla {

    private static final int NUM_ACCESO_SIMULTANEOS = 10;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);

    static ArrayList <Jugador> listaJugadores = new ArrayList<>();

    public static void entrar(Jugador jugador) {

        try {
            semaphore.acquire();

            listaJugadores.add(jugador);

            if(listaJugadores.size() == 10)
                partida(listaJugadores);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void partida(ArrayList<Jugador> listaJugadores){

        int cont = 0;

        for (Jugador jugador : listaJugadores) {

            System.out.println("Ha entrado a la partida "+jugador.getName());
            try {
                Thread.sleep((long) (Math.random()*(5-1))*1000);
                } catch (InterruptedException e) {
                e.printStackTrace();}
            if(!Jugador.bonus.get()) {
                Jugador.getBonus(jugador);
            }
            cont++;
            if (cont > 5) {
                System.out.println(jugador.getName() + " ha perdido");
            }
        }
        semaphore.release(5);
    }

}
