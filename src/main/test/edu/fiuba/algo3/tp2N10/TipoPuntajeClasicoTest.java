package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoPuntajeClasicoTest {

    @Test
    public void tipoPuntajeClasicoPuntuaCorrectamente(){
        TipoPuntajeClasico tipoPuntaje = new TipoPuntajeClasico();
        assertEquals(1, tipoPuntaje.puntuar(Arrays.asList(1,0)));
    }

    @Test
    public void tipoPuntajeClasicoPuntuaCorrectamenteParaVariosAciertos(){
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Multiple", "Choice", "Clasico")));
        TipoPuntajeClasico tipoPuntaje = TipoPuntajeClasico.TipoPuntajeClasicoParaMC(respuestaCorrecta);
        assertEquals(1, tipoPuntaje.puntuar(Arrays.asList(3,0)));
    }

    @Test
    public void tipoPuntajeClasicoPuntuaCorrectamenteParaVariosAciertosYUnError(){
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Multiple", "Choice", "Clasico")));
        TipoPuntajeClasico tipoPuntaje = TipoPuntajeClasico.TipoPuntajeClasicoParaMC(respuestaCorrecta);
        assertEquals(0, tipoPuntaje.puntuar(Arrays.asList(3,1)));
    }

    @Test
    public void tipoPuntajeClasicoPuntuaCorrectamenteParaVariosErrores(){
        TipoPuntajeClasico tipoPuntaje = new TipoPuntajeClasico();
        assertEquals(0, tipoPuntaje.puntuar(Arrays.asList(0,2)));
    }

    @Test
    public void tipoPuntajeClasicoPuntuaCorrectamenteSinAciertosNiErrores(){
        TipoPuntajeClasico tipoPuntaje = new TipoPuntajeClasico();
        assertEquals(0, tipoPuntaje.puntuar(Arrays.asList(0,0)));
    }
}