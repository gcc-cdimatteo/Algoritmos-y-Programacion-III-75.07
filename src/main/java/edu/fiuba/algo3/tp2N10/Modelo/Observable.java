package edu.fiuba.algo3.tp2N10.Modelo;

public interface Observable {

    void notifyObservers();

    void addObserver(Observer observer);
}
