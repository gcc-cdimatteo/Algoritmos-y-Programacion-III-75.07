package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.JuegoTerminadoException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;

import java.util.List;

public class AlgoKahoot {

    private List<Jugador> jugadores;
    private final List<Pregunta> preguntas;
    private Integer preguntaActual = 0;
    private Ronda rondaActual;

    public AlgoKahoot(List<Pregunta> preguntas, List<Jugador> jugadores) {
        this.preguntas = preguntas;
        this.jugadores = jugadores;
        rondaActual = new Ronda(preguntas.get(preguntaActual), jugadores);
    }

    public Ronda getRonda() {
        return rondaActual;
    }

    public void siguienteRonda() {
        preguntaActual++;
        rondaActual.asignarPuntos();
        try {
            rondaActual = new Ronda(preguntas.get(preguntaActual), jugadores);
        } catch (IndexOutOfBoundsException e) {
            throw new JuegoTerminadoException();
        }
    }
}
