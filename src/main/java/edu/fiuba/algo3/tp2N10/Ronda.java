package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class Ronda {
    private ArrayList<Jugador> jugadores;

    public Ronda(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    public void asignarPuntajes(ArrayList<Integer> puntajes){
        for (int i=0; i<puntajes.size(); i++) {
            this.jugadores.get(i).puntuar(puntajes.get(i));
        }
    }
}
