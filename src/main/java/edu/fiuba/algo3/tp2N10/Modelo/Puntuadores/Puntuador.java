package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;

import java.util.List;

public class Puntuador {

    public void asignarPuntos(List<Integer> puntos, List<Jugador> jugadores) {
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
        return new ExclusividadDePuntaje().usarExclusividad(jugador);
    }
}
