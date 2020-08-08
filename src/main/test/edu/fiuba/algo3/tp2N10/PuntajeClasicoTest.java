package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Puntaje.PuntajeClasico;
import edu.fiuba.algo3.tp2N10.Respuesta.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {

    @Test
    public void tipoPuntajeClasicoParaMultipleChoicePuntuaCorrectamenteParaVariosAciertos(){
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2)));
        PuntajeClasico tipoPuntaje = PuntajeClasico.PuntajeParaMultipleChoice(respuestaCorrecta);
        assertEquals(1, tipoPuntaje.puntuar(Arrays.asList(3,0)));
    }

    @Test
    public void tipoPuntajeClasicoParaMultipleChoicePuntuaCorrectamenteParaVariosAciertosYUnError(){
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(0, 1, 2, 3)));
        PuntajeClasico tipoPuntaje = PuntajeClasico.PuntajeParaMultipleChoice(respuestaCorrecta);
        assertEquals(0, tipoPuntaje.puntuar(Arrays.asList(3,1)));
    }

    @Test
    public void tipoPuntajeClasicoParaVerdaderoFalsoPuntuaCorrectamenteParaVariosErrores(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.PuntajeParaVerdaderoFalso();
        assertEquals(0, tipoPuntaje.puntuar(Arrays.asList(0,1)));
    }

    @Test
    public void tipoPuntajeClasicoParaVerdaderoFalsoPuntuaCorrectamenteParaVariosAciertos(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.PuntajeParaVerdaderoFalso();
        assertEquals(1, tipoPuntaje.puntuar(Arrays.asList(1,0)));
    }

    @Test
    public void tipoPuntajeClasicoParaVerdaderoFalsoPuntuaCorrectamenteSinAciertosNiErrores(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.PuntajeParaVerdaderoFalso();
        assertEquals(0, tipoPuntaje.puntuar(Arrays.asList(0,0)));
    }

}