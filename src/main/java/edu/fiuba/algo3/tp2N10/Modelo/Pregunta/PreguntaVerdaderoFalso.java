package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.*;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.Arrays;

public class PreguntaVerdaderoFalso extends Pregunta {

    private PreguntaVerdaderoFalso(String enunciado) {
        this.enunciado = enunciado;
        this.opciones = Arrays.asList("Verdadero", "Falso");
    }

    public static PreguntaVerdaderoFalso Penalidad(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado);
        miPreguntaVF.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(respuestaCorrecta, new PuntajePenalidad());
        return miPreguntaVF;
    }

    public static PreguntaVerdaderoFalso Clasico(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado);
        miPreguntaVF.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(respuestaCorrecta, PuntajeClasico.ParaVerdaderoFalso());
        return miPreguntaVF;
    }
}
