package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.BolsaDePreguntas;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.JuegoTerminadoException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorNulo;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.io.IOException;
import java.util.List;

public class AlgoKahoot {

//    private final List<Jugador> jugadores;
//    private Puntuador puntuador;
    private Jugador jugadorActual;
    private List<Pregunta> preguntas;
    private List<Respuesta> respuestas;
    private Integer preguntaActual = 0;

    public AlgoKahoot(List<Pregunta> preguntas, List<Jugador> jugadores) {
        this.preguntas = preguntas;
//        this.jugadores = jugadores;
        this.jugadorActual = Jugador.ingresarJugadores(jugadores);
//        this.puntuador = new PuntuadorNulo();
    }

//    public void cargarRespuesta(Respuesta respuesta) {
//        respuestas.add(respuesta);
//    }
//
//    public Jugador jugadorActual() {
//        return this.jugadorActual;
//    }
//
//    public void exclusividadDePuntaje(Jugador jugador) {
//        puntuador = puntuador.usarExclusividad(jugador);
//    }
//
//    public void asignarPuntos() {
//        List<Integer> puntos = puntuador.calcularPuntos(preguntas.get(preguntaActual).responder(respuestas));
//        for (int i = 0; i < puntos.size(); i++) {
//            jugadores.get(i).puntuar(puntos.get(i));
//        }
//    }

}
