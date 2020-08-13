package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private final Pregunta pregunta;
    private List<Respuesta> respuestas;
    private Puntuador puntuador;
    private final List<Jugador> jugadores;


    public Ronda(Pregunta pregunta, List<Jugador> jugadores) {
        this.pregunta = pregunta;
        this.puntuador = new Puntuador(jugadores);
        this.respuestas = new ArrayList<>();
        this.jugadores = jugadores;
    }

    public void cargarRespuesta(Respuesta respuesta) {
        respuestas.add(respuesta);
    }

    public Jugador jugadorActual() {
        return jugadores.get(respuestas.size());
    }

    public void exclusividadDePuntaje(Jugador jugador) {
        puntuador = puntuador.usarExclusividad(jugador);
    }

    public void asignarPuntos() {
        //Validar que se hayan ingresado todas las respuestas
        puntuador.asignarPuntos(pregunta.responder(respuestas));
    }

}