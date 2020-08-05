package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class VerdaderoFalso {

    private String enunciado;
    private final RespuestaVerdaderoFalso respuestaCorrecta;
    private TipoPuntaje tipoPuntaje;


    public VerdaderoFalso(String enunciado, boolean correcto){
        this.tipoPuntaje = new TipoPuntajeClasico();
        this.enunciado = enunciado;
        this.respuestaCorrecta = new RespuestaVerdaderoFalso(correcto);
    }

    public static VerdaderoFalso VerdaderoFalsoPenalidad(String unEnunciado, boolean unValorCorrecto) {
        VerdaderoFalso miPreguntaVF = new VerdaderoFalso(unEnunciado, unValorCorrecto);
        miPreguntaVF.tipoPuntaje = new TipoPuntajePenalidad();
        return miPreguntaVF;
    }

    private ArrayList<Integer> evaluar(RespuestaVerdaderoFalso respuestaDelUsuario){
        return respuestaDelUsuario.evaluar(this.respuestaCorrecta);
    }

    public int responder(boolean respuestaRecibida) {
        RespuestaVerdaderoFalso respuestaDelUsuario = new RespuestaVerdaderoFalso(respuestaRecibida);
        return this.tipoPuntaje.puntuar(this.evaluar(respuestaDelUsuario));
    }

}
