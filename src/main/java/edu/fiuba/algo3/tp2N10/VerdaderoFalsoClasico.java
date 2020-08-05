package edu.fiuba.algo3.tp2N10;

public class VerdaderoFalsoClasico {

    private VerdaderoFalso miPregunta;

    public VerdaderoFalsoClasico(String unEnunciado, RespuestaVerdaderoFalso unaRespuestaCorrecta) {
        this.miPregunta = new VerdaderoFalso(unEnunciado, unaRespuestaCorrecta.conTipoPuntaje(new TipoPuntajeClasico()));
    }

    public int valuar(RespuestaVerdaderoFalso unaRespuesta) {
        return this.miPregunta.valuar(unaRespuesta);
    }

}
