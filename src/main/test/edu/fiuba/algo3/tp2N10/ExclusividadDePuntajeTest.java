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
        puntuador.usarExclusividad(jugadorDos);

        puntuador.asignarPuntos(puntos);

        assertEquals(2, jugadorUno.puntaje());
        assertEquals(0, jugadorDos.puntaje());
    }
}
