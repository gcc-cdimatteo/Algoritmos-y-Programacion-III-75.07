package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorNulo;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgoKahoot {

    private final LinkedList<Pregunta> preguntas;
    private final PuntuadorNulo puntuador;
    private final Jugador jugadorActual;

    public AlgoKahoot(List<Pregunta> preguntas, List<String> jugadores) {
        this.preguntas = (LinkedList<Pregunta>) preguntas;
        Jugador primerJugador = new Jugador(jugadores.get(0));
        Jugador segundoJugador = new Jugador(jugadores.get(1));
        primerJugador.conJugadorSiguiente(segundoJugador);
        this.jugadorActual = primerJugador;
        this.puntuador = new PuntuadorNulo();
    }

    public int jugadorActualPuntaje() {
        return jugadorActual.puntaje();
    }

    public void cargarRespuesta(Respuesta unaRespuesta) {
    }

    public void cambiarTurno() {
        jugadorActual.cambiarJugador();
    }

    public void jugadorUsaMultiplicador(int unMultiplicador) {
        jugadorActual.usarMultiplicador(unMultiplicador);
    }

    public void jugadorUsaExclusividad() {
        jugadorActual.usarExclusividad();
    }

//    public void cargarRespuesta(Respuesta respuesta) {
//        respuestas.add(respuesta);
//    }
//
//    public Jugador jugadorActual() {
//        return this.jugadorActual;
//    }
//
//    public void exclusividadDePuntaje(Jugador jugador) {
//        puntuador = puntuador.usarExclusividad(jugador);
//    }
//
//    public void asignarPuntos() {
//        List<Integer> puntos = puntuador.calcularPuntos(preguntas.get(preguntaActual).responder(respuestas));
//        for (int i = 0; i < puntos.size(); i++) {
//            jugadores.get(i).puntuar(puntos.get(i));
//        }
//    }

}
