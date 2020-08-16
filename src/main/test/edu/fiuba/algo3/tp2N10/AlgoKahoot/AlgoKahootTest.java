package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
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

    private final List<Pregunta> preguntas = new ArrayList<>();

    public void agregarPreguntaVF() {
        PreguntaVerdaderoFalso miPreguntaVF = PreguntaVerdaderoFalso.Penalidad("La manzana es azul", false);
        preguntas.add(miPreguntaVF);
    }

    public void agregarPreguntaMC() {
        PreguntaMultipleChoice miPreguntaMC = PreguntaMultipleChoice.Clasico("Los ingredientes para hacer chipa son...", Arrays.asList("Queso", "Salame", "Leche", "Sal", "Manteca"), new HashSet<>(Arrays.asList(0, 2, 3, 4)));
        preguntas.add(miPreguntaMC);
    }

    public void agregarPreguntaOC() {
        PreguntaOrderedChoice miPreguntaOC = new PreguntaOrderedChoice("El orden de las letras del abecedario es...", Arrays.asList("A", "B", "C"), Arrays.asList(1, 2, 3));
        preguntas.add(miPreguntaOC);
    }

    public void agregarPreguntaGC() {
        PreguntaGroupChoice miPreguntaGC = new PreguntaGroupChoice("Ordene las opciones en los grupos correctos...", Arrays.asList("A", "1", "B", "2"), new HashSet<>(Arrays.asList(0, 2)), new HashSet<>(Arrays.asList(1, 3)));
        preguntas.add(miPreguntaGC);
    }

    public AlgoKahoot creoUnAlgoKahoot() {
        return new AlgoKahoot(preguntas, "Delfina", "Camila");
    }

    @Test
    public void test01AlgoKahootPuedeCrearseSiSeIndicanLasPreguntasYElNombreDeLosJugadores() {
        assertEquals(AlgoKahoot.class, creoUnAlgoKahoot().getClass());
    }

    @Test
    public void test02AlgoKahootRecibeYProcesaLaRespuestaDeTodosLosJugadoresCambiandoDeTurno() {
        agregarPreguntaVF();
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();

        assertEquals(Arrays.asList(-1, 1), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test03LosJugadoresPuedenUsarMultiplicadoresAntesDeResponder() {
        agregarPreguntaVF();
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.jugadorUsaMultiplicador(3);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        algoKahoot.jugadorUsaMultiplicador(2);
        algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();

        assertEquals(Arrays.asList(-3, 2), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }

    @Test
    public void test04UnJugadorNoPuedeUsarUnMultiplicadorMasDeUnaVez() {
        agregarPreguntaVF();
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();

        algoKahoot.jugadorUsaMultiplicador(2);

        assertThrows(PowerUpNoDisponibleException.class, () -> algoKahoot.jugadorUsaMultiplicador(2));
    }

    @Test
    public void test05SiUnJugadorUsaExclusividadAlgoKahootDuplicaSuPuntaje() {
        agregarPreguntaMC();
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 2, 3, 4))));
        algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 3, 4))));
        assertEquals(2, algoKahoot.jugadorActualPuntaje());
    }

    @Test
    public void test06SiAmbosJugadoresUsanExclusividadAlgoKahootCuatriplicaElPuntajeDelQueContestaCorrectamente() {
        agregarPreguntaOC();
        AlgoKahoot algoKahoot = creoUnAlgoKahoot();
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(1, 2, 3)));
        algoKahoot.jugadorUsaExclusividad();
        algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(Arrays.asList(1, 3, 2)));
        Integer puntosJugadorUno = algoKahoot.jugadorActualPuntaje();
        algoKahoot.cambiarJugador();
        Integer puntosJugadorDos = algoKahoot.jugadorActualPuntaje();
        assertEquals(Arrays.asList(4, 0), Arrays.asList(puntosJugadorUno, puntosJugadorDos));
    }
}
