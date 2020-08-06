package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    private VerdaderoFalso preguntaVF;
    private RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
    private RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso(true);


    private void crearVerdaderoFalsoClasico() {
        this.preguntaVF = new VerdaderoFalso("La manzana es azul", this.respuestaCorrecta);
    }

    private void crearVerdaderoFalsoPenalidad() {
        this.preguntaVF = VerdaderoFalso.VerdaderoFalsoPenalidad("La manzana es azul", this.respuestaCorrecta);
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