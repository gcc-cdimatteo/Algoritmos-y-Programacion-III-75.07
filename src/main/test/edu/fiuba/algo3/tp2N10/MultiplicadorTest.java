package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Excepciones.MultiplicadorUsadoException;
import edu.fiuba.algo3.tp2N10.PowerUps.Multiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadorTest {

    @Test
    public void testMultiplicadorPorDosIncrementaElPuntaje() {
        Multiplicador miMultiplicador = new Multiplicador(2);
        assertEquals(10, miMultiplicador.multiplicar(5));
    }

    @Test
    public void testMultiplicadorPorDosNoSePuedeUsarDosVeces() {
        Multiplicador miMultiplicador = new Multiplicador(3);
        miMultiplicador.multiplicar(2);
        assertThrows(MultiplicadorUsadoException.class, () -> {
            miMultiplicador.multiplicar(5);
        });
    }

}
