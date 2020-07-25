package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class Respuesta {

    private Object valor;

    public Respuesta(Object unValor) {
        this.valor = unValor;
    }

    public boolean equals(Respuesta unaRespuesta) {
        return unaRespuesta.valor == this.valor;
    }

    public boolean esCorrecta(ArrayList<Respuesta> respuestasCorrectas) {
        for (Respuesta respuestaCorrecta : respuestasCorrectas) {
            if (this.equals(respuestaCorrecta)) { return true; }
        }
        return false;
    }

    public boolean esCorrecta(Respuesta respuestaCorrecta) {
        if (this.equals(respuestaCorrecta)) { return true; }
        return false;
    }
}
