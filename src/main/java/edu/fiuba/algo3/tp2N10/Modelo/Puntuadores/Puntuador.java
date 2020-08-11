package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;

import java.util.List;

public class Puntuador {

    private final List<Jugador> jugadores;

    public Puntuador(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void asignarPuntos(List<Integer> puntos) {
        puntos = this.calcularPuntos(puntos);
        for (int i = 0; i < puntos.size(); i++) {
            Jugador jugador = jugadores.get(i);
            jugador.puntuar(puntos.get(i));
        }
    }

    public List<Integer> calcularPuntos(List<Integer> puntos) {
        return puntos;
    }

    public ExclusividadDePuntaje usarExclusividad(Jugador jugador) {
        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje(jugadores);
        puntuador.usarExclusividad(jugador);
        return puntuador;
    }
}
