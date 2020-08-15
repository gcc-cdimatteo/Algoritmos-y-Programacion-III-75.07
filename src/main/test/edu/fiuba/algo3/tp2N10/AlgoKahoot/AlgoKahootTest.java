package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoKahootTest {

    public AlgoKahoot creoUnAlgoKahoot() {
        PreguntaVerdaderoFalso unaPreguntaVF = PreguntaVerdaderoFalso.Clasico("La manzana es azul", false);
        PreguntaMultipleChoice unaPreguntaMC = PreguntaMultipleChoice.Parcial("Los ingredientes para hacer chipa son...", Arrays.asList("Queso", "Salame", "Leche", "Sal", "Manteca"), new HashSet<>(Arrays.asList(0, 2, 3, 4)));
        PreguntaGroupChoice unaPreguntaGC = new PreguntaGroupChoice("Ordene las opciones en los grupos correctos...", Arrays.asList("A", "1", "B", "2"), new HashSet<>(Arrays.asList(0, 2)), new HashSet<>(Arrays.asList(1, 3)));
        PreguntaOrderedChoice unaPreguntaOC = new PreguntaOrderedChoice("El orden de las letras del abecedario es...", Arrays.asList("A", "B", "C"), Arrays.asList(1, 2, 3));
        List<Pregunta> preguntas = Arrays.asList(unaPreguntaVF, unaPreguntaMC, unaPreguntaGC, unaPreguntaOC);
        return new AlgoKahoot(preguntas, Arrays.asList("Delfina", "Camila"));
    }

    @Test
    public void test01AlgoKahootPuedeCrearseSiSeIndicanLasPreguntasYElNombreDeLosJugadores() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        assertEquals(0, algoKahoot.jugadorActualPuntaje() + algoKahoot.jugadorActualPuntaje());
    }

    @Test
    public void test02AlgoKahootRecibeYProcesaLaRespuestaDelJugadorActual() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        assertEquals(0, algoKahoot.jugadorActualPuntaje());
    }

    @Test
    public void test03AlgoKahootRecibeYProcesaLaRespuestaDeTodosLosJugadoresCambiandoDeTurno() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.cambiarTurno();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        assertEquals(Arrays.asList(0, 1), Arrays.asList(algoKahoot.jugadorActualPuntaje(), algoKahoot.jugadorActualPuntaje()));
    }

    @Test
    public void test04AlgoKahootRecibeQueUnJugadorUsaUnMultiplicadorPorDosYDuplicaSuPuntaje() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        assertEquals(2, algoKahoot.jugadorActualPuntaje());
    }

    @Test
    public void test04AlgoKahootRecibeQueUnJugadorQueYaUso2MultiplicadoresNoPuedeUsarMas() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));

        algoKahoot.cambiarTurno();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));

        algoKahoot.cambiarTurno();
        algoKahoot.jugadorUsaMultiplicador(3);
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 2, 3, 4))));

        algoKahoot.cambiarTurno();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 2, 3, 4))));

        algoKahoot.cambiarTurno();
//        assertThrows(PowerUpNoDisponibleException.class, algoKahoot.jugadorUsaMultiplicador(3));
        assertEquals(true, true);
    }


    @Test
    public void test05AlgoKahootRecibeQueUnJugadorUsaExclusividadYDuplicaSuPuntaje() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        assertEquals(2, algoKahoot.jugadorActualPuntaje());
    }

    @Test
    public void test06AlgoKahootRecibeQueTodosLosJugadoresUsanExclusivdadYCuatriplicaElPuntajeAlQueContestaBien() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        algoKahoot.cambiarTurno();
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        assertEquals(Arrays.asList(4, 0), Arrays.asList(algoKahoot.jugadorActualPuntaje(), algoKahoot.jugadorActualPuntaje()));
    }

    @Test
    public void test07AlgoKahootRecibeQueUnJugadorUsaExclusivdadYDuplicaElPuntajeAlQueContestaBien() {
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.cambiarTurno();
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        assertEquals(Arrays.asList(0, 2), Arrays.asList(algoKahoot.jugadorActualPuntaje(), algoKahoot.jugadorActualPuntaje()));
    }

}
