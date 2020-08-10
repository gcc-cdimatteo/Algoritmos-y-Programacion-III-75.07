package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;

import java.util.List;

public class Ronda {

    private final List<Jugador> jugadores;
    private Puntuador puntuador = new Puntuador();

    public Ronda(List<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    public void usarExclusividad(Jugador jugador) {
        puntuador = puntuador.usarExclusividad(jugador);
    }

    public void asignarPuntajes(List<Integer> puntajes) {
        puntuador.asignarPuntos(puntajes, jugadores);
    }
}
