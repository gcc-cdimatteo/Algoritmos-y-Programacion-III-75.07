package edu.fiuba.algo3.tp2N10;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso {

    public VerdaderoFalsoConPenalidad(String unEnunciado, Respuesta unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta, new TipoPuntajeConPenalidad(unaRespuestaCorrecta));
    }

}
