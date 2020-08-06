package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice {

    private final Enunciado enunciado;
    private final RespuestaMultipleChoice respuestaCorrecta;
    private TipoPuntaje tipoPuntaje;

    public MultipleChoice(Enunciado unEnunciado, RespuestaMultipleChoice respuestaCorrecta) {
        this.enunciado = unEnunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.tipoPuntaje = TipoPuntajeClasico.TipoPuntajeClasicoParaMC(respuestaCorrecta);
    }

    public static MultipleChoice MultipleChoiceParcial(Enunciado unEnunciado, RespuestaMultipleChoice respuestaCorrecta) {
        MultipleChoice miPreguntaMC = new MultipleChoice(unEnunciado, respuestaCorrecta);
        miPreguntaMC.tipoPuntaje = new TipoPuntajeParcial();
        return miPreguntaMC;
    }

    public static MultipleChoice MultipleChoicePenalidad(Enunciado unEnunciado, RespuestaMultipleChoice respuestaCorrecta) {
        MultipleChoice miPreguntaMC = new MultipleChoice(unEnunciado, respuestaCorrecta);
        miPreguntaMC.tipoPuntaje = new TipoPuntajePenalidad();
        return miPreguntaMC;
    }

    public List<Integer> responder(List<RespuestaMultipleChoice> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaMultipleChoice respuestaUsuario : respuestas) {
            puntos.add(this.tipoPuntaje.puntuar(this.respuestaCorrecta.evaluar(respuestaUsuario)));
        }
        return puntos;
    }
}
