package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

    public VerdaderoFalsoClasico(String unEnunciado, ArrayList<Respuesta> unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta);
    }

    @Override
    public int valuar(Respuesta respuesta) { return respuesta.valorClasico(); }
}
