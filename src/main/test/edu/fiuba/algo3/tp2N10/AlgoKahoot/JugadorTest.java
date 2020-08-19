package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01JugadorRecienCreadoTienePuntajeCero() {
        Jugador jugador = new Jugador("Wenceslao");
        assertEquals(0, jugador.puntaje());
    }

    @Test
    public void test02JugadorRecienCreadoTieneExclusividadDisponible() {
        Jugador jugador = new Jugador("Wenceslao");
        assertTrue(jugador.exclusividadDisponible());
    }

    @Test
    public void test03JugadorConoceSuNombre() {
        Jugador jugador = new Jugador("Wenceslao2");
        assertEquals("Wenceslao2", jugador.nombre());
    }

    @Test
    public void test04JugadorEsPuntuadoPositivamenteYGanaPuntos() {
        Jugador jugador = new Jugador("Ofelia");
        jugador.puntuar(10);
        assertEquals(10, jugador.puntaje());
    }

    @Test
    public void test05JugadorEsPuntuadoNegativamenteYPierdePuntos() {
        Jugador jugador = new Jugador("Yolanda");
        jugador.puntuar(-8);
        assertEquals(-8, jugador.puntaje());
    }

    @Test
    public void test06JugadorEsPuntuadoVariasVecesYSuPuntajeEsLaSumaTotal() {
        Jugador jugador = new Jugador("Velasco");

        jugador.puntuar(-1);
        jugador.puntuar(10);
        jugador.puntuar(-3);
        jugador.puntuar(-2);
        jugador.puntuar(1);

        assertEquals(5, jugador.puntaje());
    }

    @Test
    public void test07JugadorSoloPuedeUsarExclusividadDePuntaje2Veces() {
        Jugador jugador = new Jugador("Casimiro");
        jugador.usarExclusividad();
        jugador.usarExclusividad();
        assertFalse(jugador.exclusividadDisponible());
    }

    @Test
    public void test08SiJugadorUsaExclusividadYNoEstaDisponibleLanzaUnaExcepcion() {
        Jugador jugador = new Jugador("Casimiro");
        jugador.usarExclusividad();
        jugador.usarExclusividad();
        assertThrows(PowerUpNoDisponibleException.class, jugador::usarExclusividad);
    }


    @Test
    public void test09SiSeLosOrdenaElJugadorQueVaPrimeroEsAlQueSeLeEnvioElMensaje() {
        Jugador primerJugador = new Jugador("Jugador Uno");
        Jugador segundoJugador = new Jugador("Jugador Dos");
        primerJugador.ordenarCon(segundoJugador);
        assertTrue(primerJugador.vaPrimero());
        assertFalse(segundoJugador.vaPrimero());
    }

    @Test
    public void test10UnJugadorPuedeGuardarseUnaReferenciaDelQueLeSigue() {
        Jugador primerJugador = new Jugador("Jugador Uno");
        Jugador segundoJugador = new Jugador("Jugador Dos");
        primerJugador.ordenarCon(segundoJugador);
        Jugador jugadorActual = primerJugador;
        jugadorActual = jugadorActual.siguienteJugador();
        assertEquals(segundoJugador, jugadorActual);
    }

    @Test
    public void test11UnJugadorPuedeVolverASiMismoLuegoDePasarPorSuContiguo() {
        Jugador primerJugador = new Jugador("Jugador Uno");
        Jugador segundoJugador = new Jugador("Jugador Dos");
        primerJugador.ordenarCon(segundoJugador);
        Jugador jugadorActual = primerJugador;
        jugadorActual = jugadorActual.siguienteJugador();
        jugadorActual = jugadorActual.siguienteJugador();
        assertEquals(primerJugador, jugadorActual);
    }

    @Test
    public void test12JugadorUsaMultiplicadorPor3yTriplicaElPuntaje() {
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