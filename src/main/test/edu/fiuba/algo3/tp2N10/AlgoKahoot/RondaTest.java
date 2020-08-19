package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    private Pregunta pregunta;
    private Jugador jugador1;
    private Jugador jugador2;
    private Ronda ronda;

    public void crearJugadores(){
        this.jugador1 = new Jugador("Agustin");
        this.jugador2 = new Jugador("Bill Gates");
        jugador1.ordenarCon(jugador2);
    }

    public void crearPreguntaVerdaderoYFalsoClasico(){
        this.pregunta = PreguntaVerdaderoFalso.Clasico("La Manzana es una fruta", true);

    }

    public void crearRonda() {
        this.ronda = new Ronda(this.pregunta, this.jugador1);
    }

    @Test
    public void rondaRecibeRespuestasYAsignaPuntajeCorrectamenteVFC(){
        crearJugadores();
        crearPreguntaVerdaderoYFalsoClasico();
        crearRonda();
        Respuesta respuestaJugador1 = new RespuestaVerdaderoFalso(true);
        Respuesta respuestaJugador2 = new RespuestaVerdaderoFalso(false);
        this.ronda.cargarRespuesta(respuestaJugador1);
        this.ronda.cargarRespuesta(respuestaJugador2);
        this.ronda.asignarPuntos();

        assertEquals(1, this.jugador1.puntaje());
        assertEquals(0, this.jugador2.puntaje());
    }
}
