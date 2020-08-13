package edu.fiuba.algo3.tp2N10.Modelo.Respuesta;

import java.util.Arrays;
import java.util.List;

public class RespuestaVerdaderoFalso implements Respuesta {

    private final boolean respuesta;

    public RespuestaVerdaderoFalso(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public boolean equals(RespuestaVerdaderoFalso otraRespuesta) {
        return otraRespuesta.equals(respuesta);
    }

    private boolean equals(boolean otraRespuesta) {
        return respuesta == otraRespuesta;
    }

    @Override
    public List<Integer> evaluar(Respuesta respuestaUsuario) {
        RespuestaVerdaderoFalso respuestaUsuarioCasteada = (RespuestaVerdaderoFalso) respuestaUsuario;
        Integer aciertos = this.equals(respuestaUsuarioCasteada) ? 1 : 0;
        Integer errores = 1 - aciertos;
        return Arrays.asList(aciertos, errores);
    }
}
