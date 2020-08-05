package edu.fiuba.algo3.tp2N10;

public class TipoPuntajeClasico implements TipoPuntaje {

    private final Respuesta respuestaCorrecta;

    public TipoPuntajeClasico(Respuesta unaRespuestaCorrecta) {
        this.respuestaCorrecta = unaRespuestaCorrecta;
    }

    @Override
    public int valuar(RespuestaVerdaderoFalso unaRespuesta) {
        return unaRespuesta.esCorrecta();
    }

}
