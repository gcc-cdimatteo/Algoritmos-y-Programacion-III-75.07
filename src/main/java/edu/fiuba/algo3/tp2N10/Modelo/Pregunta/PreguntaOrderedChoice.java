package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;

import java.util.List;

public class PreguntaOrderedChoice extends Pregunta {

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> ordenCorrecto) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        respuestaCorrecta = new RespuestaOrderedChoice(ordenCorrecto);
        tipoPregunta = "Ordered Choice";
        respuestaCorrectaFormateada = parsearRespuesta(ordenCorrecto);
    }

    private String parsearRespuesta(List<Integer> ordenCorrecto) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < opciones.size(); i++) {
            builder.append(String.format("%d - %s\n", i + 1, opciones.get(ordenCorrecto.get(i))));
        }
        return builder.toString();
    }

}
