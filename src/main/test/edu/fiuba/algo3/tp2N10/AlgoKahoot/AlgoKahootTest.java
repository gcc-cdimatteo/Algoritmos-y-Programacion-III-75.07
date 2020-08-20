package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.FactoryPreguntas;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

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

        assertEquals(Arrays.asList(1, -1), algoKahoot.puntajes());
    }

    @Test
    public void test03LosJugadoresPuedenUsarMultiplicadoresAntesDeResponder() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        algoKahoot.jugadorUsaMultiplicador(3);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));

        assertEquals(Arrays.asList(3, -2), algoKahoot.puntajes());
    }

    @Test
    public void test04SiUnJugadorUsaExclusividadAlgoKahootAsignaCorrectamenteElPuntaje() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));

        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1))));
        assertEquals(1, algoKahoot.jugadorPuntaje());
    }

    @Test
    public void test05SiUnJugadorNoRespondeSuRespuestaEsIncorrecta() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.jugadorNoResponde();

        assertEquals(Arrays.asList(1, -1), algoKahoot.puntajes());
    }

    @Test
    public void test06SiAmbosJugadoresUsanExclusividadAlgoKahootCuadruplicaElPuntajeDelQueContestaCorrectamente() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot("preguntas_test.json");

        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));

        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2))));
        assertEquals(Arrays.asList(3, -1), algoKahoot.puntajes());
    }

    @Test
    public void test07ElJuegoFinalizaCuandoNoHayMasPreguntas() {
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
        assertEquals(Arrays.asList(2, -3), algoKahoot.puntajes());

        //// Ronda 2
        // Camila
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 3))));
        // Delfina
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 2))));
        // Puntos
        assertEquals(Arrays.asList(2, 1), algoKahoot.puntajes());

        //// Ronda 3
        // Camila
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(3, 0, 1, 2)));
        // Delfina
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(3, 1, 2, 0)));
        // Puntos
        assertEquals(Arrays.asList(2, 5), algoKahoot.puntajes());

        //// Ronda 4
        // Camila
        algoKahoot.cargarRespuesta(new RespuestaGroupChoice(new HashSet<>(Arrays.asList(1, 2, 4)), new HashSet<>(Arrays.asList(0, 3))));
        // Delfina
        algoKahoot.cargarRespuesta(new RespuestaGroupChoice(new HashSet<>(Arrays.asList(1, 3)), new HashSet<>(Arrays.asList(0, 2, 4))));
        // Puntos
        assertEquals(Arrays.asList(3, 5), algoKahoot.puntajes());
        assertTrue(algoKahoot.finalizado());
    }

}
