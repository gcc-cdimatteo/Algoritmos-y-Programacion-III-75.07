package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.ExclusividadDePuntaje;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {

    @Test
    public void test01ExclusividadAsignaCorrectamentePuntosALosJugadores() {
        Jugador jugadorUno = new Jugador("Geronimo");
        Jugador jugadorDos = new Jugador("Dania");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(1, 0);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje(jugadores);

        puntuador.asignarPuntos(puntos);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(0, jugadorDos.puntaje());
    }

    @Test
    public void test02ExclusividadNoIncrementaPuntajeSiAmbosRespondenCorrectamente() {
        Jugador jugadorUno = new Jugador("Adalberta");
        Jugador jugadorDos = new Jugador("Bonifacio");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(1, 1);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje(jugadores);

        puntuador.asignarPuntos(puntos);

        assertEquals(0, jugadorUno.puntaje());
        assertEquals(0, jugadorDos.puntaje());
    }

    @Test
    public void test03ExclusividadNoIncrementaPuntajeSiSeRespondeIncorrectamente() {
        Jugador jugadorUno = new Jugador("Horacio");
        Jugador jugadorDos = new Jugador("Aurora");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(0, 0);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje(jugadores);

        puntuador.asignarPuntos(puntos);

        assertEquals(0, jugadorUno.puntaje());
        assertEquals(0, jugadorDos.puntaje());
    }

    @Test
    public void test04ExclusividadIncrementaElCuadrupleSiAmbosJugadoresLoUtilizan() {
        Jugador jugadorUno = new Jugador("Caro");
        Jugador jugadorDos = new Jugador("Nacho");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(0, 1);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje(jugadores);
        puntuador.usarExclusividad(jugadorUno);
        puntuador.usarExclusividad(jugadorDos);

        puntuador.asignarPuntos(puntos);

        assertEquals(0, jugadorUno.puntaje());
        assertEquals(4, jugadorDos.puntaje());
    }

    @Test
    public void test05ExclusividadIncrementaElDobleSiUnJugadorLoUtiliza() {
        Jugador jugadorUno = new Jugador("X Æ A-12");
        Jugador jugadorDos = new Jugador("Xavier");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(0, 1);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje(jugadores);
        puntuador.usarExclusividad(jugadorUno);

        puntuador.asignarPuntos(puntos);

        assertEquals(0, jugadorUno.puntaje());
        assertEquals(2, jugadorDos.puntaje());
    }


}
