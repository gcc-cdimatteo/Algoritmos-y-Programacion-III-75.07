package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Vista.Observer;

public interface Observable {

    void notifyObservers();

    void addObserver(Observer observer);
}
