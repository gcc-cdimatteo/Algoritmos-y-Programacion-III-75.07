package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeClasico;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {

    @Test
    public void tipoPuntajeClasicoParaMultipleChoicePuntuaCorrectamenteParaVariosAciertos() {
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(0, 1, 2));
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaMultipleChoice(opcionesCorrectas);
        assertEquals(1, tipoPuntaje.puntuar(3,0));
    }

    @Test
    public void tipoPuntajeClasicoParaMultipleChoicePuntuaCorrectamenteParaVariosAciertosYUnError(){
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(0, 1, 2, 3));
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaMultipleChoice(opcionesCorrectas);
        assertEquals(0, tipoPuntaje.puntuar(3,1));
    }

    @Test
    public void tipoPuntajeClasicoParaVerdaderoFalsoPuntuaCorrectamenteParaVariosErrores(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaVerdaderoFalso();
        assertEquals(0, tipoPuntaje.puntuar(0,1));
    }

    @Test
    public void tipoPuntajeClasicoParaVerdaderoFalsoPuntuaCorrectamenteParaVariosAciertos(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaVerdaderoFalso();
        assertEquals(1, tipoPuntaje.puntuar(1,0));
    }

    @Test
    public void tipoPuntajeClasicoParaVerdaderoFalsoPuntuaCorrectamenteSinAciertosNiErrores(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaVerdaderoFalso();
        assertEquals(0, tipoPuntaje.puntuar(0,0));
    }

}