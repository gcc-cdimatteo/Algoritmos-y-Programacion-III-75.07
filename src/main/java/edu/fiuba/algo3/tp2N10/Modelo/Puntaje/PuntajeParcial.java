package edu.fiuba.algo3.tp2N10.Modelo.Puntaje;

import java.util.List;

public class PuntajeParcial implements Puntaje {

    public Integer puntuar(List<Integer> evaluacion) {
        return evaluacion.get(1) == 0 ? evaluacion.get(0) : 0;
    }
}