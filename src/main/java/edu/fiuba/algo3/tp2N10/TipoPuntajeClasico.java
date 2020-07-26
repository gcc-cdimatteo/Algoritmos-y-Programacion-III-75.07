package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class TipoPuntajeClasico implements TipoPuntaje {

    private final ArrayList<Respuesta> respuestasCorrectas;

    public TipoPuntajeClasico(Respuesta unaRespuestaCorrecta) {
        this.respuestasCorrectas = new ArrayList<Respuesta>(Arrays.asList(unaRespuestaCorrecta));
    }

    public TipoPuntajeClasico(ArrayList<Respuesta> respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    @Override
    public int puntuar(Respuesta unaRespuesta) {
        return (this.respuestasCorrectas.contains(unaRespuesta)) ? 1 : 0;
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if (puntuar(respuesta) == 0) { return 0; }
        }
        return 1;
    }

}
