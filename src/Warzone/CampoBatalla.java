package Warzone;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class CampoBatalla {

    private static final int NUM_ACCESO_SIMULTANEOS = 10;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);

    static AtomicInteger cont = new AtomicInteger(0);

    public static void partida(Jugador jugador) {

        //System.out.println("Ha entrado a la partida "+jugador.getName());

        try {
            semaphore.acquire();
            Thread.sleep((new Random().nextInt(5)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(!Jugador.bonus.get()) {
            Jugador.getBonus(jugador);
        }
        puntuarOeliminado(jugador);
    }

    public static synchronized void puntuarOeliminado(Jugador jugador){
        cont.getAndIncrement();
        if(cont.get()<5){
            Jugador.puntuacion = jugador.puntuar();
            System.out.println("El "+jugador.getName()+" ha conseguido "+Jugador.puntuacion+" puntos");
        }else if (cont.get()>=5 && cont.get()<10){
            System.out.println("El "+jugador.getName()+" ha sido eliminado");
            semaphore.release(1);
        }else if (cont.get()>=10){
            Jugador.puntuacion = jugador.puntuar();
            System.out.println("El "+jugador.getName()+" ha conseguido "+Jugador.puntuacion+" puntos");
        }
    }
}


