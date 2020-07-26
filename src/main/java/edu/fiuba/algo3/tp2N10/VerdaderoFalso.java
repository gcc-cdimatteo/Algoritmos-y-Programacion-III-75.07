package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String unEnunciado, Respuesta unaRespuestaCorrecta, TipoPuntaje unTipoPuntaje) {
        super(unEnunciado, unaRespuestaCorrecta, unTipoPuntaje);
    }

    public int puntuar(Respuesta unaRespuesta) {
        return this.tipoPuntaje.puntuar(unaRespuesta);
    }

    public ArrayList<Integer> responder(ArrayList<Respuesta> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (Respuesta respuesta : respuestas) {
            puntos.add(puntuar(respuesta));
        }
        return puntos;
    }

}
