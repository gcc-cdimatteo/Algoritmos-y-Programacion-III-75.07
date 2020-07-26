package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class Pregunta {

    private final String enunciado;
    protected final Object respuestaCorrecta;
    protected final TipoPuntaje tipoPuntaje;

    public Pregunta(String unEnunciado, Object respuestaCorrecta, TipoPuntaje unTipoPuntaje) {
        this.enunciado = unEnunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.tipoPuntaje = unTipoPuntaje;
    }

}
