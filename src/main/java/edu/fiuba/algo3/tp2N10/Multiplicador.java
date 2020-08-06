package edu.fiuba.algo3.tp2N10;

public class Multiplicador {

    private int valor;
    private int usos = 1;

    public Multiplicador(int valor) {
        this.valor = valor;
    }

    public Integer multiplicar(Integer unPuntaje) throws MultiplicadorUsadoException {
        if (usos == 0) throw new MultiplicadorUsadoException();
        usos -= 1;
        return unPuntaje * this.valor;
    }
}
