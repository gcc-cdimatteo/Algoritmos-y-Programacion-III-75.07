package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorNulo;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private final Pregunta pregunta;
    private final List<Respuesta> respuestas;
    private Puntuador puntuador;
    private Jugador jugador;

    public Ronda(Pregunta pregunta, Jugador primerJugador) {
        this.pregunta = pregunta;
        this.puntuador = new PuntuadorNulo();
        this.respuestas = new ArrayList<>();
        this.jugador = primerJugador;
    }

    public void cargarRespuesta(Respuesta respuesta) {
        respuestas.add(respuesta);
    }

    public void usarExclusividad(Jugador jugador) {
        puntuador = puntuador.usarExclusividad(jugador);
    }

    public void asignarPuntos() {
        List<Integer> puntos = puntuador.calcularPuntos(pregunta.responder(respuestas));
        for (Integer punto : puntos) {
            jugador.puntuar(punto);
            jugador = jugador.siguienteJugador();
        }
    }
}