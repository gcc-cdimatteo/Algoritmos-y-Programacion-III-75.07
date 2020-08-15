package edu.fiuba.algo3.tp2N10.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Multiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadorTest {

    @Test
    public void test01MultiplicadorPorDosIncrementaElPuntaje() {
        Multiplicador miMultiplicador = new Multiplicador(2);
        assertEquals(10, miMultiplicador.multiplicar(5));
    }

    @Test
    public void test02MultiplicadorNoSePuedeUsarDosVeces() {
        Multiplicador miMultiplicador = new Multiplicador(3);
        miMultiplicador.usar();
        assertThrows(PowerUpNoDisponibleException.class, miMultiplicador::usar);
    }
}
