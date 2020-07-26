package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajeConPenalidad implements TipoPuntaje {

    private final Respuesta respuestaCorrecta;

    public TipoPuntajeConPenalidad(Respuesta unaRespuestaCorrecta) {
        this.respuestaCorrecta = unaRespuestaCorrecta;
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        return (respuesta.equals(this.respuestaCorrecta)) ? 1 : -1;
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        return 0;
    }

}
