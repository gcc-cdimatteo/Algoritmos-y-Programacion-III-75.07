package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaGroupChoice extends Pregunta {

    public PreguntaGroupChoice(String enunciado, List<String> opciones, Set<Integer> opcionesGrupoA, Set<Integer> opcionesGrupoB) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        respuestaCorrecta = new RespuestaGroupChoice(opcionesGrupoA, opcionesGrupoB);
        tipoPregunta = "Group Choice";
        respuestaCorrectaFormateada = parsearRespuesta(opcionesGrupoA, opcionesGrupoB);
    }

    private String parsearRespuesta(Set<Integer> valoresGrupoA, Set<Integer> valoresGrupoB) {
        return String.format("Grupo A: %s\n", String.join(", ", listaOpciones(valoresGrupoA))) +
                String.format("Grupo B: %s", String.join(", ", listaOpciones(valoresGrupoB)));
    }

    private List<String> listaOpciones(Set<Integer> valoresGrupo) {
        List<String> opcionesGrupo = new ArrayList<>();
        for (Integer n : valoresGrupo) {
            opcionesGrupo.add(opciones.get(n));
        }
        return opcionesGrupo;
    }
}
