package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class PreguntaVF {

    private String pregunta;
    protected Respuesta respuestaCorrecta;

    public PreguntaVF(String pregunta, Respuesta respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer puntuar(Respuesta unaRespuesta) {
        if (unaRespuesta.esCorrecta(this.respuestaCorrecta)) { return 1; }
        return 0;
    }

    public ArrayList<Integer> responder(ArrayList<Respuesta> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        respuestas.forEach(respuesta ->
                puntos.add(puntuar(respuesta))
        );
        return puntos;
    }

}