package Warzone;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CampoBatalla {

    private static final int NUM_ACCESO_SIMULTANEOS = 10;
    protected static final int NUM_TOTAL_JUGADORES = 15;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);
    public static AtomicBoolean seHaDadoElBonus = new AtomicBoolean(false);

    static AtomicInteger cont = new AtomicInteger(0);

    public static void partida(Jugador jugador) {

        try {
            semaphore.acquire();
            Thread.sleep((new Random().nextInt(5)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(seHaDadoElBonus.compareAndSet(false, true)) {
            jugador.getBonus();
        }

        puntuarOeliminado(jugador);

    }

    public static synchronized void puntuarOeliminado(Jugador jugador){

        cont.getAndIncrement();
        if(cont.get()<5){
            jugador.puntuar();
            System.out.println("El "+jugador.getName()+" ha conseguido "+jugador.puntuacion+" puntos");
        }else if (cont.get()>=5 && cont.get()<10){
            System.out.println("El "+jugador.getName()+" ha sido eliminado");
            semaphore.release(1);
        }else if (cont.get()>=10){
            jugador.puntuar();
            System.out.println("El "+jugador.getName()+" ha conseguido "+jugador.puntuacion+" puntos");
        }

        //System.out.println("CONTROL "+cont.get());

        if (cont.get() == NUM_TOTAL_JUGADORES){
            Main.getCampeon1(Main.listaJugadores);
            Main.getCampeon2(Main.listaJugadores);
        }

    }
}


