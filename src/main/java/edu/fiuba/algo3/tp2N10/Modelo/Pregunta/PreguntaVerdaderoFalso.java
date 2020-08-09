package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Mostrable;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeClasico;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajePenalidad;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreguntaVerdaderoFalso implements Mostrable {

    private final String enunciado;
    private final List<String> opciones = Arrays.asList("Verdadero", "Falso");
    private final RespuestaVerdaderoFalso respuestaCorrecta;
    private Puntaje puntaje;

    private PreguntaVerdaderoFalso(String enunciado, boolean respuestaCorrecta){
        this.enunciado = enunciado;
        this.respuestaCorrecta = new RespuestaVerdaderoFalso(respuestaCorrecta);
    }

    public static PreguntaVerdaderoFalso Penalidad(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado, respuestaCorrecta);
        miPreguntaVF.puntaje = new PuntajePenalidad();
        return miPreguntaVF;
    }

    public static PreguntaVerdaderoFalso Clasico(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado, respuestaCorrecta);
        miPreguntaVF.puntaje = PuntajeClasico.ParaVerdaderoFalso();
        return miPreguntaVF;
    }

    public List<Integer> responder(List<RespuestaVerdaderoFalso> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaVerdaderoFalso respuestaUsuario : respuestas) {
            puntos.add(this.puntaje.puntuar(this.respuestaCorrecta.evaluar(respuestaUsuario)));
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
