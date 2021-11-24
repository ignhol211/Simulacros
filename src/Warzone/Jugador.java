package Warzone;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Jugador extends Thread implements Comparable<Jugador>{

    int puntuacion=0;

    public static AtomicBoolean bonus = new AtomicBoolean(false);

    @Override
    public void run (){
        CampoBatalla.partida(this);
    }

    public void getBonus(Jugador jugador){
        if(bonus.compareAndSet(false,true)) {
            jugador.puntuacion = jugador.puntuacion*2;
            System.out.println("El " + jugador.getName() + " ha conseguido el bonus");
        }
    }

    public static int puntuar() {
        Random r = new Random();
        return r.nextInt(100);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public int compareTo(Jugador obj) {
        return puntuacion - obj.getPuntuacion();
    }

}
