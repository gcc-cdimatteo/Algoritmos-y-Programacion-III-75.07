package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.PreguntasFactory;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.ArchivoJsonFalloException;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlgoKahoot {

    private Queue<Pregunta> preguntas;
    private Ronda ronda;
    private Jugador jugadorActual;
    private List<Observer> observers = new ArrayList<>();

    public AlgoKahoot(String nombreArchivoJSON, String jugadorUno, String jugadorDos) {
        try {
            preguntas = new PreguntasFactory(nombreArchivoJSON).getLista();
            Jugador primerJugador = new Jugador(jugadorUno);
            Jugador segundoJugador = new Jugador(jugadorDos);
            primerJugador.ordenarCon(segundoJugador);
            jugadorActual = primerJugador;
            nuevaRonda();
        } catch (IOException e) { throw new ArchivoJsonFalloException(); }
    }

    public int jugadorActualPuntaje() {
        return jugadorActual.puntaje();
    }

    public String jugadorActualNombre() {
        return jugadorActual.nombre();
    }

    public String preguntaActualEnunciado() {
        return ronda.enunciado();
    }

    public boolean preguntaActualPermiteMultiplicadores() { return ronda.preguntaActualPermiteMultiplicadores(); }

    public boolean preguntaActualPermiteExclusividad() { return ronda.preguntaActualPermiteExclusividad(); }

    public List<String> preguntaActualOpciones() {
        return ronda.opciones();
    }

    public void nuevaRonda() {
        if (preguntas.isEmpty()) throw new JuegoFinalizadoException();
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

    public ArrayList<Integer> jugadorMultiplicadoresDisponibles(){return jugadorActual.multiplicadoresDisponibles();}

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::change);
    }

    public Pregunta preguntaActual() { return ronda.preguntaActual(); }
}
