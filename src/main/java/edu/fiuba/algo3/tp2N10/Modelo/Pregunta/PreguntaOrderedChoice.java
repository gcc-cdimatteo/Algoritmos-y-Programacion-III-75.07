package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;

import java.util.ArrayList;
import java.util.List;

public class PreguntaOrderedChoice extends Pregunta {

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaOrderedChoice(opcionesCorrectas);
        this.observers = new ArrayList<>();
    }
}
