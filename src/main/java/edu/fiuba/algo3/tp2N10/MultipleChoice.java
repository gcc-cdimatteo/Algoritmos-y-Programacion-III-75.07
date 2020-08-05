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

    public static MultipleChoice MultipleChoiceParcial(String unEnunciado, ArrayList<String> respuestasCorrectas) {
        MultipleChoice miPreguntaMC = new MultipleChoice(unEnunciado, respuestasCorrectas);
        miPreguntaMC.tipoPuntaje = new TipoPuntajeParcial();
        return miPreguntaMC;
    }

    public static MultipleChoice MultipleChoicePenalidad(String unEnunciado, ArrayList<String> respuestasCorrectas) {
        MultipleChoice miPreguntaMC = new MultipleChoice(unEnunciado, respuestasCorrectas);
        miPreguntaMC.tipoPuntaje = new TipoPuntajePenalidad();
        return miPreguntaMC;
    }

    private ArrayList<Integer> evaluar(RespuestaMultipleChoice respuestasDelUsuario){
        return respuestasDelUsuario.evaluar(this.respuestasCorrectas);
    }

    public int responder(ArrayList<String> respuestaRecibida) {
        RespuestaMultipleChoice respuestaDelUsuario = new RespuestaMultipleChoice(respuestaRecibida);
        return this.tipoPuntaje.puntuar(this.evaluar(respuestaDelUsuario));
    }

    public ArrayList<Integer> responderLista(ArrayList<ArrayList<String>> respuestasRecibidas) {
        ArrayList<Integer> puntos = new ArrayList<>();
        for (ArrayList<String> respuestaRecibida : respuestasRecibidas) {
            puntos.add(responder(respuestaRecibida));
        }
        return puntos;
    }

}