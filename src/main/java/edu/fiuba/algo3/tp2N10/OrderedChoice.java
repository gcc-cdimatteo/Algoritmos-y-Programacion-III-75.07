package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice {

    private final String enunciado;
    private RespuestaOrderedChoice respuestaCorrecta;

    public OrderedChoice(String enunciado, RespuestaOrderedChoice respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public List<Integer> responder(List<RespuestaOrderedChoice> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaOrderedChoice respuestaUsuario : respuestas) {
            puntos.add(this.respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }
}
