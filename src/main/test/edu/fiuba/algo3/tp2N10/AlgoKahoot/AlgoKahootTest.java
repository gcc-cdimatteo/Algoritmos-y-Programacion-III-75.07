package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlgoKahootTest {
    public AlgoKahoot creoUnAlgoKahoot(String archivoNombre) {
        return new AlgoKahoot(archivoNombre, "Delfina", "Camila");
    }

//    @Test
//    public void test01AlgoKahootPuedeCrearseSiSeIndicaElNombreDelArchivoJSONDePreguntasYElNombreDeLosJugadores() {
//        assertEquals(AlgoKahoot.class, creoUnAlgoKahoot("preguntas_test.json").getClass());
//    }
//
//    @Test
//    public void test02AlgoKahootRecibeYProcesaLaRespuestaDeTodosLosJugadoresCambiandoDeTurno() {
//        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");
//
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
//
//        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
//        algoKahoot.cambiarJugador();
//        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();
//
//        assertEquals(Arrays.asList(1, 0), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
//    }
//
//    @Test
//    public void test03LosJugadoresPuedenUsarMultiplicadoresAntesDeResponder() {
//        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");
//
//        algoKahoot.jugadorUsaMultiplicador(3);
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
//        algoKahoot.jugadorUsaMultiplicador(2);
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
//        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
//        algoKahoot.cambiarJugador();
//        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();
//
//        assertEquals(Arrays.asList(3, 0), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
//    }
//
//    @Test
//    public void test04UnJugadorNoPuedeUsarUnMultiplicadorMasDeUnaVez() {
//        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");
//
//        algoKahoot.jugadorUsaMultiplicador(2);
//
//        assertThrows(PowerUpNoDisponibleException.class, () -> algoKahoot.jugadorUsaMultiplicador(2));
//    }
//
//    @Test
//    public void test05SiUnJugadorUsaExclusividadAlgoKahootAsignaCorrectamenteElPuntaje() {
//        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");
//
//        //Estas lineas son para debuggear, despues refactorizo mejor
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
//        ///////////////////////////////////////////////////////////////////
//
//        algoKahoot.jugadorUsaExclusividad();
//        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2))));
//        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1))));
//        assertEquals(6, algoKahoot.jugadorActualPuntaje());
//    }
//
//    @Test
//    public void test06SiAmbosJugadoresUsanExclusividadAlgoKahootCuadruplicaElPuntajeDelQueContestaCorrectamente() {
//        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");
//
//        //Estas lineas son para debuggear, despues refactorizo mejor
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
//        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
//        ///////////////////////////////////////////////////////////////////
//
//        algoKahoot.jugadorUsaExclusividad();
//        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 3))));
//        algoKahoot.jugadorUsaExclusividad();
//        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2))));
//        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
//        algoKahoot.cambiarJugador();
//        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();
//        assertEquals(Arrays.asList(0, 12), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
//    }

    private List<Integer> jugadoresPuntos(AlgoKahoot algoKahoot) {
        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        return Arrays.asList(puntosJugadorUno, puntosJugadorDos);
    }

    @Test
    public void test08PruebasIntegrales() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        //// Ronda 1
        // Camila
        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        // Delfina
        algoKahoot.jugadorUsaMultiplicador(3);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        // Puntos
        assertEquals(Arrays.asList(2, -3), jugadoresPuntos(algoKahoot));

        //// Ronda 2
        // Camila
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 3))));
        // Delfina
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        // Puntos
        assertEquals(Arrays.asList(2, 1), jugadoresPuntos(algoKahoot));

        //// Ronda 3
        // Camila
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(3, 0, 1, 2)));
        // Delfina
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(3, 1, 2, 0)));
        // Puntos
        assertEquals(Arrays.asList(2, 5), jugadoresPuntos(algoKahoot));

        //// Ronda 4
        // Camila
        algoKahoot.cargarRespuesta(new RespuestaGroupChoice(new HashSet<>(Arrays.asList(1, 2, 4)), new HashSet<>(Arrays.asList(0, 3))));
        // Delfina
        algoKahoot.cargarRespuesta(new RespuestaGroupChoice(new HashSet<>(Arrays.asList(1, 3)), new HashSet<>(Arrays.asList(0, 2, 4))));
        // Puntos
        assertEquals(Arrays.asList(3, 5), jugadoresPuntos(algoKahoot));
    }

}
