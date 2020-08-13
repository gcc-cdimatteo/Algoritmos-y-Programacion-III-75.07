package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeClasico;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeParcial;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajePenalidad;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Vista.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaMultipleChoice extends Pregunta {

    private Puntaje puntaje;

    private PreguntaMultipleChoice(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaMultipleChoice(opcionesCorrectas);
        this.observers = new ArrayList<>();
    }

    public static PreguntaMultipleChoice Parcial(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.puntaje = new PuntajeParcial();
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Penalidad(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.puntaje = new PuntajePenalidad();
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Clasico(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.puntaje = PuntajeClasico.ParaMultipleChoice(new RespuestaMultipleChoice(opcionesCorrectas));
        return miPreguntaMC;
    }

    @Override
    public List<Integer> responder(List<Respuesta> respuestasUsuario) {
        List<Integer> puntos = new ArrayList<>();
        for (Respuesta respuestaUsuario : respuestasUsuario) {
            puntos.add(puntaje.puntuar(respuestaCorrecta.evaluar(respuestaUsuario)));
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
