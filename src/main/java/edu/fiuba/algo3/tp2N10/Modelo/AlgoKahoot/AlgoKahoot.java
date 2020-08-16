package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.util.LinkedList;
import java.util.List;

public class AlgoKahoot {

    private final LinkedList<Pregunta> preguntas;
    private Ronda ronda;
    private Jugador jugadorActual;

    public AlgoKahoot(List<Pregunta> preguntas, String jugadorUno, String jugadorDos) {
        this.preguntas = new LinkedList<>(preguntas);
        Jugador primerJugador = new Jugador(jugadorUno);
        Jugador segundoJugador = new Jugador(jugadorDos);
        primerJugador.ordenarCon(segundoJugador);
        this.jugadorActual = primerJugador;
        nuevaRonda();
    }

    public int jugadorActualPuntaje() {
        return jugadorActual.puntaje();
    }

    public void nuevaRonda() {
        ronda = new Ronda(preguntas.poll(), jugadorActual);
    }

    public void cargarRespuesta(Respuesta respuesta) {
        ronda.cargarRespuesta(respuesta);
        cambiarJugador();
        if (jugadorActual.vaPrimero()) {
            ronda.asignarPuntos();
            nuevaRonda();
        }
    }

    public void cambiarJugador() {
        jugadorActual = jugadorActual.siguienteJugador();
    }

    public void jugadorUsaMultiplicador(int unValor) {
        jugadorActual.usarMultiplicador(unValor);
    }

    public void jugadorUsaExclusividad() {
        ronda.usarExclusividad(jugadorActual);
    }
}
