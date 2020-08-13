package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;

import java.util.List;

public interface Puntuador {

    List<Integer> calcularPuntos(List<Integer> puntos);

    ExclusividadDePuntaje usarExclusividad(Jugador jugador);
}
