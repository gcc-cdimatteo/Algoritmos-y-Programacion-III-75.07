package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;

import java.util.ArrayList;
import java.util.List;

public class PuntuadorExclusividad implements Puntuador {

    private int valor = 1;

    public PuntuadorExclusividad(Jugador jugador) {
        usarExclusividad(jugador);
    }

    @Override
    public List<Integer> calcularPuntos(List<Integer> puntos) {
        List<Integer> puntosNuevos = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            if (puntos.get((i + 1) % 2) == 0) puntosNuevos.add(valor * puntos.get(i));
            else puntosNuevos.add(0);
        }
        return puntosNuevos;
    }

    @Override
    public PuntuadorExclusividad usarExclusividad(Jugador jugador) {
        jugador.usarExclusividad();
        valor *= 2;
        return this;
    }
}
