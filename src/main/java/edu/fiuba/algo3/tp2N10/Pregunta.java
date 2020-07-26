package edu.fiuba.algo3.tp2N10;

public class Pregunta {

    private final String enunciado;
    protected final Object respuestasCorrectas;
    protected final TipoPuntaje tipoPuntaje;

    public Pregunta(String unEnunciado, Object respuestasCorrectas, TipoPuntaje unTipoPuntaje) {
        this.enunciado = unEnunciado;
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPuntaje = unTipoPuntaje;
    }

}
