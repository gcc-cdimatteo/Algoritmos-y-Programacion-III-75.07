package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.ExclusividadDePuntaje;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Multiplicador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Puntuador;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoKahootTest {
// Capaz AlgoKahoot podria volver a ser Ronda encargandose solo de manejar las asignaciones de puntos despues de que todos los jugadores respondan
// Hacer una clase algoKahoot global a todas las rondas pierde sentido ya habiendo un main (donde ya estan los jugadores guardados)
// y aparte vuelve engorroso el manejo de powerups entre diferentes preguntas (al pasar de ronda)

    @Test
    public void test01AlgoKahootSeCreaConUnaListaDeJugadoresYLesAsignaElPuntajeCorrectamente() {
        Jugador jugadorUno = new Jugador("Carmelo");
        Jugador jugadorDos = new Jugador("Gertrudis");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(1, 2);

        AlgoKahoot algoKahoot = new AlgoKahoot(jugadores);

        algoKahoot.asignarPuntajes(puntos);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(2, jugadorDos.puntaje());
    }

    @Test
    public void test02AlgoKahootConMultiplicadorAsignaPuntosCorrectamente() {
        Jugador jugadorUno = new Jugador("Carmelo");
        Jugador jugadorDos = new Jugador("Gertrudis");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(2, -2);

        AlgoKahoot algoKahoot = new AlgoKahoot(jugadores);

        //De esta forma se facilita el manejo de powerups desde los controladores
        algoKahoot.usarMultiplicador(jugadorUno, 3);

        //Despues de asignar los puntajes devuelve una lista con cuantos puntos gano cada jugador (con los powerups ya calculados) para mostrar al final de cada ronda
        List<Integer> PuntosObtenidos = algoKahoot.asignarPuntajes(puntos);

        assertEquals(6, jugadorUno.puntaje());
        assertEquals(-2, jugadorDos.puntaje());
    }

    @Test
    public void test03AlgoKahootConExclusividadAsignaPuntosCorrectamente() {
        Jugador jugadorUno = new Jugador("Carmelo");
        Jugador jugadorDos = new Jugador("Gertrudis");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);
        List<Integer> puntos = Arrays.asList(1, 2);

        AlgoKahoot algoKahoot = new AlgoKahoot(jugadores);

        algoKahoot.usarExclusividad(jugadorDos);
        algoKahoot.asignarPuntajes(puntos);

        assertEquals(0, jugadorUno.puntaje());
        assertEquals(3, jugadorDos.puntaje());
    }
}

