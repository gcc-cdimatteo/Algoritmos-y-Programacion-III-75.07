package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTest {

    @Test
    public void Test01JugadorRecienCreadoDevuelve0PuntosYCadenaVacia(){
        Jugador jugador = new Jugador("");

        assertEquals("",jugador.nombre());
        assertEquals(0,jugador.puntaje());
    }

    @Test
    public void Test02JugadorEsNombradoYDevuelveSuNombre(){
        Jugador jugador = new Jugador("Martin");

        assertEquals("Martin", jugador.nombre());
    }

    @Test
    public void Test03JugadorEsPuntuadoPositivamenteYDevuelveSusPuntos(){
        Jugador jugador = new Jugador("");
        jugador.puntuar(10);
        assertEquals(10,jugador.puntaje());
    }

    @Test
    public void Test04JugadorEsPuntuadoNegativamenteYDevuelveSusPuntos(){
        Jugador jugador = new Jugador("");

        jugador.puntuar(-8);

        assertEquals(-8, jugador.puntaje());
    }

    @Test
    public void Test05JugadorEsPuntuadoVariasVeces(){
        Jugador jugador = new Jugador("");

        jugador.puntuar(-1);
        jugador.puntuar(10);
        jugador.puntuar(-3);
        jugador.puntuar(-2);
        jugador.puntuar(1);

        assertEquals(5,jugador.puntaje());
    }
}
