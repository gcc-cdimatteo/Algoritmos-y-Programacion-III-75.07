package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice implements Mostrable{

    private final Enunciado enunciado;
    private RespuestaOrderedChoice respuestaCorrecta;

    public OrderedChoice(Enunciado enunciado, RespuestaOrderedChoice respuestaCorrecta) {
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
    
    @Override
    public String getPregunta() {
        return this.enunciado.getPregunta();
    }

    @Override
    public List<String> getOpciones() {
        return this.enunciado.getOpciones();
    }
}
