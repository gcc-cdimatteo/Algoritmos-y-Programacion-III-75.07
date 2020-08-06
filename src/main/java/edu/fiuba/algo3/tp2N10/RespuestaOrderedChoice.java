package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class RespuestaOrderedChoice {

    private List<String> respuesta;

    public RespuestaOrderedChoice(List<String> respuestaCorrecta) {
        this.respuesta = respuestaCorrecta;
    }

    public boolean equals(RespuestaOrderedChoice otraRespuesta) {
        return otraRespuesta.equals(this.respuesta);
    }

    private boolean equals(List<String> otraRespuesta) {
        return this.respuesta == otraRespuesta;
    }

    public Integer evaluar(RespuestaOrderedChoice respuestaUsuario) {
        return this.equals(respuestaUsuario) ? 1 : 0;
    }
}
