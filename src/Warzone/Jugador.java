package Warzone;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Jugador extends Thread{

    private Semaphore s;

    public static AtomicBoolean bonus = new AtomicBoolean();

    private int puntuacion = 0;

    @Override
    public void run (){
        Main.jugadoresEnCola++;
        CampoBatalla.entrar(this);
        if(Main.jugadoresEnCola == Main.NUMERO_JUGADORES) {
            s.release(Main.NUMERO_JUGADORES);
        }
    }

    public static void getBonus(Jugador jugador){

        bonus.compareAndSet(false,true);
        bonus.set(true);
        System.out.println("El "+jugador.getName()+" ha conseguido el bonus");

    }

}
