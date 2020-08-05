package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleChoice implements Pregunta {

    private TipoPuntaje tipoPuntaje;
    private final String enunciado;
    private final RespuestaMultipleChoice respuestasCorrectas;

    public MultipleChoice(String enunciado, ArrayList<String> respuestasCorrectas) {
        this.tipoPuntaje = TipoPuntajeClasico.TipoPuntajeClasicoConAciertosEsperados(respuestasCorrectas.size());
        this.enunciado = enunciado;
        this.respuestasCorrectas = new RespuestaMultipleChoice(respuestasCorrectas);
    }

    @Override
    public Integer responder(boolean valor) {
        return 0;
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


//    private final String enunciado;
//    protected ArrayList<Respuesta> opciones;
//
//    public MultipleChoice(String unEnunciado, ArrayList<Respuesta> opciones) {
//        this.enunciado = unEnunciado;
//        this.opciones = opciones;
//    }
//
//    public abstract int valuar(ArrayList<Respuesta> respuestas);
//
//    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
//        ArrayList<Integer> puntos = new ArrayList();
//        for (ArrayList<Respuesta> respuestasUsuario : respuestas) {
//            puntos.add(valuar(respuestasUsuario));
//        }
//        return puntos;
//    }

}