package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoiceClasico extends MultipleChoice {
    private Integer totalRespuestasCorrectas;
    public MultipleChoiceClasico(String unEnunciado, ArrayList<Respuesta> opciones) {
        super(unEnunciado, opciones);
        this.totalRespuestasCorrectas = 0;
        for (Respuesta opcion : this.opciones) { this.totalRespuestasCorrectas += opcion.valorClasico(); }
    }

    @Override
    public int valuar(ArrayList<Respuesta> respuestas) {
        Integer respuestasCorrectasJugador = 0;
        for (Respuesta respuesta : respuestas) { respuestasCorrectasJugador += respuesta.valorConPenalidad(); }
        return (respuestasCorrectasJugador == this.totalRespuestasCorrectas) ? 1 : 0;
    }
}