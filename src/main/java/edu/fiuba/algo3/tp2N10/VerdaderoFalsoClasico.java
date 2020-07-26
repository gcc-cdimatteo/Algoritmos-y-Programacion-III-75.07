package edu.fiuba.algo3.tp2N10;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

    public VerdaderoFalsoClasico(String unEnunciado, Respuesta unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta, new TipoPuntajeClasico(unaRespuestaCorrecta));
    }

}
