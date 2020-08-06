package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class TipoPuntajePenalidad implements TipoPuntaje {

    public Integer puntuar(List<Integer> obtained){
        return obtained.get(0) - obtained.get(1);
    }
}
