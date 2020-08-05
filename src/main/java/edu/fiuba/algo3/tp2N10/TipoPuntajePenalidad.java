package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajePenalidad implements TipoPuntaje {
    private final Integer puntosPorAcertar;
    private final Integer puntosPorErrar;

    public TipoPuntajePenalidad(){
        this.puntosPorAcertar = 1;
        this.puntosPorErrar = -1;
    }

    public Integer puntuar(ArrayList<Integer> evaluacion){
        return (evaluacion.get(0)*this.puntosPorAcertar)+(evaluacion.get(1)*this.puntosPorErrar);
    }
}
