package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class TipoPuntajeClasico implements TipoPuntaje {

    private int aciertosEsperados;

    public TipoPuntajeClasico(){
        this.aciertosEsperados = 1;
    }

    public static TipoPuntajeClasico TipoPuntajeClasicoParaMC(RespuestaMultipleChoice respuestaCorrecta) {
        TipoPuntajeClasico miTipoPuntaje = new TipoPuntajeClasico();
        miTipoPuntaje.aciertosEsperados = respuestaCorrecta.size();
        return miTipoPuntaje;
    }

    public Integer puntuar(List<Integer> evaluacion) {
        return this.aciertosEsperados == evaluacion.get(0) && evaluacion.get(1) == 0 ? 1 : 0;
    }
}
