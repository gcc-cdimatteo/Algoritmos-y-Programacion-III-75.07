package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.FaltanRespuestasException;
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
        this.respuestas = new ArrayList<>(2);
        this.jugador = primerJugador;
    }

    public void cargarRespuesta(Respuesta respuesta) {
        respuestas.add(respuesta);
    }

    public void usarExclusividad(Jugador jugador) {
        puntuador = puntuador.usarExclusividad(jugador);
    }

    public void asignarPuntos() {
        if (respuestas.size() < 2) throw new FaltanRespuestasException();
        List<Integer> puntos = puntuador.calcularPuntos(pregunta.responder(respuestas));
        for (Integer puntosJugador : puntos) {
            jugador.puntuar(puntosJugador);
            jugador = jugador.siguienteJugador();
        }
    }

    public String enunciado() {
        return this.pregunta.getEnunciado();
    }

    public List<String> opciones() {
        return this.pregunta.getOpciones();
    }

    public boolean permiteMultiplicadores() { return this.pregunta.permiteMultiplicadores(); }

    public boolean permiteExclusividad() { return this.pregunta.permiteExclusividad(); }

    public String preguntaActual() {
        return pregunta.tipoPregunta();
    }

    public void jugadorNoResponde() {
        respuestas.add(pregunta.respuestaIncorrecta());
    }

    public String respuestaCorrecta() {
        return pregunta.respuestaCorrecta();
    }
}
