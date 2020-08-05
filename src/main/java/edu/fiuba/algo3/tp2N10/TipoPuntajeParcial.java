package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajeParcial implements TipoPuntaje {
    private final Integer puntosPorAcertar;

    public TipoPuntajeParcial(){
        this.puntosPorAcertar = 1;
    }

    public Integer puntuar(ArrayList<Integer> evaluacion){
        Integer puntos = (evaluacion.get(1)==0) ? evaluacion.get(0) : 0;
        return puntos*this.puntosPorAcertar;
    }
}