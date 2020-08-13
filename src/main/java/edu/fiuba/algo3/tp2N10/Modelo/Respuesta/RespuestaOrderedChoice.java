package edu.fiuba.algo3.tp2N10.Modelo.Respuesta;

import java.util.List;

public class RespuestaOrderedChoice implements Respuesta {

    private List<Integer> respuesta;

    public RespuestaOrderedChoice(List<Integer> respuesta) {
        this.respuesta = respuesta;
    }

    public boolean equals(RespuestaOrderedChoice otraRespuesta) {
        return otraRespuesta.equals(respuesta);
    }

    private boolean equals(List<Integer> otraRespuesta) {
        return respuesta == otraRespuesta;
    }

    @Override
    public Integer evaluar(Respuesta respuestaUsuario) {
        return this.equals((RespuestaOrderedChoice) respuestaUsuario) ? 1 : 0;
    }
}
