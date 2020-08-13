package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.tp2N10.Vista.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaGroupChoice implements Observable, Mostrable {

    private final String enunciado;
    private final List<String> opciones;
    private final RespuestaGroupChoice respuestaCorrecta;
    private List<Observer> observers;

    public PreguntaGroupChoice(String enunciado, List<String> opciones, Set<Integer> opcionesGrupoA, Set<Integer> opcionesGrupoB){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaGroupChoice(opcionesGrupoA, opcionesGrupoB);
        this.observers = new ArrayList<>();
    }

    public List<Integer> responder(List<RespuestaGroupChoice> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaGroupChoice respuestaUsuario : respuestas) {
            puntos.add(respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }

    @Override
    public String getEnunciado(){
        return this.enunciado;
    }

    @Override
    public List<String> getOpciones(){
        return this.opciones;
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
