package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlgoKahoot {

    private final Queue<Pregunta> preguntas;
    private Ronda ronda;
    private Jugador jugadorActual;
    private final List<Observer> observers = new ArrayList<>();
    private boolean finalizado = false;

    public AlgoKahoot(Queue<Pregunta> preguntas, String jugadorUno, String jugadorDos) throws IOException {
        this.preguntas = preguntas;
        Jugador primerJugador = new Jugador(jugadorUno);
        Jugador segundoJugador = new Jugador(jugadorDos);
        primerJugador.ordenarCon(segundoJugador);
        jugadorActual = primerJugador;
        nuevaRonda();
    }

    public boolean finalizado() {
        return finalizado;
    }

    public int jugadorPuntaje() {
        return jugadorActual.puntaje();
    }

    public String jugadorNombre() {
        return jugadorActual.nombre();
    }

    public String preguntaEnunciado() {
        return ronda.enunciado();
    }

    public List<String> preguntaOpciones() {
        return ronda.opciones();
    }

    public void nuevaRonda() {
        if (preguntas.isEmpty()) {
            this.finalizado = true;
            notifyObservers();
        }
        ronda = new Ronda(this.preguntas.poll(), jugadorActual);
    }

    public void cargarRespuesta(Respuesta respuesta) {
        ronda.cargarRespuesta(respuesta);
        cambiarJugador();
        if (jugadorActual.vaPrimero()) {
            ronda.asignarPuntos();
            nuevaRonda();
        }
        notifyObservers();
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

    public boolean permiteMultiplicadores() {
        return ronda.permiteMultiplicadores();
    }

    public boolean multiplicadorDisponible(int valor) {
        return jugadorActual.multiplicadorDisponible(valor);
    }

    public boolean permiteExclusividad() {
        return ronda.permiteExclusividad() && jugadorActual.exclusividadDisponible();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::change);
    }

    public Pregunta preguntaActual() {
        return ronda.preguntaActual();
    }
}
