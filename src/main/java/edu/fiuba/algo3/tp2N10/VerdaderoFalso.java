package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class VerdaderoFalso implements Pregunta {

    private String miEnunciado;
    private TipoPuntaje miTipoPuntaje;

    public VerdaderoFalso(String unEnunciado, TipoPuntaje unTipoPuntaje) {
        this.miEnunciado = unEnunciado;
        this.miTipoPuntaje = unTipoPuntaje;
    }

    @Override
    public int valuar(Respuesta unaRespuesta) {
        return this.miTipoPuntaje.valuar(unaRespuesta);
    }

    @Override
    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (ArrayList<Respuesta> respuesta : respuestas) {
            puntos.add(valuar(respuesta.get(0)));
        }
        return puntos;
    }

}
