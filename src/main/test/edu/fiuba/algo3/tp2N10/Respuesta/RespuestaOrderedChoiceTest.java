package edu.fiuba.algo3.tp2N10.Respuesta;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.RespuestaIncompatibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaOrderedChoiceTest {

    private RespuestaOrderedChoice respuestaCorrecta;

    public void setupRespuestaCorrecta() {
        this.respuestaCorrecta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1, 3));
    }

    @Test
    public void test01DosRespuestasOrderedChoiceSonIgualesSiAmbasTienenSusOpcionesEnElMismoOrden() {
        setupRespuestaCorrecta();
        RespuestaOrderedChoice respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1, 3));
        assertTrue(respuestaCorrecta.equals(respuesta));
    }

    @Test
    public void test02UnaRespuestaOrderedChoiceCorrectaValeUnPunto() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1, 3));
        assertEquals(1, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test03UnaRespuestaOrderedChoiceIncorrectaValeCeroPuntos() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 3, 1));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test04SiSeIngresaUnaRespuestaIncompatibleSeLanzaUnaExcepcion() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaVerdaderoFalso(true);
        assertThrows(RespuestaIncompatibleException.class, () -> respuestaCorrecta.evaluar(respuesta));
    }
}
