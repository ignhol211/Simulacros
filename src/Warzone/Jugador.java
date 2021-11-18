package Warzone;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Jugador extends Thread{

    public static int puntuacion;
    private Semaphore s = new Semaphore(15,false);
    public static AtomicBoolean bonus = new AtomicBoolean();


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

    public int puntuar(Jugador jugador) {
        Random r = new Random();
        if(bonus.get())
            return r.nextInt()*2;
        else
            return r.nextInt();
    }

    public static int getPuntuacion() {
        return puntuacion;
    }
}
