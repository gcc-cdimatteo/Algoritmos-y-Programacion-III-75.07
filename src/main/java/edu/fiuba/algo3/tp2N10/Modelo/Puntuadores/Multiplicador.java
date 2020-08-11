package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;

public class Multiplicador {

    private int valor;
    private int usosDisponibles = 1;

    public Multiplicador(int valor) {
        this.valor = valor;
    }

    public void usar() {
        if (usosDisponibles == 0) throw new PowerUpNoDisponibleException();
        usosDisponibles -= 1;
    }

    public Integer multiplicar(Integer unPuntaje) {
        return unPuntaje * valor;
    }
}
