//package edu.fiuba.algo3.tp2N10;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Ronda {
//    private Jugador jugadorUno;
//    private Jugador jugadorDos;
//    private Pregunta pregunta;
//
//    public Ronda(Pregunta pregunta, Jugador jugadorUno, Jugador jugadorDos){
//        this.jugadorUno = jugadorUno;
//        this.jugadorDos = jugadorDos;
//        this.pregunta = pregunta;
//    }
//
//    private void asignarPuntos(ArrayList<Integer> puntos){
//        this.jugadorUno.puntuar(puntos.get(0));
//        this.jugadorDos.puntuar(puntos.get(1));
//    }
//
//    //probablemente las respuestas despues se obtengan desde un stage creado desde un metodo "ronda.iniciarRonda()"
//    public void procesarRespuestas(ArrayList<Respuesta> respuestaUno, ArrayList<Respuesta> respuestaDos){
//
//
//
//        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaUno, respuestaDos));
//        ArrayList<Integer> puntos = this.pregunta.responder(respuestas);
//        this.asignarPuntos(puntos);
//    }
//}
