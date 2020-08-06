package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso {

    private final Enunciado enunciado;
    private final RespuestaVerdaderoFalso respuestaCorrecta;
    private TipoPuntaje tipoPuntaje;

    public VerdaderoFalso(Enunciado enunciado, RespuestaVerdaderoFalso respuestaCorrecta){
        this.tipoPuntaje = new TipoPuntajeClasico();
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public static VerdaderoFalso VerdaderoFalsoPenalidad(Enunciado unEnunciado, RespuestaVerdaderoFalso respuestaCorrecta) {
        VerdaderoFalso miPreguntaVF = new VerdaderoFalso(unEnunciado, respuestaCorrecta);
        miPreguntaVF.tipoPuntaje = new TipoPuntajePenalidad();
        return miPreguntaVF;
    }

    public List<Integer> responder(List<RespuestaVerdaderoFalso> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaVerdaderoFalso respuestaUsuario : respuestas) {
            puntos.add(this.tipoPuntaje.puntuar(this.respuestaCorrecta.evaluar(respuestaUsuario)));
        }
        return puntos;
    }
}
