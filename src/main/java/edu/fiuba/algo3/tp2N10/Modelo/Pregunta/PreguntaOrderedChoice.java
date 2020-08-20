package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;

import java.util.List;

public class PreguntaOrderedChoice extends Pregunta {

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> ordenCorrecto) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaOrderedChoice(ordenCorrecto);
        this.asString = "OrderedChoice";
    }
}
