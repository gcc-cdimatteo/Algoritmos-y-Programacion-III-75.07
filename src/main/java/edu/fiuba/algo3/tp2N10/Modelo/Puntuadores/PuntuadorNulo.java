package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;

import java.util.Arrays;
import java.util.List;

public class PuntuadorNulo implements Puntuador {

    public List<Integer> calcularPuntos(List<Integer> puntos) {
        return puntos;
    }

    public PuntuadorExclusividad usarExclusividad(Jugador jugador) {
        return new PuntuadorExclusividad(Arrays.asList(jugador));
    }
}
