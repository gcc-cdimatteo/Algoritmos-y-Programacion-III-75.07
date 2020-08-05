package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajeClasico implements TipoPuntaje {
    private final Integer puntosPorAcertar;
    private Integer aciertosEsperados;

    public TipoPuntajeClasico(){
        this.puntosPorAcertar = 1;
        this.aciertosEsperados = 1;
    }

    public void establecerAciertosEsperados(Integer aciertosEsperados){
        this.aciertosEsperados = aciertosEsperados;
    }

    //Las omisiones de respuesta llegan a tipo de puntaje contabilizadas como error
    public Integer puntuar(ArrayList<Integer> evaluacion){
        return (this.aciertosEsperados == evaluacion.get(0) && 0 == evaluacion.get(1)) ? 1 : 0;
    }
}

