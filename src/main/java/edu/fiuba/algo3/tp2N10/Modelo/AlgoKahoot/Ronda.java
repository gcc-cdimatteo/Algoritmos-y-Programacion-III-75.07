package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.util.Arrays;
import java.util.List;

public class Ronda {
    private Pregunta pregunta;
    private List<Respuesta> respuestas;
    private Puntuador puntuador;


    public Ronda(Pregunta pregunta, List<Jugador> jugadores) {
        this.pregunta = pregunta;
        this.puntuador = new Puntuador(jugadores);
        this.respuestas = Arrays.asList();
    }

    public void cargarRespuesta(Respuesta respuesta){
        this.respuestas.add(respuesta);
    }

    public void exclusividadDePuntaje(Jugador jugador){
        this.puntuador.usarExclusividad(jugador);
    }

    public void asignarPuntos(){
        //Validar que se hayan ingresado todas las respuestas
        this.puntuador.asignarPuntos(this.pregunta.responder(this.respuestas));
    }

}