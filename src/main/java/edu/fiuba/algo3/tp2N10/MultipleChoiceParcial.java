package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice {

    public MultipleChoiceParcial(String unEnunciado, ArrayList<Respuesta> respuestasCorrectas) {
        super(unEnunciado, respuestasCorrectas, new TipoPuntajeParcial(respuestasCorrectas));
    }

}
