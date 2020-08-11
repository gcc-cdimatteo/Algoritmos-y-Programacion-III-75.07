package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Mostrable;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;

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
            puntos.add(respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }
    
    @Override
    public String getPregunta() {
        return enunciado;
    }

    @Override
    public List<String> getOpciones() {
        return opciones;
    }
}
