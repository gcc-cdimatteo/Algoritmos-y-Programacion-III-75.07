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

    public abstract List<Integer> responder(List<Respuesta> respuestas);

    public String getEnunciado() {
        return this.enunciado;
    }

    public List<String> getOpciones() {
        return this.opciones;
    }

}
