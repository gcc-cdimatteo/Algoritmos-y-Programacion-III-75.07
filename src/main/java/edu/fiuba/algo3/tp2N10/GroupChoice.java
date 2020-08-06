package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice {

    private final Enunciado enunciado;
    private final RespuestaGroupChoice respuestaCorrecta;

    public GroupChoice(Enunciado enunciado, RespuestaGroupChoice respuestaCorrecta){
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public List<Integer> responder(List<RespuestaGroupChoice> respuestas){
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaGroupChoice respuestaUsuario : respuestas) {
            puntos.add(this.respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }
}
