package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void verdaderoFalsoClasicoPuedeCrearseSiSeIndicaLaRtaCorreta(){
        VerdaderoFalso preguntaVF = new VerdaderoFalso("La manzana es azul",false);
        assertEquals(1, preguntaVF.responder(false));
    }

    @Test
    public void verdaderoFalsoConPenalidadDevuelvePuntajeCorrecto(){
        VerdaderoFalso preguntaVF = new VerdaderoFalso("La manzana es azul",false);
        preguntaVF.conPenalidad();
        assertEquals(-1, preguntaVF.responder(true));
    }

}