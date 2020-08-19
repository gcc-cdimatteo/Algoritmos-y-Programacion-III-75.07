package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;

public class Multiplicador {

    private int valor;
    private boolean disponible = true;

    public Multiplicador(int valor) {
        this.valor = valor;
    }

    public void usar() {
        if (!disponible) throw new PowerUpNoDisponibleException();
        disponible = false;
    }

    public Integer multiplicar(Integer unPuntaje) {
        return unPuntaje * valor;
    }

    public boolean estaDisponible() { return disponible; }
}
