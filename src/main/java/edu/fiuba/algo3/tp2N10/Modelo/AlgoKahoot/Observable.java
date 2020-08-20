package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

public interface Observable {

    void notifyObservers();

    void addObserver(Observer observer);
}
