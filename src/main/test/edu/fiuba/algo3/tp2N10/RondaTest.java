package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    @Test
    public void Test01RondaAsignaCorrectamentePuntajesALosJugadores() {
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);

        Ronda ronda = new Ronda(jugadores);

        List<Integer> puntajes = Arrays.asList(1, 2);

        ronda.asignarPuntajes(puntajes);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(2, jugadorDos.puntaje());
    }

}

