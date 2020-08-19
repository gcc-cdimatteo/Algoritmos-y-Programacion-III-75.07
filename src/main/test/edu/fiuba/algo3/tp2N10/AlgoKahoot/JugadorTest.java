package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01JugadorRecienCreadoTienePuntaje0() {
        Jugador jugador = new Jugador("Wenceslao");
        assertEquals(0, jugador.puntaje());
    }

    @Test
    public void test02JugadorConoceSuNombre() {
        Jugador jugador = new Jugador("Wenceslao2");
        assertEquals("Wenceslao2", jugador.nombre());
    }

    @Test
    public void test03JugadorEsPuntuadoPositivamenteYDevuelveSusPuntos() {
        Jugador jugador = new Jugador("Ofelia");
        jugador.puntuar(10);
        assertEquals(10, jugador.puntaje());
    }

    @Test
    public void test04JugadorEsPuntuadoNegativamenteYDevuelveSusPuntos() {
        Jugador jugador = new Jugador("Yolanda");
        jugador.puntuar(-8);
        assertEquals(-8, jugador.puntaje());
    }

    @Test
    public void test05JugadorEsPuntuadoVariasVecesYSuPuntajeEsLaSumaTotal() {
        Jugador jugador = new Jugador("Velasco");

        jugador.puntuar(-1);
        jugador.puntuar(10);
        jugador.puntuar(-3);
        jugador.puntuar(-2);
        jugador.puntuar(1);

        assertEquals(5, jugador.puntaje());
    }

    @Test
    public void test06JugadorSoloPuedeUsarExclusividadDePuntaje2Veces() {
        Jugador jugador = new Jugador("Casimiro");
        jugador.usarExclusividad();
        jugador.usarExclusividad();
        assertFalse(jugador.exclusividadDisponible());
    }

    @Test
    public void test07UnJugadorPuedeGuardarseUnaReferenciaDelQueLeSigue() {
        Jugador primerJugador = new Jugador("Jugador Uno");
        Jugador segundoJugador = new Jugador("Jugador Dos");
        primerJugador.ordenarCon(segundoJugador);
        Jugador jugadorActual = primerJugador;
        jugadorActual = jugadorActual.siguienteJugador();
        assertEquals(segundoJugador, jugadorActual);
    }

    @Test
    public void test08UnJugadorPuedeVolverASiMismoLuegoDePasarPorSuContiguo() {
        Jugador primerJugador = new Jugador("Jugador Uno");
        Jugador segundoJugador = new Jugador("Jugador Dos");
        primerJugador.ordenarCon(segundoJugador);
        Jugador jugadorActual = primerJugador;
        jugadorActual = jugadorActual.siguienteJugador();
        jugadorActual = jugadorActual.siguienteJugador();
        assertEquals(primerJugador, jugadorActual);
    }

    @Test
    public void test09JugadorUsaMultiplicadorPor3yTriplicaElPuntaje() {
        Jugador miJugador = new Jugador("Carolina");
        miJugador.usarMultiplicador(3);
        miJugador.puntuar(2);
        assertEquals(6, miJugador.puntaje());
    }

    @Test
    public void test10JugadorUsaMultiplicadorPor2yDuplicaElPuntaje() {
        Jugador miJugador = new Jugador("Carolina");
        miJugador.usarMultiplicador(2);
        miJugador.puntuar(2);
        assertEquals(4, miJugador.puntaje());
    }
}