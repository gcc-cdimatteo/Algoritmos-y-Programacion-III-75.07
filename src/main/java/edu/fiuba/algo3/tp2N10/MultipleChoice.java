package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoice {

    private TipoPuntaje tipoPuntaje;
    private final String enunciado;
    private final RespuestaMultipleChoice respuestasCorrectas;

    public MultipleChoice(String enunciado, ArrayList<String> respuestasCorrectas) {
        this.tipoPuntaje = TipoPuntajeClasico.TipoPuntajeClasicoConAciertosEsperados(respuestasCorrectas.size());
        this.enunciado = enunciado;
        this.respuestasCorrectas = new RespuestaMultipleChoice(respuestasCorrectas);
    }

    private ArrayList<Integer> evaluar(RespuestaMultipleChoice respuestasDelUsuario){
        return respuestasDelUsuario.evaluar(this.respuestasCorrectas);
    }

    public int responder(ArrayList<String> respuestasRecibidas) {
        RespuestaMultipleChoice respuestasDelUsuario = new RespuestaMultipleChoice(respuestasRecibidas);
        return this.tipoPuntaje.puntuar(this.evaluar(respuestasDelUsuario));
    }

    public void conPenalidad() {
        this.tipoPuntaje = new TipoPuntajePenalidad();
    }

    public void parcial() {
        this.tipoPuntaje = new TipoPuntajeParcial();
    }

}