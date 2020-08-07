package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class PuntajeClasico implements Puntaje {

    private int aciertosEsperados;

    public PuntajeClasico(){
        this.aciertosEsperados = 1;
    }

    public static PuntajeClasico TipoPuntajeClasicoParaMC(RespuestaMultipleChoice respuestaCorrecta) {
        PuntajeClasico miTipoPuntaje = new PuntajeClasico();
        miTipoPuntaje.aciertosEsperados = respuestaCorrecta.size();
        return miTipoPuntaje;
    }

    public Integer puntuar(List<Integer> evaluacion) {
        return this.aciertosEsperados == evaluacion.get(0) && evaluacion.get(1) == 0 ? 1 : 0;
    }
}
