package edu.fiuba.algo3.tp2N10;

public class Respuesta {

    private Object valor;

    public Respuesta(Object unValor) {
        this.valor = unValor;
    }

    public boolean equals(Respuesta unaRespuesta) {
        return this.valor == unaRespuesta.valor;
    }

}
