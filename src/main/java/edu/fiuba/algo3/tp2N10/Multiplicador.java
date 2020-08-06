package edu.fiuba.algo3.tp2N10;

public class Multiplicador {

    private final int valor;

    public Multiplicador(int valor) {
        this.valor = valor;
    }

    public Integer multiplicar(Integer unPuntaje) {
        return unPuntaje * this.valor;
    }
}
