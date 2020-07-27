package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public abstract class VerdaderoFalso implements Pregunta {

    private final ArrayList<Respuesta> opciones;
    private final String enunciado;

    public VerdaderoFalso(String unEnunciado, ArrayList<Respuesta> opciones) {
        this.enunciado = unEnunciado;
        this.opciones = opciones;
    }

    public abstract int valuar(Respuesta respuesta);

    @Override
    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (ArrayList<Respuesta> r : respuestas) {
            for (Respuesta respuesta : r) {
                puntos.add(valuar(respuesta));
            }
        }
        return puntos;
    }
}
