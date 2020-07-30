package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RondaTest {


    @Test
    public void Test01RondaProcesaCorrectamenteLasRespuestasVF() {

        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();


        Respuesta correcta = new RespuestaCorrecta("Verdadero");
        Respuesta incorrecta = new RespuestaIncorrecta("Falso");
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(correcta, incorrecta));
        Pregunta pregunta = new VerdaderoFalsoClasico("Una manzana es una fruta", respuestas);

        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(correcta));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(incorrecta));

        Ronda ronda = new Ronda(pregunta, jugadorUno, jugadorDos);

        ronda.procesarRespuestas(respuestaJugadorUno, respuestaJugadorDos);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(0, jugadorDos.puntaje());
    }

    @Test
    public void Test02RondaProcesaCorrectamenteLasRespuestasMCCClasico() {

        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        Respuesta correctaUno = new RespuestaCorrecta("Correcta");
        Respuesta correctaDos = new RespuestaCorrecta("Correcta");
        Respuesta correctaTres = new RespuestaCorrecta("Correcta");
        Respuesta incorrectaUno = new RespuestaIncorrecta("Incorrecta");
        Respuesta incorrectaDos = new RespuestaIncorrecta("Incorrecta");

        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(correctaUno, incorrectaUno, correctaDos, incorrectaDos, correctaTres));
        Pregunta pregunta = new MultipleChoiceParcial("Seleccione las correctas", respuestas);

        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Arrays.asList(correctaUno, correctaDos, incorrectaDos));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Arrays.asList(correctaUno, correctaTres));

        Ronda ronda = new Ronda(pregunta, jugadorUno, jugadorDos);

        ronda.procesarRespuestas(respuestaJugadorUno, respuestaJugadorDos);

        assertEquals(0, jugadorUno.puntaje());
        assertEquals(2, jugadorDos.puntaje());
    }
}
