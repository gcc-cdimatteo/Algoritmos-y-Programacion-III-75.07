package edu.fiuba.algo3.tp2N10.Respuesta;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.RespuestaIncompatibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeClasico;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaMultipleChoiceTest {

    private RespuestaMultipleChoice respuestaCorrecta;

    public void setupRespuestaCorrecta() {
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(4, 5, 2));
        this.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, PuntajeClasico.ParaMultipleChoice(opcionesCorrectas));
    }

    @Test
    public void test01LaInterseccionEntreDosRespuestasMultipleChoiceEsLaInterseccionEntreSusOpciones() {
        setupRespuestaCorrecta();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 4)));
        assertEquals(new HashSet<>(Arrays.asList(2, 4)), respuestaCorrecta.intersection(respuesta));
    }

    @Test
    public void test02ElTamañoDeUnaRespuestaMultipleChoiceEsElDeSusOpciones() {
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 4)));
        assertEquals(3, respuesta.size());
    }

    @Test
    public void test03UnaRespuestaMultipleChoiceCorrectaValeUnPunto() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 2, 5)));
        assertEquals(1, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test04UnaRespuestaMultipleChoiceIncorrectaValeCeroPuntosSinPenalidad() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(3, 5)));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test05SiSeIngresaUnaRespuestaIncompatibleSeLanzaUnaExcepcion() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(1, 2, 3));
        assertThrows(RespuestaIncompatibleException.class, () -> respuestaCorrecta.evaluar(respuesta));
    }
}
