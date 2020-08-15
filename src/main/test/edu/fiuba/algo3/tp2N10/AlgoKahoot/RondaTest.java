package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    private boolean respuestaCorrecta;
    private Pregunta pregunta;
    private Jugador jugador1;
    private Respuesta respuestaJugador1;
    private Respuesta respuestaJugador2;
    private Jugador jugador2;
    private Ronda ronda;

    public void crearJugadores(){
        this.jugador1 = new Jugador("Agustin");
        this.jugador2 = new Jugador("Bill Gates");
    }

    public void crearPreguntaVerdaderoYFalsoClasico(){
        this.respuestaCorrecta = true;
        this.pregunta = PreguntaVerdaderoFalso.Clasico("La Manzana es una fruta", this.respuestaCorrecta );

    }

    public void crearRonda(){
        this.ronda = new Ronda(this.pregunta, Arrays.asList(this.jugador1, this.jugador2));
    }

    @Test
    public void rondaRecibeRespuestasYAsignaPuntajeCorrectamenteVFC(){
        crearJugadores();
        crearPreguntaVerdaderoYFalsoClasico();
        crearRonda();
        this.respuestaJugador1 = new RespuestaVerdaderoFalso(this.respuestaCorrecta);
        this.respuestaJugador2 = new RespuestaVerdaderoFalso(false);
        this.ronda.cargarRespuesta(this.respuestaJugador1);
        this.ronda.cargarRespuesta(this.respuestaJugador2);
        this.ronda.asignarPuntos();

        assertEquals(1, this.jugador1.puntaje());
        assertEquals(0, this.jugador2.puntaje());
    }
}
