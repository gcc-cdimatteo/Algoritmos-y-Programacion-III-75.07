package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.ExclusividadDePuntaje;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorTest {

    @Test
    public void test01PuntuadorAsignaCorrectamentePuntosALosJugadores() {
        Jugador jugadorUno = new Jugador("Carmelo");
        Jugador jugadorDos = new Jugador("Gertrudis");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(1, 2);

        Puntuador puntuador = new Puntuador(jugadores);

        puntuador.asignarPuntos(puntos);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(2, jugadorDos.puntaje());
    }

    @Test
    public void test02UsarExclusividadDevuelveExclusividadDePuntaje() {
        Jugador jugadorUno = new Jugador("Magnolia");
        Jugador jugadorDos = new Jugador("Leónidas");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        Puntuador puntuador = new Puntuador(jugadores);

        assertEquals(ExclusividadDePuntaje.class, puntuador.usarExclusividad(jugadorDos).getClass());
    }
}
