package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class TipoPuntajePenalidad implements TipoPuntaje {

    public Integer puntuar(List<Integer> evaluacion){
        return evaluacion.get(0) - evaluacion.get(1);
    }
}
