package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaGroupChoice {

    private final String enunciado;
    private final List<String> opciones;
    private final RespuestaGroupChoice respuestaCorrecta;

    public PreguntaGroupChoice(String enunciado, List<String> opciones, Set<Integer> opcionesGrupoA, Set<Integer> opcionesGrupoB){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaGroupChoice(opcionesGrupoA, opcionesGrupoB);
    }

    public List<Integer> responder(List<RespuestaGroupChoice> respuestas){
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaGroupChoice respuestaUsuario : respuestas) {
            puntos.add(respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }

}
