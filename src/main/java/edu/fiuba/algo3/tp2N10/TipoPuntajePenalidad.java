package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajePenalidad implements TipoPuntaje {

    public Integer puntuar(ArrayList<Integer> obtained){
        return obtained.get(0) - obtained.get(1);
    }
}
