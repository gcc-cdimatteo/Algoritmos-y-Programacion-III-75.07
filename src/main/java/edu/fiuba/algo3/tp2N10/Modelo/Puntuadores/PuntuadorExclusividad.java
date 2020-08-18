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
        List<Integer> puntosNuevos = new ArrayList<>();

        Integer puntosUno = puntos.get(0);
        Integer puntosDos = puntos.get(1);

        if(puntosUno > puntosDos) {
            puntosNuevos.add(puntosUno*valor);
            puntosNuevos.add(0);
        }
        else if(puntosUno < puntosDos) {
            puntosNuevos.add(0);
            puntosNuevos.add(puntosDos*valor);
        }
        else {
            puntosNuevos.add(0);
            puntosNuevos.add(0);
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
