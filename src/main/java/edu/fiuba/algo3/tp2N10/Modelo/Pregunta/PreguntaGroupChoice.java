package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaGroupChoice extends Pregunta {

    public PreguntaGroupChoice(String enunciado, List<String> opciones, Set<Integer> opcionesGrupoA, Set<Integer> opcionesGrupoB) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaGroupChoice(opcionesGrupoA, opcionesGrupoB);
    }
}
