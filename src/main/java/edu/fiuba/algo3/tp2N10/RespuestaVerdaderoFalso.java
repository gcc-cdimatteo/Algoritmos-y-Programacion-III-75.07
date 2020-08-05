package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class RespuestaVerdaderoFalso {

    private final boolean respuesta;

    public RespuestaVerdaderoFalso(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public boolean equals(RespuestaVerdaderoFalso otraRespuesta) {
        return otraRespuesta.equals(this.respuesta);
    }

    private boolean equals(boolean otraRespuesta) {
        return this.respuesta == otraRespuesta;
    }

    public ArrayList<Integer> evaluar(RespuestaVerdaderoFalso respuestaUsuario) {
        Integer aciertos = this.equals(respuestaUsuario) ? 1 : 0;
        Integer errores = 1 - aciertos;
        return new ArrayList<>(Arrays.asList(aciertos, errores));
    }
}
