package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void VerdaderoFalsoClasicoPuedeCrearseSiSeIndicaLaRtaCorreta(){
        VerdaderoFalso preguntaVF = new VerdaderoFalso("La manzana es azul",false);
        assertEquals(1, preguntaVF.responder(false));
    }

    @Test
    public void VerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaPuntos(){
        VerdaderoFalso preguntaVF = new VerdaderoFalso("La manzana es azul",false);
        assertEquals(new ArrayList<>(Arrays.asList(0, 1)), preguntaVF.responderLista(new ArrayList<>(Arrays.asList(true, false))));
    }

    @Test
    public void VerdaderoFalsoConPenalidadDevuelvePuntajeCorrecto(){
        VerdaderoFalso preguntaVF = VerdaderoFalso.VerdaderoFalsoPenalidad("La manzana es azul", false);
        assertEquals(-1, preguntaVF.responder(true));
    }

}