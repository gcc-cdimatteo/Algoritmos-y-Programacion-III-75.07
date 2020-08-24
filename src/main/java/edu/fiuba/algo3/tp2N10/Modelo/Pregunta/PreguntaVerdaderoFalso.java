package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.*;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.Arrays;

public class PreguntaVerdaderoFalso extends Pregunta {

    private PreguntaVerdaderoFalso(String enunciado, boolean respuestaCorrecta) {
        this.enunciado = enunciado;
        opciones = Arrays.asList("Verdadero", "Falso");
        respuestaCorrectaFormateada = respuestaCorrecta ? "Verdadero" : "Falso";
    }

    public static PreguntaVerdaderoFalso Clasico(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado, respuestaCorrecta);
        miPreguntaVF.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(respuestaCorrecta, PuntajeClasico.ParaVerdaderoFalso());
        miPreguntaVF.tipoPregunta = "Verdadero Falso Clasico";
        return miPreguntaVF;
    }

    public static PreguntaVerdaderoFalso Penalidad(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado, respuestaCorrecta);
        miPreguntaVF.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(respuestaCorrecta, new PuntajePenalidad());
        miPreguntaVF.tipoPregunta = "Verdadero Falso Penalidad";
        return miPreguntaVF;
    }
}
