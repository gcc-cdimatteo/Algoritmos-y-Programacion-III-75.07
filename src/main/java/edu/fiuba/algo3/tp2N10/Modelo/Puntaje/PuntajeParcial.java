package edu.fiuba.algo3.tp2N10.Modelo.Puntaje;

public class PuntajeParcial implements Puntaje {

    @Override
    public Integer puntuar(Integer aciertos, Integer errores) {
        return errores == 0 ? aciertos : 0;
    }
}