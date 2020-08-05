package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class RespuestaVerdaderoFalso {

    private final boolean valor;

    public RespuestaVerdaderoFalso(boolean unValor) {
        this.valor = unValor;
    }

    public ArrayList<Integer> evaluar(RespuestaVerdaderoFalso respuestaCorrecta) {
        boolean esCorrecta = respuestaCorrecta.contiene(this.valor);
        int aciertos = (esCorrecta) ? 1 : 0;
        int errores = (esCorrecta) ? 0 : 1;
        return new ArrayList<>(Arrays.asList(aciertos, errores));
    }

    private boolean contiene(boolean unaRespuesta) {
        return this.valor == unaRespuesta;
    }

}
