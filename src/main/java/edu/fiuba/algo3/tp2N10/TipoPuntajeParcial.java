package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajeParcial implements TipoPuntaje {

    public Integer puntuar(ArrayList<Integer> obtained) {
        return obtained.get(1) == 0 ? obtained.get(0) : 0;
    }
}