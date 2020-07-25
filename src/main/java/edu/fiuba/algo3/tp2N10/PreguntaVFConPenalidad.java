package edu.fiuba.algo3.tp2N10;

public class PreguntaVFConPenalidad extends PreguntaVF{

    public PreguntaVFConPenalidad(String enunciado, Respuesta respuestaCorrecta) {
        super(enunciado, respuestaCorrecta);
    }

    public Integer puntuar(Respuesta unaRespuesta) {
        if (unaRespuesta.esCorrecta(this.respuestaCorrecta)) { return 1; }
        return -1;
    }

}
