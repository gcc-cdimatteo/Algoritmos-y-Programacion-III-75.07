package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoTest {

    private PreguntaVerdaderoFalso preguntaVF;
    private RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso("Falso");
    private RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso("Verdadero");


    private void crearVerdaderoFalsoClasico() {
        Enunciado miEnunciado = new Enunciado("La manzana es azul", Arrays.asList("Verdadero", "Falso"));
        this.preguntaVF = new PreguntaVerdaderoFalso(miEnunciado, this.respuestaCorrecta);
    }

    private void crearVerdaderoFalsoPenalidad() {
        Enunciado miEnunciado = new Enunciado("La manzana es azul", Arrays.asList("Verdadero", "Falso"));
        this.preguntaVF = PreguntaVerdaderoFalso.Penalidad(miEnunciado, this.respuestaCorrecta);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Clasico
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void verdaderoFalsoClasicoPuedeCrearseSiSeIndicaLaRtaCorreta(){
        crearVerdaderoFalsoClasico();
        assertEquals(Collections.singletonList(1), this.preguntaVF.responder(Collections.singletonList(this.respuestaCorrecta)));
    }

    @Test
    public void verdaderoFalsoClasicoDevuelvePuntajeCorrecto() {
        crearVerdaderoFalsoClasico();
        assertEquals(Arrays.asList(1, 0), this.preguntaVF.responder(Arrays.asList(this.respuestaCorrecta, this.respuestaIncorrecta)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Penalidad
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void VerdaderoFalsoConPenalidadDevuelvePuntajeCorrecto(){
        crearVerdaderoFalsoPenalidad();
        assertEquals(Collections.singletonList(1), this.preguntaVF.responder(Collections.singletonList(this.respuestaCorrecta)));
    }

    @Test
    public void VerdaderoFalsoPenalidadRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearVerdaderoFalsoPenalidad();
        assertEquals(Arrays.asList(-1, 1), this.preguntaVF.responder(Arrays.asList(this.respuestaIncorrecta, this.respuestaCorrecta)));
    }

}