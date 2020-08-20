package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.FactoryPreguntas;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoKahootTest {
    public AlgoKahoot creoUnAlgoKahoot(String archivoNombre) {
        try {
            FactoryPreguntas factory = new FactoryPreguntas(archivoNombre);
            return new AlgoKahoot(factory.preguntas(), "Delfina", "Camila");
        } catch (IOException e) {
            return null;
        }
    }

    @Test
    public void test01AlgoKahootPuedeCrearseSiSeIndicaElNombreDelArchivoJSONDePreguntasYElNombreDeLosJugadores() {
        assertEquals(AlgoKahoot.class, creoUnAlgoKahoot("preguntas_test.json").getClass());
    }

    @Test
    public void test02AlgoKahootRecibeYProcesaLaRespuestaDeTodosLosJugadoresCambiandoDeTurno() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));

        Integer puntosJugadorUno = algoKahoot.jugadorPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorPuntaje();

        assertEquals(Arrays.asList(1, -1), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test03LosJugadoresPuedenUsarMultiplicadoresAntesDeResponder() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        algoKahoot.jugadorUsaMultiplicador(3);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        Integer puntosJugadorUno = algoKahoot.jugadorPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorPuntaje();

        assertEquals(Arrays.asList(3, -2), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test04SiUnJugadorUsaExclusividadAlgoKahootAsignaCorrectamenteElPuntaje() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        //Estas lineas son para debuggear, despues refactorizo mejor
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        ///////////////////////////////////////////////////////////////////

        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1))));
        assertEquals(1, algoKahoot.jugadorPuntaje());
    }

    @Test
    public void test05SiAmbosJugadoresUsanExclusividadAlgoKahootCuadruplicaElPuntajeDelQueContestaCorrectamente() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        //Estas lineas son para debuggear, despues refactorizo mejor
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        ///////////////////////////////////////////////////////////////////

        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2))));
        Integer puntosJugadorUno = algoKahoot.jugadorPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorPuntaje();
        assertEquals(Arrays.asList(3, -1), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test06AlFinalDelJuegoSeLanzaUnaExcepcion() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        //// Ronda 1
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        //// Ronda 2
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 3))));
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        //// Ronda 3
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(3, 0, 1, 2)));
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(3, 1, 2, 0)));
        //// Ronda 4
        algoKahoot.cargarRespuesta(new RespuestaGroupChoice(new HashSet<>(Arrays.asList(1, 2, 4)), new HashSet<>(Arrays.asList(0, 3))));
        algoKahoot.cargarRespuesta(new RespuestaGroupChoice(new HashSet<>(Arrays.asList(1, 3)), new HashSet<>(Arrays.asList(0, 2, 4))));
        
        assertTrue(algoKahoot.finalizado());
    }

    private List<Integer> jugadoresPuntos(AlgoKahoot algoKahoot) {
        Integer puntosJugadorUno = algoKahoot.jugadorPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorPuntaje();
        algoKahoot.cambiarJugador();
        return Arrays.asList(puntosJugadorUno, puntosJugadorDos);
    }

    @Test
    public void test07PruebasIntegrales() {
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
