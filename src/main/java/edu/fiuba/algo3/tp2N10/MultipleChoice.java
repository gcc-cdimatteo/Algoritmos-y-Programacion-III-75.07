package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String unEnunciado, ArrayList<Respuesta> respuestasCorrectas, TipoPuntaje unTipoPuntaje) {
        super(unEnunciado, respuestasCorrectas, unTipoPuntaje);
    }

    public int puntuar(ArrayList<Respuesta> respuestas) {
        return this.tipoPuntaje.puntuar(respuestas);
    }

    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (ArrayList<Respuesta> respuestasUsuario : respuestas) {
            puntos.add(puntuar(respuestasUsuario));
        }
        return puntos;
    }
}
