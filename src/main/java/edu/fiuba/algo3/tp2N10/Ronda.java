package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ronda {

    private List<Jugador> jugadores;

    public Ronda(List<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    public void asignarPuntajes(List<Integer> puntajes) {
        for (int i=0; i<puntajes.size(); i++) {
            this.jugadores.get(i).puntuar(puntajes.get(i));
        }
    }

}
