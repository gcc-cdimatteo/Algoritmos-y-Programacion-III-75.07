package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.tp2N10.Vista.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaGroupChoice extends Pregunta {

    public PreguntaGroupChoice(String enunciado, List<String> opciones, Set<Integer> opcionesGrupoA, Set<Integer> opcionesGrupoB){
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaGroupChoice(opcionesGrupoA, opcionesGrupoB);
        this.observers = new ArrayList<>();
    }

    @Override
    public List<Integer> responder(List<Respuesta> respuestasUsuario) {
        List<Integer> puntos = new ArrayList<>();
        for (Respuesta respuesta : respuestasUsuario) {
            puntos.add(respuestaCorrecta.evaluar(respuesta).get(0));
        }
        return puntos;
    }

    @Override
    public String getEnunciado(){
        return this.enunciado;
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
