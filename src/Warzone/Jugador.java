package Warzone;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Jugador extends Thread implements Comparable<Jugador>{

    public static int puntuacion;

    public static AtomicBoolean bonus = new AtomicBoolean();

    @Override
    public void run (){
        CampoBatalla.partida(this);
    }

    public static void getBonus(Jugador jugador){

        bonus.compareAndSet(false,true);
        System.out.println("El "+jugador.getName()+" ha conseguido el bonus");

    }

    public int puntuar() {
        Random r = new Random();
        if(bonus.get())
            return r.nextInt(100)*2;
        else
            return r.nextInt(100);
    }

    public static int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public int compareTo(Jugador obj) {
        return puntuacion-obj.getPuntuacion();
    }
}
