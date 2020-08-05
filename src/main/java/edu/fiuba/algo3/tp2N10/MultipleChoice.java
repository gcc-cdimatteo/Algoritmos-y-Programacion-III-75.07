package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class MultipleChoice {

    private final String enunciado;
    private final RespuestaMultipleChoice respuestaCorrecta;
    private TipoPuntaje tipoPuntaje;

    public MultipleChoice(String unEnunciado, RespuestaMultipleChoice respuestaCorrecta) {
        this.enunciado = unEnunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.tipoPuntaje = TipoPuntajeClasico.TipoPuntajeClasicoParaMC(respuestaCorrecta);

    }

    public static MultipleChoice MultipleChoiceParcial(String unEnunciado, RespuestaMultipleChoice respuestaCorrecta) {
        MultipleChoice miPreguntaMC = new MultipleChoice(unEnunciado, respuestaCorrecta);
        miPreguntaMC.tipoPuntaje = new TipoPuntajeParcial();
        return miPreguntaMC;
    }

    public static MultipleChoice MultipleChoicePenalidad(String unEnunciado, RespuestaMultipleChoice respuestaCorrecta) {
        MultipleChoice miPreguntaMC = new MultipleChoice(unEnunciado, respuestaCorrecta);
        miPreguntaMC.tipoPuntaje = new TipoPuntajePenalidad();
        return miPreguntaMC;
    }

    public ArrayList<Integer> responder(ArrayList<RespuestaMultipleChoice> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (RespuestaMultipleChoice respuestaUsuario : respuestas) {
            puntos.add(this.tipoPuntaje.puntuar(this.respuestaCorrecta.evaluar(respuestaUsuario)));
        }
        return puntos;
    }
}
