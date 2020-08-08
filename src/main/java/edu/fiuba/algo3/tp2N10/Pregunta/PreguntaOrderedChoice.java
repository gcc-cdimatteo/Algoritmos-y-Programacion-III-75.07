package edu.fiuba.algo3.tp2N10.Pregunta;

import edu.fiuba.algo3.tp2N10.AlgoKahoot.Mostrable;
import edu.fiuba.algo3.tp2N10.Respuesta.RespuestaOrderedChoice;

import java.util.ArrayList;
import java.util.List;

public class PreguntaOrderedChoice implements Mostrable {

    private final String enunciado;
    private final List<String> opciones;
    private RespuestaOrderedChoice respuestaCorrecta;

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaOrderedChoice(opcionesCorrectas);
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
        return this.enunciado;
    }

    @Override
    public List<String> getOpciones() {
        return this.opciones;
    }
}
