package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoiceClasico extends MultipleChoice {

    public MultipleChoiceClasico(String unEnunciado, ArrayList<Respuesta> respuestasCorrectas) {
        super(unEnunciado, respuestasCorrectas, new TipoPuntajeClasico(respuestasCorrectas));
    }

}
