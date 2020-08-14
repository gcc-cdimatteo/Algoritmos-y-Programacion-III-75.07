package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorExclusividad;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorExclusividadTest {

    @Test
    public void test01ExclusividadAsignaLosPuntosCorrectamente() {
        List<Integer> puntos = Arrays.asList(1, 0);
        List<Integer> puntosEsperados = Arrays.asList(2, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(Collections.singletonList(new Jugador("Jugador de Prueba")));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test02ExclusividadNoAsignaPuntosSiAmbosRespondenCorrectamente() {
        List<Integer> puntos = Arrays.asList(1, 1);
        List<Integer> puntosEsperados = Arrays.asList(0, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(Collections.singletonList(new Jugador("Jugador de Prueba")));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test03ExclusividadNoIncrementaPuntajeSiSeRespondeIncorrectamente() {
        List<Integer> puntos = Arrays.asList(0, 0);
        List<Integer> puntosEsperados = Arrays.asList(0, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(Collections.singletonList(new Jugador("Jugador de Prueba")));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test04ExclusividadIncrementaElCuadrupleSiAmbosJugadoresLoUtilizan() {
        Jugador jugadorUno = new Jugador("Caro");
        Jugador jugadorDos = new Jugador("Nacho");
        List<Integer> puntos = Arrays.asList(0, 1);
        List<Integer> puntosEsperados = Arrays.asList(0, 4);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(Arrays.asList(jugadorUno, jugadorDos));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test05ExclusividadIncrementaElDobleSiUnJugadorLoUtiliza() {
        Jugador jugadorUno = new Jugador("X Æ A-12");
        List<Integer> puntos = Arrays.asList(0, 1);
        List<Integer> puntosEsperados = Arrays.asList(0, 2);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(Collections.singletonList(jugadorUno));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

}
