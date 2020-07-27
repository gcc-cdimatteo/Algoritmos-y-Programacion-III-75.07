package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoiceConPenalidad extends MultipleChoice {

    public MultipleChoiceConPenalidad(String unEnunciado, ArrayList<Respuesta> opciones) {
        super(unEnunciado, opciones);
    }

    @Override
    public int valuar(ArrayList<Respuesta> respuestas) {
        Integer puntos = 0;
        for (Respuesta respuesta : respuestas) {
            puntos += respuesta.valorConPenalidad();
        }
        return puntos;
    }
}
