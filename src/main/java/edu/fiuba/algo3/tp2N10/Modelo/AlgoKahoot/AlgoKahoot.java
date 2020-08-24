package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlgoKahoot implements Observable {

    private final Queue<Pregunta> preguntas;
    private Ronda ronda;
    private Jugador jugadorActual;
    private boolean finalizado = false;
    private final List<Observer> observers = new ArrayList<>();

    public AlgoKahoot(String file, String jugadorUno, String jugadorDos) throws IOException {
        this.preguntas = new FactoryPreguntas(file).preguntas();
        Jugador primerJugador = new Jugador(jugadorUno);
        Jugador segundoJugador = new Jugador(jugadorDos);
        primerJugador.ordenarCon(segundoJugador);
        jugadorActual = primerJugador;
        nuevaRonda();
    }

    public void nuevaRonda() {
        if (preguntas.isEmpty()) finalizado = true;
        else ronda = new Ronda(this.preguntas.poll(), jugadorActual);
    }

    public List<Integer> puntajes() {
        List<Integer> puntos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            puntos.add(jugadorActual.puntaje());
            cambiarJugador();
        }
        return puntos;
    }

    public List<String> nombres() {
        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            nombres.add(jugadorActual.nombre());
            cambiarJugador();
        }
        return nombres;
    }

    public void siguientePregunta() {
        ronda.asignarPuntos();
        nuevaRonda();
        notifyObservers();
    }

    public void jugadorNoResponde() {
        ronda.jugadorNoResponde();
        cambiarJugador();
        notifyObservers();
    }

    public void cargarRespuesta(Respuesta respuesta) {
        ronda.cargarRespuesta(respuesta);
        cambiarJugador();
        notifyObservers();
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

    private void cambiarJugador() {
        jugadorActual = jugadorActual.siguienteJugador();
    }

    public void jugadorUsaMultiplicador(int unValor) {
        jugadorActual.usarMultiplicador(unValor);
    }

    public void jugadorUsaExclusividad() {
        ronda.usarExclusividad(jugadorActual);
    }

    public boolean finalizado() {
        return finalizado;
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

    public String preguntaActual() {
        return ronda.preguntaActual();
    }

    public String respuestaCorrecta() {
        return ronda.respuestaCorrecta();
    }
}
