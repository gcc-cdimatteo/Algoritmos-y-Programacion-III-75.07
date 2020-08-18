package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.BolsaDePreguntas;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlgoKahootTest {
    public AlgoKahoot creoUnAlgoKahoot() {
        return new AlgoKahoot("preguntas_test.json", "Delfina", "Camila");
    }

    @Test
    public void test01AlgoKahootPuedeCrearseSiSeIndicaElNombreDelArchivoJSONDePreguntasYElNombreDeLosJugadores() {
        assertEquals(AlgoKahoot.class, creoUnAlgoKahoot().getClass());
    }

    @Test
    public void test02AlgoKahootRecibeYProcesaLaRespuestaDeTodosLosJugadoresCambiandoDeTurno() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));

        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();

        assertEquals(Arrays.asList(1, 0), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test03LosJugadoresPuedenUsarMultiplicadoresAntesDeResponder() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.jugadorUsaMultiplicador(3);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();

        assertEquals(Arrays.asList(3, 0), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test04UnJugadorNoPuedeUsarUnMultiplicadorMasDeUnaVez() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.jugadorUsaMultiplicador(2);

        assertThrows(PowerUpNoDisponibleException.class, () -> algoKahoot.jugadorUsaMultiplicador(2));
    }

    @Test
    public void test05SiUnJugadorUsaExclusividadAlgoKahootAsignaCorrectamenteElPuntaje() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        //Estas lineas son para debuggear, despues refactorizo mejor
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        ///////////////////////////////////////////////////////////////////

        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2))));
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1))));
        assertEquals(6, algoKahoot.jugadorActualPuntaje());
    }

    @Test
    public void test06SiAmbosJugadoresUsanExclusividadAlgoKahootCuadruplicaElPuntajeDelQueContestaCorrectamente() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        //Estas lineas son para debuggear, despues refactorizo mejor
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        ///////////////////////////////////////////////////////////////////

        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 3))));
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2))));
        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();
        assertEquals(Arrays.asList(0, 12), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }
}
