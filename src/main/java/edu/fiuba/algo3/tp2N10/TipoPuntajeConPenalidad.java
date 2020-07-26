package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class TipoPuntajeConPenalidad implements TipoPuntaje {

    private final ArrayList<Respuesta> respuestasCorrectas;

    public TipoPuntajeConPenalidad(Respuesta unaRespuestaCorrecta) {
        this.respuestasCorrectas = new ArrayList<Respuesta>(Arrays.asList(unaRespuestaCorrecta));
    }

    public TipoPuntajeConPenalidad(ArrayList<Respuesta> respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    @Override
    public int puntuar(Respuesta unaRespuesta) {
        return (this.respuestasCorrectas.contains(unaRespuesta)) ? 1 : -1;
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        return 0;
    }

}
