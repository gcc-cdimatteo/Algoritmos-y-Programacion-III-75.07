package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class PreguntaMC {

    private String enunciado;
    private ArrayList<Respuesta> respuestasCorrectas;

    public PreguntaMC(String unEnunciado, ArrayList<Respuesta> respuestasCorrectas) {
        this.enunciado = unEnunciado;
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public int puntuar(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if (!respuesta.esCorrecta(respuestasCorrectas)) { return 0; };
        }
        return 1;
    }

}
