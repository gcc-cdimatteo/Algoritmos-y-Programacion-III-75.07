package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Vista.Observer;

import java.util.ArrayList;
import java.util.List;

public class PreguntaOrderedChoice implements Observable {

    private final String enunciado;
    private final List<String> opciones;
    private RespuestaOrderedChoice respuestaCorrecta;
    private List<Observer> observers;

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaOrderedChoice(opcionesCorrectas);
        this.observers = new ArrayList<>();
    }

    public List<Integer> responder(List<RespuestaOrderedChoice> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaOrderedChoice respuestaUsuario : respuestas) {
            puntos.add(respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }
}
