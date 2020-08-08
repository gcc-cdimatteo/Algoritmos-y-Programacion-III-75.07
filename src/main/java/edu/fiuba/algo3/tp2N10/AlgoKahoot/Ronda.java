package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import java.util.List;

public class Ronda {

    private List<Jugador> jugadores;

    public Ronda(List<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    public void asignarPuntajes(List<Integer> puntajes) {
        for (int i=0; i<puntajes.size(); i++) {
            Jugador jugador = this.jugadores.get(i);
            jugador.puntuar(puntajes.get(i));
        }
    }
}
