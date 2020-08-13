package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Vista.Observer;

import java.util.ArrayList;
import java.util.List;

public class PreguntaOrderedChoice extends Pregunta {

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaOrderedChoice(opcionesCorrectas);
        this.observers = new ArrayList<>();
    }

    @Override
    public List<Integer> responder(List<Respuesta> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (Respuesta respuestaUsuario : respuestas) {
            puntos.add(respuestaCorrecta.evaluar(respuestaUsuario).get(0));
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
