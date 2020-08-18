package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.BolsaDePreguntas;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.ArchivoJsonFalloException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlgoKahoot {

    private final BolsaDePreguntas factoryPreguntas;
    private Ronda ronda;
    private Jugador jugadorActual;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public AlgoKahoot(String nombreArchivoJSON, String jugadorUno, String jugadorDos) {
        try {
            factoryPreguntas = new BolsaDePreguntas(nombreArchivoJSON);
            Jugador primerJugador = new Jugador(jugadorUno);
            Jugador segundoJugador = new Jugador(jugadorDos);
            primerJugador.ordenarCon(segundoJugador);
            jugadorActual = primerJugador;
            nuevaRonda();
        } catch (IOException e) {throw new ArchivoJsonFalloException(); }
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

    public List<String> preguntaActualOpciones() {
        return ronda.opciones();
    }

    public Class<? extends Pregunta> preguntaActualClass() { return ronda.preguntaClass();}

    public void nuevaRonda() { ronda = new Ronda(this.factoryPreguntas.getPregunta(), jugadorActual); }

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

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.change());
    }
}
