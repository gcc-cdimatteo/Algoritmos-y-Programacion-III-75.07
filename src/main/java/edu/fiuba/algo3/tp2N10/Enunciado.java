package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class Enunciado implements Mostrable{

    private final String pregunta;
    private final List<String> opciones;

    public Enunciado(String pregunta, List<String> opciones) {
        this.pregunta = pregunta;
        this.opciones = opciones;
    }

    @Override
    public String getPregunta() {
        return this.pregunta;
    }

    @Override
    public List<String> getOpciones() {
        return this.opciones;
    }
}
