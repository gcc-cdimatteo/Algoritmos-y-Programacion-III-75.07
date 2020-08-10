package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ExclusividadDePuntaje extends Puntuador {

    private int valor = 1;

    @Override
    public List<Integer> calcularPuntos(List<Integer> puntos) {
        List<Integer> puntosNuevos = new ArrayList<>();
        int auxiliar = puntos.get(0) - puntos.get(1);
        for (int i = 0; i < 2; i++) {
            if (auxiliar < 1) {
                puntosNuevos.add(0);
            } else {
                puntosNuevos.add(valor);
            }
            auxiliar *= -1;
        }
        return puntosNuevos;
    }

    @Override
    public ExclusividadDePuntaje usarExclusividad(Jugador jugador) {
        jugador.usarExclusividad();
        valor *= 2;
        return this;
    }
}
