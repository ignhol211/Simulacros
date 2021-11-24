package Warzone;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Jugador extends Thread implements Comparable<Jugador>{

    int puntuacion=0;
    boolean bonus = false;

    @Override
    public void run (){
        CampoBatalla.partida(this);
    }

    public void getBonus(){
        bonus = true;
        System.out.println("El " + getName() + " ha conseguido el bonus");
    }

    public void puntuar() {
        Random r = new Random();
        puntuacion = r.nextInt(100);
        if (bonus)
            puntuacion *= 2;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public int compareTo(Jugador obj) {
        return puntuacion - obj.getPuntuacion();
    }

}
