package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.*;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaMultipleChoice extends Pregunta {

    private PreguntaMultipleChoice(String enunciado, List<String> opciones) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.observers = new ArrayList<>();
    }

    public static PreguntaMultipleChoice Parcial(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones);
        miPreguntaMC.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, new PuntajeParcial());
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Penalidad(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones);
        miPreguntaMC.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, new PuntajePenalidad());
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Clasico(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones);
        miPreguntaMC.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, PuntajeClasico.ParaMultipleChoice(opcionesCorrectas));
        return miPreguntaMC;
    }
}
