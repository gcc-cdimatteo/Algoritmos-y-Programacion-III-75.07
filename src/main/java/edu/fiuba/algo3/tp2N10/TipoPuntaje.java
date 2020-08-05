package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public interface TipoPuntaje {

    //evaluacion es un arreglo con la forma [ Integer aciertos, Integer errores ]
    Integer puntuar(ArrayList<Integer> evaluacion);
}
