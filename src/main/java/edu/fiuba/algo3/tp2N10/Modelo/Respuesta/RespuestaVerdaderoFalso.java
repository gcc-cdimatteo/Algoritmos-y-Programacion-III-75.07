package edu.fiuba.algo3.tp2N10.Modelo.Respuesta;

import java.util.Arrays;
import java.util.List;

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

    public List<Integer> evaluar(RespuestaVerdaderoFalso respuestaUsuario) {
        Integer aciertos = this.equals(respuestaUsuario) ? 1 : 0;
        Integer errores = 1 - aciertos;
        return Arrays.asList(aciertos, errores);
    }
}
