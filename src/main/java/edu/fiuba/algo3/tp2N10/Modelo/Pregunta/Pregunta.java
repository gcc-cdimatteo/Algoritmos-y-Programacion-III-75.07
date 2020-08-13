package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Vista.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta implements Observable {

    protected String enunciado;
    protected List<String> opciones;
    protected Respuesta respuestaCorrecta;
    protected ArrayList<Observer> observers;

    public List<Integer> responder(List<Respuesta> respuestasUsuario) {
        List<Integer> puntos = new ArrayList<>();
        for (Respuesta respuesta : respuestasUsuario) {
            puntos.add(respuestaCorrecta.evaluar(respuesta));
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

    public String getEnunciado() {
        return this.enunciado;
    }

    public List<String> getOpciones() {
        return this.opciones;
    }

}
