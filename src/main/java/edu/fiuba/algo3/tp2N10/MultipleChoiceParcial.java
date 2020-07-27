package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice {

    public MultipleChoiceParcial(String unEnunciado, ArrayList<Respuesta> opciones) {
        super(unEnunciado, opciones);
    }

    @Override
    public int valuar(ArrayList<Respuesta> respuestas) {
        Integer correcta = 1;
        Integer puntos = 0;
        Integer valor;
        for (Respuesta respuesta : respuestas) {
            valor = respuesta.valorClasico();
            correcta *= valor;
            puntos += valor;
        }
        return correcta * puntos;
    }
}
