package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class PreguntaVF {

    private String pregunta;
    private boolean respuestaCorrecta;

    public PreguntaVF(String pregunta, boolean respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer puntuar(boolean rta) {
        if (rta == respuestaCorrecta) { return 1;}
        return 0;
    }

    public ArrayList<Integer> responder(ArrayList<Boolean> respuestas) {
        ArrayList<Integer> puntos = new ArrayList<Integer>();
        respuestas.forEach(respuesta ->
                puntos.add(puntuar(respuesta))
        );
        return puntos;
    }

}