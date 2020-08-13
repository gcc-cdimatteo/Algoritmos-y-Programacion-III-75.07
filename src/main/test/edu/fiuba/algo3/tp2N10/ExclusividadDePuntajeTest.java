package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.ExclusividadDePuntaje;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {

    @Test
    public void test01ExclusividadAsignaLosPuntosCorrectamente() {

        List<Integer> puntos = Arrays.asList(1, 0);
        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje();

        assertEquals(puntos, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test02ExclusividadNoAsignaPuntosSiAmbosRespondenCorrectamente() {

        List<Integer> puntos = Arrays.asList(1, 1);
        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje();

        assertEquals(Arrays.asList(0, 0), puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test03ExclusividadNoIncrementaPuntajeSiSeRespondeIncorrectamente() {

        List<Integer> puntos = Arrays.asList(0, 0);
        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje();

        assertEquals(puntos, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test04ExclusividadIncrementaElCuadrupleSiAmbosJugadoresLoUtilizan() {
        Jugador jugadorUno = new Jugador("Caro");
        Jugador jugadorDos = new Jugador("Nacho");

        List<Integer> puntos = Arrays.asList(0, 1);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje();
        puntuador.usarExclusividad(jugadorUno);
        puntuador.usarExclusividad(jugadorDos);

        assertEquals(Arrays.asList(0, 4), puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test05ExclusividadIncrementaElDobleSiUnJugadorLoUtiliza() {
        Jugador jugadorUno = new Jugador("X Æ A-12");
        List<Integer> puntos = Arrays.asList(0, 1);

        ExclusividadDePuntaje puntuador = new ExclusividadDePuntaje();
        puntuador.usarExclusividad(jugadorUno);

        assertEquals(Arrays.asList(0, 2), puntuador.calcularPuntos(puntos));
    }


}
