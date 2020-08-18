package edu.fiuba.algo3.tp2N10.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorExclusividad;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorExclusividadTest {

    @Test
    public void test01ExclusividadDuplicaElPuntajeAlQueHayaContestadoBien() {
        List<Integer> puntos = Arrays.asList(1, 0);
        List<Integer> puntosEsperados = Arrays.asList(2, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(new Jugador("X Æ A-12"));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test02ExclusividadNoIncrementaElPuntajeSiAmbosRespondenCorrectamente() {
        List<Integer> puntos = Arrays.asList(1, 1);
        List<Integer> puntosEsperados = Arrays.asList(0, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(new Jugador("Jugador de Prueba"));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test03ExclusividadNoIncrementaPuntajeSiSeRespondeIncorrectamente() {
        List<Integer> puntos = Arrays.asList(0, 0);
        List<Integer> puntosEsperados = Arrays.asList(0, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(new Jugador("Jugador de Prueba"));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test04ExclusividadCuadruplicaElPuntajeSiAmbosJugadoresLoUtilizan() {
        Jugador jugadorUno = new Jugador("Caro");
        Jugador jugadorDos = new Jugador("Nacho");
        List<Integer> puntos = Arrays.asList(0, 1);
        List<Integer> puntosEsperados = Arrays.asList(0, 4);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(jugadorUno);
        puntuador.usarExclusividad(jugadorDos);
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test01ExclusividadDuplicaElPuntajeAlQueHayaContestadoBienEnPreguntaParcial() {
        List<Integer> puntos = Arrays.asList(3, 0);
        List<Integer> puntosEsperados = Arrays.asList(6, 0);
        PuntuadorExclusividad puntuador = new PuntuadorExclusividad(new Jugador("X Æ A-12"));
        assertEquals(puntosEsperados, puntuador.calcularPuntos(puntos));
    }

}
