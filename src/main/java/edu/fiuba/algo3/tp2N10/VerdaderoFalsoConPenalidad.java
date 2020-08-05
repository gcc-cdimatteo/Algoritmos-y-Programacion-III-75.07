package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso {

    public VerdaderoFalsoConPenalidad(String unEnunciado, ArrayList<Respuesta> unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta, new TipoPuntajeClasico());
    }

    @Override
    public int valuar(Respuesta respuesta) { return respuesta.valorConPenalidad(); }
}
