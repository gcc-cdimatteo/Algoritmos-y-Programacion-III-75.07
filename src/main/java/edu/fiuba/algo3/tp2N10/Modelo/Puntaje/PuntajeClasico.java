package edu.fiuba.algo3.tp2N10.Modelo.Puntaje;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;

import java.util.List;

public class PuntajeClasico implements Puntaje {

    private int aciertosEsperados;

    private PuntajeClasico() {
    }

    public static PuntajeClasico ParaVerdaderoFalso() {
        PuntajeClasico miTipoPuntaje = new PuntajeClasico();
        miTipoPuntaje.aciertosEsperados = 1;
        return miTipoPuntaje;
    }

    public static PuntajeClasico ParaMultipleChoice(RespuestaMultipleChoice respuestaCorrecta) {
        PuntajeClasico miTipoPuntaje = new PuntajeClasico();
        miTipoPuntaje.aciertosEsperados = respuestaCorrecta.size();
        return miTipoPuntaje;
    }

    public Integer puntuar(List<Integer> evaluacion) {
        return aciertosEsperados == evaluacion.get(0) && evaluacion.get(1) == 0 ? 1 : 0;
    }
}
