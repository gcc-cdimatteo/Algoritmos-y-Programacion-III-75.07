package edu.fiuba.algo3.tp2N10.Modelo.PowerUps;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.MultiplicadorUsadoException;

public class Multiplicador {

    final private int valor;
    private int usos = 1;

    public Multiplicador(int valor) {
        this.valor = valor;
    }

    public Integer multiplicar(Integer unPuntaje) {
        if (usos == 0) throw new MultiplicadorUsadoException();
        usos -= 1;
        return unPuntaje * this.valor;
    }
}
